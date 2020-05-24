package com.ash84.rbmq

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RbmqApplication

fun main(args: Array<String>) {
	runApplication<RbmqApplication>(*args)
}
