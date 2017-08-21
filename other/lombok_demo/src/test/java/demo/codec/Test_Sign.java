
package demo.codec;

import static org.junit.Assert.assertEquals;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Bytes;

public class Test_Sign {

    @Test
    public void test1_simple() {
        // 签名都是针对二进制数据，所以这里使用二进制
        byte[] realData = "test_sign".getBytes(StandardCharsets.UTF_8);
        byte[] secretKey = "pwd111".getBytes(StandardCharsets.UTF_8);
        // 1. 签名
        byte[] concat = Bytes.concat(realData, secretKey);
        String md5_1 = DigestUtils.md5Hex(concat);
        // 2. 发送
        byte[] sendData = realData.clone();
        String checkSign = md5_1;

        // 3. 收到数据后检查签名
        // 服务端收到了数据与签名，通过相同的secretKey对数据签名
        byte[] concat2 = Bytes.concat(sendData, "pwd111".getBytes(StandardCharsets.UTF_8));
        String realSign = DigestUtils.md5Hex(concat2);

        // 对比两个签名以确定数据是否损坏
        System.out.println(realSign.equals(checkSign));
        assertEquals(checkSign, realSign);
    }

    @Test
    public void test2_url_query() {
        // 1. 公共数据
        String signKey = "sign";

        String public_key = "pwd1";
        System.out.println("--------- 客户端发送数据 -----------");
        // http请求下，需要发送的数据
        String sendStr = "name=peter&pwd=123";

        // 对要发送的数据生成签名
        Map<String, String> reqMap = Splitter.on("&").withKeyValueSeparator("=").split(sendStr);
        String signCheckContent = buildSignCheckContent(reqMap);
        String signValue = DigestUtils.sha1Hex(signCheckContent + public_key);
        // 待发送的数据与签名组合
        String sendData = sendStr + "&" + signKey + "=" + signValue;

        System.out.println("--------- 服务端接收数据 -----------");
        // 服务器收到数据了
        String receiveData = sendData;
        Map<String, String> receiveMap = Splitter.on("&").withKeyValueSeparator("=").split(receiveData);

        String waitCheckContent = buildSignCheckContent(receiveMap);
        String realSign = DigestUtils.sha1Hex(waitCheckContent + public_key);

        if (StringUtils.equals(realSign, receiveMap.get(signKey))) {
            System.out.println("签名正确，数据没有被篡改");
        } else {
            System.out.println("签名不相同，数据损坏");
        }
    }

    static String buildSignCheckContent(Map<String, String> map) {
        Map<String, String> params = Maps.newHashMap(map);
        if (params == null) {
            return null;
        }

        if (params.containsKey("sign"))
            params.remove("sign");
        if (params.containsKey("sign_type"))
            params.remove("sign_type");

        // 如果不排序，则参数顺序调整下就会时另一字符串， 则会产生不同的签名的结果
        StringBuilder content = new StringBuilder();
        List<String> keys = Lists.newArrayList(params.keySet());
        Collections.sort(keys);
        // 客户端应使用
        for (int i = 0; i < keys.size(); ++i) {
            String key = keys.get(i);
            String value = params.get(key);
            content.append(((i == 0) ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }

}
