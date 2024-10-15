package com.tokito.tokito_api.student.service

import com.tokito.tokito_api.student.model.StudentModel
import org.springframework.stereotype.Service

@Service
class StudentService {
    fun getStudentData(slug: String): StudentModel {
        return StudentModel(
            slug = slug,
            name = "Matheus Lofy",
            email = "matheus.lofy.catolicasc.org.br",
            numberId = 242424,
            course = "Engenharia de Software"
        )
    }
}