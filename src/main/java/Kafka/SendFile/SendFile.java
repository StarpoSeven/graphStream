package Kafka.SendFile;

import Kafka.SendTypeBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.*;
import java.util.Properties;

public class SendFile implements SendTypeBase {
    @Override
    public void send(Properties properties, String topicName) {
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<>(properties);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("/Users/zhuxingpo/Downloads/dataToread/hamlet.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data;
        while(true) {
            try {

                if (!((data = br.readLine()) != null)) break;
                ProducerRecord<String,String> record = new ProducerRecord<>(topicName,data);
                producer.send(record);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }
}
