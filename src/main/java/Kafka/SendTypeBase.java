package Kafka;

import java.util.Properties;

public interface SendTypeBase {
    void send(Properties properties, String topicName);
}
