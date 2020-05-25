package com.ash84.rbmq

import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service


@Service
class CustomMessageListener {
    @RabbitListener(queues = ["remit-transfer-queue"])
    fun receiveRemitTransferMessage(message: TransferPayload) {
//        println(message!!.messageProperties.headers.entries)
//        println(message!!.messageProperties.messageId)
//        println(message!!.messageProperties.appId)
//        println(message!!.messageProperties.contentType)
//        println(message!!.messageProperties.contentLength)
//        println(message!!.messageProperties.priority)
//        println(message!!.messageProperties.xDeathHeader)
       println(message)
//        throw Exception()
    }

    @RabbitListener(queues = ["remit-drop-queue"])
    fun receiveRemitUserDropMessage(message: Message?) {
        println(message)
    }
}