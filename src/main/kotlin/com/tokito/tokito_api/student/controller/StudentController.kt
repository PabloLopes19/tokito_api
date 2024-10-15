package com.tokito.tokito_api.student.controller

import com.tokito.tokito_api.student.model.StudentModel
import com.tokito.tokito_api.student.service.StudentService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(private val studentService: StudentService) {
    @PostMapping("/student")
    @ResponseBody
    fun createStudent(@RequestBody body: StudentModel): StudentModel {
        return studentService.createStudent(body)
    }

    @GetMapping("/student/{slug}")
    fun getStudentBySlug(@PathVariable slug: String): StudentModel {
        return studentService.getStudentData(slug)
    }

    @PutMapping("/student/{slug}")
    fun updateStudent(@PathVariable slug: String, @RequestBody body: StudentModel): StudentModel {
        return studentService.updateStudent(slug, body)
    }

    @DeleteMapping("student/{slug}")
    fun deleteStudent(@PathVariable slug: String): String {
        return studentService.deleteStudent(slug).content
    }
}