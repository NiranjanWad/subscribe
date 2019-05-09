package com.subscriptions.subscribe;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class EventSubscibeConfig implements ApplicationListener<ApplicationReadyEvent> {

    static final String queueName = "myFirstQueue";
    static final String topicExchangeName = "eventExchange";

    @Bean
    Queue queue(){
        return new Queue(queueName,false);
    }

    @Bean
    public TopicExchange eventExchange(){
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange eventExchange){
        return BindingBuilder.bind(queue).to(eventExchange).with("sub.test.first");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListener listenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return  container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver subscriber){
        return new MessageListenerAdapter(subscriber, "receiveMessage");
    }

    @Bean
    public Receiver receiver(){
        return new Receiver();
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("SUBSCRIBING TO EVENTS MATCHING KEY FROM QUEUE '{}'!");
    }
}
