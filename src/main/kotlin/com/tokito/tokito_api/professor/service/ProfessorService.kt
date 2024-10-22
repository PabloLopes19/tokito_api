package com.tokito.tokito_api.professor.service

import com.tokito.tokito_api.hello.model.Message
import com.tokito.tokito_api.professor.model.Professor
import com.tokito.tokito_api.professor.repository.ProfessorRepository
import org.springframework.stereotype.Service

@Service
class ProfessorService(private val professorRepository: ProfessorRepository) {
    fun saveProfessor(data: Professor): Professor {
        return professorRepository.save(data)
    }

    fun updateProfessor(data: Professor, slug: String): Professor {
        return data.copy(slug = slug)
    }

    fun getProfessorData(slug: String): Professor? {
        return professorRepository.getBySlug(slug)
    }

    fun deleteProfessor(slug: String): Message {
        return Message("Usuário @$slug deletado com sucesso!")
    }
}