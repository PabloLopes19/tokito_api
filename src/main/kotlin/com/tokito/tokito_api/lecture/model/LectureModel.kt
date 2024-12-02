package com.tokito.tokito_api.lecture.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.tokito.tokito_api.professor.model.Professor
import com.tokito.tokito_api.student.model.StudentModel
import jakarta.persistence.*

@Entity
@Table(name = "lectures")
data class LectureModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id: Long? = null,

    var lectureName: String = "",
    var owner: String? = null,
    var studentList: List<String> = emptyList()
)