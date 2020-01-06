package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SpringBootApplication
public class Application {
    private EmitterProcessor<Message<String>> processor =  EmitterProcessor.create();

    @Bean
    public Supplier<Flux<Message<String>>> supplier() {
        return () -> processor;
    }

    @Bean
    public Consumer<String> consumer() {
        return msg -> processor.onNext(MessageBuilder.withPayload(msg).build());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
