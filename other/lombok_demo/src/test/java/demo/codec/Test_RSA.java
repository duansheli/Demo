package demo.codec;

import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

public class Test_RSA {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    String publicKeyStr;
    String privateKeyStr;

    @Before
    public void setUp() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        publicKeyStr = Base64.encodeBase64String(publicKey.getEncoded());
        privateKeyStr = Base64.encodeBase64String(privateKey.getEncoded());
        System.err.println("公钥: " + publicKeyStr);
        System.err.println("私钥：  " + privateKeyStr);
    }

    /**
     * 私钥加密——公钥解密
     */
    @Test
    public void testSign() throws Exception {
        String inputStr = "test_rsa";
        String test_private_key = privateKeyStr;
        String test_public_key = publicKeyStr;

        System.err.println("加密前: " + inputStr);
        byte[] encodedData = private_key_encode(inputStr, test_private_key);
        System.err.println("加密结束 ----------" + encodedData);

        byte[] decodedData = public_key_decode(test_public_key, encodedData);
        System.err.println("解密后: " + new String(decodedData));

    }

    @Test
    public void test_sign() throws Exception {
        String test_private_key = privateKeyStr;
        String test_public_key = publicKeyStr;

        System.err.println("私钥签名——公钥验证签名");
        byte[] encodedData = "test_sign".getBytes();
        // 产生签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(
                new PKCS8EncodedKeySpec(Base64.decodeBase64(test_private_key.getBytes(StandardCharsets.UTF_8)))));
        signature.update(encodedData);

        String sign = Base64.encodeBase64String(signature.sign());
        System.err.println("签名:\r" + sign);

        // 验证签名
        Signature pulblic_signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        pulblic_signature.initVerify(KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(
                new X509EncodedKeySpec(Base64.decodeBase64(test_public_key.getBytes(StandardCharsets.UTF_8)))));
        pulblic_signature.update(encodedData);
        // 验证签名是否正常
        boolean status = pulblic_signature.verify(Base64.decodeBase64(sign.getBytes(StandardCharsets.UTF_8)));
        System.err.println("状态:\r" + status);
        assertTrue(status);
    }

    /**
     * 通过公钥对字符串加密
     */
    private byte[] public_key_decode(String test_public_key, byte[] encodedData) throws Exception {
        KeyFactory keyFactory2 = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher2 = Cipher.getInstance(keyFactory2.getAlgorithm());
        // 加密模式
        cipher2.init(Cipher.DECRYPT_MODE, keyFactory2.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(test_public_key.getBytes(StandardCharsets.UTF_8)))));

        return cipher2.doFinal(encodedData);
    }

    /**
     * 通过私钥对字符串加密
     */
    private byte[] private_key_encode(String decodeStr, String test_private_key) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        // 解密模式
        cipher.init(Cipher.ENCRYPT_MODE, keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(test_private_key.getBytes(StandardCharsets.UTF_8)))));

        return cipher.doFinal(decodeStr.getBytes());
    }

}
