package com.school.marks.config;

import com.school.marks.dto.MarkEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaJsonConsumerConfig {

    @Bean
    public ConsumerFactory<String, MarkEvent> markEventConsumerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "school-marks-json-group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JacksonJsonDeserializer<>(MarkEvent.class));
    }

    @Bean(name = "markEventKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, MarkEvent> markEventConcurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MarkEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(markEventConsumerFactory());
        return factory;
    }
}
