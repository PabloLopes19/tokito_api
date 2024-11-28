package com.tokito.tokito_api.student.repository

import com.tokito.tokito_api.student.model.StudentModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<StudentModel, String> {
    fun getBySlug(slug: String): StudentModel?
}