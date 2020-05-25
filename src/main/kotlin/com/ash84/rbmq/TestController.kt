package com.ash84.rbmq;

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController




@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class TransferPayload(
        var id: Long?=null
)


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserDropPayload(
        val userId: Long
)
class CustomMessage {
    var text: Int? = null

    protected constructor() {}
    constructor(text: Int ) {
        this.text = text
    }
}

@RestController
@RequestMapping("/test")
class TestController(private val rabbitTemplate: RabbitTemplate) {

    @GetMapping("/produce/remit-transfer")
    fun transfer():String{
        val payload = TransferPayload(1)
        val routingKey = "remit-transfer"
        println(rabbitTemplate.messageConverter)
        rabbitTemplate.convertAndSend("remit-exchange", routingKey, payload)
        return "ok"
    }

    @GetMapping("/produce/remit-drop")
    fun drop():String{
        val payload = UserDropPayload(1)
        val routingKey = "remit-drop"
        rabbitTemplate.convertAndSend(routingKey, payload)
        return "ok"
    }

}
