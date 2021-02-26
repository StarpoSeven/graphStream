package Kafka.SendCustom.Serilization;

import Kafka.SendCustom.TestStudent;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class StudentSerializer implements Serializer<TestStudent> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, TestStudent student) {
        return JSON.toJSONBytes(student);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, TestStudent data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
