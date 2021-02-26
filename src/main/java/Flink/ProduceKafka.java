package Flink;

import Kafka.ProduceUtil;
import Kafka.SendCustom.SendStudent;
import Kafka.SendFile.SendFile;
import Kafka.SendTypeBase;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ProduceKafka {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        SendTypeBase file = new SendFile();
        SendTypeBase student = new SendStudent();
        ProduceUtil.produce("zxp",file);


    }
}
