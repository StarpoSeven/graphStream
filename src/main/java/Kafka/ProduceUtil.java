package Kafka;

import org.apache.kafka.clients.producer.ProducerConfig;

import java.io.IOException;
import java.util.Properties;

public class ProduceUtil {

    public static void produce(String topic, SendTypeBase sendTypeBase) throws IOException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"10.176.24.58:9092");
        properties.put(ProducerConfig.ACKS_CONFIG,"all");
        properties.put(ProducerConfig.RETRIES_CONFIG,"0");
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,"16384");
        properties.put(ProducerConfig.LINGER_MS_CONFIG,"1");
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG,"33554432");

        sendTypeBase.send(properties, topic);

    }

//    public static void produceFunction(Properties properties,String topic) throws IOException {
//        Producer<String,String> producer = new KafkaProducer<>(properties);
//
//        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/zhuxingpo/Downloads/dataToread/hamlet.txt")));
//        String data;
//        while((data = br.readLine()) != null) {
//            ProducerRecord<String,String> record = new ProducerRecord<>(topic,data);
//            producer.send(record);
//        }
//
//        producer.close();
//    }


}
