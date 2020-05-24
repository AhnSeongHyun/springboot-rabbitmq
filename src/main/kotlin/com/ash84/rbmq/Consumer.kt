package com.ash84.rbmq

import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service


@Service
class CustomMessageListener {
    @RabbitListener(queues = ["transfer-queue"])
    fun receiveRemitTransferMessage(message: Message?) {
        println(message)
    }

    @RabbitListener(queues = ["user-drop-queue"])
    fun receiveRemitUserDropMessage(message: Message?) {
        println(message)
    }
}