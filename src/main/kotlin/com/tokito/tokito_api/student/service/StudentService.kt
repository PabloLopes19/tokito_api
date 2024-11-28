package com.tokito.tokito_api.student.service

import com.tokito.tokito_api.hello.model.Message
import com.tokito.tokito_api.student.model.StudentModel
import com.tokito.tokito_api.student.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun createStudent(user: StudentModel): StudentModel {
        return studentRepository.save(user)
    }

    fun getStudentData(slug: String): StudentModel? {
        return studentRepository.getBySlug(slug)
    }

    fun updateStudent(slug: String, user: StudentModel): StudentModel {
        return user.copy(slug = slug)
    }

    fun deleteStudent(slug: String): Message {
        return Message("O estudante @$slug foi deletado com sucesso!")
    }
}