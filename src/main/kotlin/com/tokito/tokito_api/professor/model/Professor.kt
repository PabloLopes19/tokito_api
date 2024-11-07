package com.tokito.tokito_api.professor.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "professor")
data class Professor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long? = null,

    var slug: String = "",

    var name: String = "",

    var email: String = "",

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String = "",

    var lectures: List<String> = emptyList(),

    var degreeTitle: String? = null,

    var curriculum: String = ""
)