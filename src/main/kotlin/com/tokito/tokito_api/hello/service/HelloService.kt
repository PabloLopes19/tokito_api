package com.tokito.tokito_api.hello.service

import com.tokito.tokito_api.hello.model.Message
import org.springframework.stereotype.Service

@Service
class HelloService {
    fun getHelloMessage(): Message {
        return Message("Hello there")
    }
}