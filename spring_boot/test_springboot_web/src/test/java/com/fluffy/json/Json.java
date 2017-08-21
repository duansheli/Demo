
package com.fluffy.json;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Json {
    static final SerializerFeature[] fs = { SerializerFeature.QuoteFieldNames, SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteNullBooleanAsFalse };

    public static void main(String[] args) {
        JSONObject.toJSONString(new HashMap<>(), fs);
    }
}
