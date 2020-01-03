package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import java.util.function.Consumer
import java.util.function.Supplier

@Configuration
class Config {

    private val processor: EmitterProcessor<Message<*>> = EmitterProcessor.create<Message<*>>()

    @Bean
    fun supplier(): Supplier<Flux<Message<*>>> = Supplier { processor }

    @Bean
    fun consumer(): Consumer<String> = Consumer {
        processor.onNext(
            MessageBuilder
                .withPayload(it)
                .build()
        ).also { println("publishing") }
    }
}