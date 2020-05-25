package com.ash84.rbmq

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitConfiguration {

    @Value("\${spring.rabbitmq.template.exchange}")
    private val rabbitmqExchange: String? = null

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory?): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory!!)
        rabbitTemplate.messageConverter = messageConverter()
        rabbitTemplate.setExchange(rabbitmqExchange)
        return rabbitTemplate
    }

    @Bean
    fun messageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter(ObjectMapper())
    }
}