package com.kafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Slf4j
public class RandomNumberConsumer {

    @KafkaListener(topics = "random-number") /*это название темы, из которой читаются сообщения.*/
    public void consume(String message) throws UnknownHostException {

        /*Здесь мы получаем сообщение,а  также получаем данные хоста, с которого
        * работает данный Consumer. Эти данные помещаем в лог.*/
        String hostName = InetAddress.getLocalHost().getHostName();
        log.info(String.format("%s consumed %s", hostName, message));
    }
}