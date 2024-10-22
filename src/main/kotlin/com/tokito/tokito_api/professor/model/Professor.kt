package com.tokito.tokito_api.professor.model

import jakarta.persistence.*

@Entity
@Table(name = "professor")
data class Professor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val slug: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(name = "lecture", nullable = true)
    val lectures: List<String>?,

    @Column(nullable = true)
    val degreeTitle: String? = null,

    @Column(nullable = false)
    val curriculum: String
)