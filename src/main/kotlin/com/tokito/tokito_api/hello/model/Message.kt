package com.tokito.tokito_api.hello.model

data class Message(val content: String)

data class ErrorMessage(val errorCode: Int, val errorMessage: String)