package Kafka.SendCustom;

import Kafka.SendTypeBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SendStudent implements SendTypeBase {
    @Override
    public void send(Properties properties, String topicName) {


        //注意这里的序列化，key仍然是String，所以使用string的序列化器，
        //value是person，所有使用person的序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"Kafka.SendCustom.Serilization.StudentSerializer");



        KafkaProducer<String, TestStudent> producer = new KafkaProducer<String, TestStudent>(properties);
        TestStudent student = new TestStudent();
        for (int i = 0; i < 100 ; i++) {
            student.setAge(i);
            student.setId(i);
            student.setName("Student" + i);
            producer.send(new ProducerRecord<>(topicName,"student"+i,student));
        }
        producer.close();
    }
}
