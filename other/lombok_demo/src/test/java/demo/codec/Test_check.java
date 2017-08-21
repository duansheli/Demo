
package demo.codec;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;

/**
 * <pre>
 *  MD5/SHA1/HMAC  单向加密，不可逆，通常用来计算下载的文件是否损坏。也可用于rest服务中的数据签名验证。
 *  aes/des
 *  RSA  非对称加密，分公钥和私钥
 *  HMAC算法有一个密钥，增强了数据传输过程中的安全性，强化了算法外的不可控因素。
 *  
 *  参考 http://snowolf.iteye.com/category/68576
 * </pre>
 */
public class Test_check {
    static String str = "a";

    @Test
    public void test3_sha() throws Exception {
        String sha1Hex = DigestUtils.sha1Hex(str);
        System.out.println(sha1Hex);
    }

    @Test
    public void test2_base64() throws Exception {
        byte[] b = Base64.encodeBase64(str.getBytes(Charsets.UTF_8), true);
        String str = new String(b, Charsets.UTF_8);
        System.out.println(str);

        byte[] b2 = Base64.decodeBase64(str.getBytes(Charsets.UTF_8));
        System.out.println(new String(b2, Charsets.UTF_8));
    }

    @Test
    public void test1_md5() throws Exception {
        String md5_1 = DigestUtils.md5Hex(str);
        System.out.println("方式一： " + md5_1);

        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        md5Digest.update(str.getBytes());
        // 默认有16个byte(128bit)。 两位16进制数ff为255即8位 ,1字节有8位，所有每个字节(8位)可得到两个字符。
        byte[] md5Encoded = md5Digest.digest();

        String md5_2 = bytesToHex(md5Encoded);
        String md5_3 = Strings.padStart(new BigInteger(1, md5Encoded).toString(16), 32, '0');// 有可能不到32位，所以前面补0
        String md5_4 = Hex.encodeHexString(md5Encoded);
        System.out.println(md5_2);
        System.out.println(md5_3);
        System.out.println(md5_4);
    }

    static String bytesToHex(byte[] bytes) {
        StringBuilder md5str = new StringBuilder();
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {// 相当于加256
                digital = digital & 0xFF;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            // 把数组每一字节换成16进制连成md5字符串
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    /**
     * MAC算法可选以下多种算法
     * 
     * <pre>
     * HmacMD5 
     * HmacSHA1 
     * HmacSHA256 
     * HmacSHA384 
     * HmacSHA512
     * </pre>
     */
    static final String ALGORITHM_MAC = "HmacMD5";

    /**
     * <pre>
     * 单向加密，不可逆
     * </pre>
     */
    @Test
    public void test4_hmac() throws Exception {
        String source = "hello";
        String mac_secret_key = "pwd123";

        SecretKey secretKey = new SecretKeySpec(mac_secret_key.getBytes("UTF-8"), ALGORITHM_MAC);
        Mac mac = Mac.getInstance(ALGORITHM_MAC);
        mac.init(secretKey);
        mac.update(source.getBytes("UTF-8"));

        byte[] bs = mac.doFinal();
        byte[] bs2 = new Hex().encode(bs);
        String string = new String(bs2);
        System.out.println(string);
    }

    @Test
    public void test5_des() throws Exception {
        // 1.1 加密方式：DES也可以是AES或者Blowfish 待加密数据：test_str
        String ALGORITHM = "AES";
        String realStr = "test_str";
        // 1.2 生成加密key
        SecureRandom secureRandom = secureRandom = new SecureRandom();
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(secureRandom);
        SecretKey secretKey = kg.generateKey();

        String key_str = Base64.encodeBase64String(secretKey.getEncoded());

        System.err.println("原文:\t" + realStr);
        System.err.println("密钥:\t" + key_str);

        // 2.1 使用key_str生成des的key对象
        Key k = new SecretKeySpec(Base64.decodeBase64(key_str), ALGORITHM);

        // 2.2 加密模式
        Cipher encryptCipher = Cipher.getInstance(ALGORITHM);
        encryptCipher.init(Cipher.ENCRYPT_MODE, k);
        byte[] inputData = encryptCipher.doFinal(realStr.getBytes());

        String result = Base64.encodeBase64String(inputData);
        System.err.println("加密后:\t" + result);

        String str2 = result;
        // 2.3 解密模式
        byte[] decodeBuffer = Base64.decodeBase64(str2);
        Cipher decryptCipher = Cipher.getInstance(ALGORITHM);
        decryptCipher.init(Cipher.DECRYPT_MODE, k);
        String outputStr = new String(decryptCipher.doFinal(decodeBuffer));

        System.err.println("解密后:\t" + outputStr);

        assertEquals(realStr, outputStr);
    }
}
