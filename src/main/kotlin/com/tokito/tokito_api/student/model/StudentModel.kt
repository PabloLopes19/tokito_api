package com.tokito.tokito_api.student.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "students")
data class StudentModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long? = null,

    var slug: String = "",

    var name: String = "",

    var email: String = "",

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String = "",

    var numberId: Long = 0,

    var course: String? = null,

)