package com.kafka;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaGroupProducerApp
{
  public static void main(String[] args) {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092, localhost:9093");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerialization");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    // --> props.put("config.setting", "value");
    // :: http://kafka.apache.org/documentation.html#producerconfigs

    KafkaProducer myProducer = new KafkaProducer(props);

    try {
      int counter = 0;
      while (counter < 100) {
        myProducer.send(new ProducerRecord<String, String>("my-big-topic", "abcdefghijklmnopqrstuvwxyz"));
        counter++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      myProducer.close();
    }
  }
}
