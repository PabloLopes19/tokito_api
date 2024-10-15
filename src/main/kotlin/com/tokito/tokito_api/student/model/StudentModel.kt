package com.tokito.tokito_api.student.model

data class StudentModel(
    val slug: String?,
    val name: String,
    val email: String,
    val numberId: Long,
    val course: String,
)