package tech.zenblob.wecomconnectservice.utils.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用的反序列化工具类
 * 现用于企业微信回调消息体把对象或数组转换成 List
 */
public abstract class ListOrObjectDeserializer<T> implements ObjectDeserializer {

    protected abstract Class<T> getTypeClass();

    @Override
    public <T1> T1 deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        Object value = parser.parse();
        if (value instanceof JSONArray) {
            return (T1) ((JSONArray) value).toJavaList(getTypeClass());
        } else if (value instanceof JSONObject) {
            List<T> list = new ArrayList<>();
            list.add(((JSONObject) value).toJavaObject(getTypeClass()));
            return (T1) list;
        }
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}


