package com.tokito.tokito_api.hello.controller

import com.tokito.tokito_api.hello.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(private val helloService: HelloService) {

    @GetMapping("/hello")
    fun hello(): String {
        return helloService.getHelloMessage().content
    }
}