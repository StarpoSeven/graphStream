package Flink;

import Kafka.AdminUtil;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.time.Time;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ReadKafka {
    public static void main(String[] args) throws Exception {
//
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        Properties properties = new Properties();
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,AdminUtil.BOOTSTRAP_SERVER);
//        String inputTopic = "test";
//        FlinkKafkaConsumer<String> stringFlinkConsumer = new FlinkKafkaConsumer<>(inputTopic, new SimpleStringSchema(), properties);
//        DataStream<String> stream = env.addSource(stringFlinkConsumer);
//
//
//
//        // Sink
//        stream.print();
//        // execute
//        env.execute("kafka streaming word count");

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "10.176.24.58:9092");

        DataStream<String> dataStream = env.addSource(new FlinkKafkaConsumer<String>("test", new SimpleStringSchema(), properties));

        dataStream.print();

        env.execute();



    }
}
