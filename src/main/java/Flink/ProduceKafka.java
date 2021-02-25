package Flink;

import Kafka.AdminUtil;
import Kafka.ProduceUtil;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ProduceKafka {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ProduceUtil.streamSend();
    }
}
