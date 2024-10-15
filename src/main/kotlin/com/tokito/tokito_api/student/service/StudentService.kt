package com.tokito.tokito_api.student.service

import com.tokito.tokito_api.hello.model.Message
import com.tokito.tokito_api.student.model.StudentModel
import org.springframework.stereotype.Service

@Service
class StudentService {
    fun createStudent(user: StudentModel): StudentModel {
        return user
    }

    fun getStudentData(slug: String): StudentModel {
        return StudentModel(
            slug = slug,
            name = "Matheus Lofy",
            email = "matheus.lofy.catolicasc.org.br",
            numberId = 242424,
            course = "Engenharia de Software"
        )
    }

    fun updateStudent(slug: String, user: StudentModel): StudentModel {
        return user.copy(slug = slug)
    }

    fun deleteStudent(slug: String): Message {
        return Message("O estudante @$slug foi deletado com sucesso!")
    }
}