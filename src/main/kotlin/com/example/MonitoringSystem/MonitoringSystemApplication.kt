package com.example.MonitoringSystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonitoringSystemApplication

fun main(args: Array<String>) {
	runApplication<MonitoringSystemApplication>(*args)
	println("Spring Boot 실행")
}
