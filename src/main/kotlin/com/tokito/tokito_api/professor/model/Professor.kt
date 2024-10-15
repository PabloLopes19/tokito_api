package com.tokito.tokito_api.professor.model

data class Professor(
    val slug: String,
    val name: String,
    val email: String,
    val lectures: List<String>,
    val degreeTitle: String?,
    val curriculum: String,
) {

}