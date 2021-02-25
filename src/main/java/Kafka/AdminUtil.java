package Kafka;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.*;
import java.util.concurrent.ExecutionException;


public class AdminUtil {
    public static final String TOPIC_NAME = "graphstream";
    public static final String BOOTSTRAP_SERVER = "10.176.24.58:9092";

    public static AdminClient getAdminClient() {
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVER);
        AdminClient client = AdminClient.create(properties);
        return client;
    }

    public static void createTopic() {
        AdminClient client = getAdminClient();
        NewTopic newTopic = new NewTopic(TOPIC_NAME,1,(short)1);
        CreateTopicsResult result = client.createTopics(Arrays.asList(newTopic));
        System.out.println("Create Topics result" + result);

    }

    public static void delTopics() throws ExecutionException, InterruptedException {
        AdminClient adminClient = getAdminClient();
        DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Arrays.asList(TOPIC_NAME));
        deleteTopicsResult.all().get();
    }

    //获取Topic列表
    public static void topicLists() throws ExecutionException, InterruptedException {
        AdminClient adminClient = getAdminClient();
        //是否查看internal选项
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true); //将内部也打印出

        ListTopicsResult listTopicsResult = adminClient.listTopics(options);
        Set<String> names = listTopicsResult.names().get();

        Collection<TopicListing> topicListings = listTopicsResult.listings().get();
        KafkaFuture<Map<String, TopicListing>> mapKafkaFuture = listTopicsResult.namesToListings();
        //打印names
        names.stream().forEach(System.out::println);

        //打印topicListings
        topicListings.stream().forEach((topicList)->{
            System.out.println(topicList);
        });

    }



}

