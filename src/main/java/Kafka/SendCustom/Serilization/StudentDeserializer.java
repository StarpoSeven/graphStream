package Kafka.SendCustom.Serilization;

import Kafka.SendCustom.TestStudent;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class StudentDeserializer implements Deserializer<TestStudent> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public TestStudent deserialize(String s, byte[] bytes) {
        return JSON.parseObject(bytes, TestStudent.class);
    }

    @Override
    public TestStudent deserialize(String topic, Headers headers, byte[] data) {
        return null;
    }

    @Override
    public void close() {

    }
}
