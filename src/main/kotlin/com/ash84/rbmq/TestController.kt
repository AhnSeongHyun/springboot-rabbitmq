package com.ash84.rbmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


data class TransferPayload(
        val transactionId: Long
)


data class UserDropPayload(
        val userId: Long
)



@RestController
@RequestMapping("/test")
class TestController(private val rabbitTemplate: RabbitTemplate) {

    @GetMapping("/produce/remit-transfer")
    fun transfer():String{
        val payload = TransferPayload(transactionId = 1)
        val routingKey = "remit-transfer"
        rabbitTemplate.convertAndSend("rb-exchange", routingKey, payload)
        return "ok"
    }

    @GetMapping("/produce/remit-drop")
    fun drop():String{
        val payload = UserDropPayload(1)
        val routingKey = "remit-drop"
        rabbitTemplate.convertAndSend("rb-exchange", routingKey, payload)
        return "ok"
    }

}
