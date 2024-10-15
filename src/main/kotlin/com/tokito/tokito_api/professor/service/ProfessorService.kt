package com.tokito.tokito_api.professor.service

import com.tokito.tokito_api.hello.model.Message
import com.tokito.tokito_api.professor.model.Professor
import org.springframework.stereotype.Service

@Service
class ProfessorService {
    fun createProfessor(data: Professor): Professor {
        return data
    }

    fun updateProfessor(data: Professor, slug: String): Professor {
        return data.copy(slug = slug)
    }

    fun getProfessorData(slug: String): Professor {
        return Professor(
            slug = slug,
            name = "Paulo Manseira",
            email = "manseira.paulo@gmail.com",
            lectures = listOf("POO", "Back-end"),
            degreeTitle = null,
            curriculum = "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
        )
    }

    fun deleteProfessor(slug: String): Message {
        return Message("Usuário @$slug deletado com sucesso!")
    }
}