package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import java.util.function.Consumer
import java.util.function.Supplier


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}


