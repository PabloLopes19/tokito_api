package com.tokito.tokito_api.hello.controller

import com.tokito.tokito_api.hello.service.HelloService
import com.tokito.tokito_api.hello.model.Message  // Importando a classe Message correta
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(HelloController::class)
class HelloControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var helloService: HelloService

    @Test
    fun `should return hello message`() {
        // Simulando a mensagem correta retornada pelo HelloService
        val helloMessage = Message("Hello there")
        `when`(helloService.getHelloMessage()).thenReturn(helloMessage)

        // Simulando uma requisição HTTP GET para o endpoint /hello
        mockMvc.get("/hello")
            .andExpect {
                status { isOk() }
                content { string("Hello there") }  // Verificando o conteúdo da resposta
            }
    }
}
