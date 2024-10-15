package com.tokito.tokito_api.professor.model

import jakarta.persistence.*

@Entity
@Table(name = "professor")
data class Professor(
    @Id
    val slug: String?,  // Primary key

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val email: String,

    @ElementCollection
    val lectures: List<String> = mutableListOf(),

    @Column(nullable = false)
    val degreeTitle: String?,

    @Column(nullable = false, columnDefinition = "TEXT")
    val curriculum: String
) {
//    constructor() : this(null, "", "", emptyList(), null, "")
}