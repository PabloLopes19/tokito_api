package com.tokito.tokito_api.student.controller

import com.tokito.tokito_api.student.model.StudentModel
import com.tokito.tokito_api.student.service.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(private val studentService: StudentService) {
    @GetMapping("/student/{slug}")
    fun getStudentBySlug(@PathVariable slug: String): StudentModel {
        return studentService.getStudentData(slug)
    }
}