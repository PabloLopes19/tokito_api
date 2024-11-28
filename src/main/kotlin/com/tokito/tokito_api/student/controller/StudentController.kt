package com.tokito.tokito_api.student.controller

import com.tokito.tokito_api.hello.model.ErrorMessage
import com.tokito.tokito_api.student.model.StudentModel
import com.tokito.tokito_api.student.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun createStudent(@RequestBody body: StudentModel): ResponseEntity<Any> {
        try {
            val createdStudent = studentService.createStudent(body)

            return ResponseEntity(createdStudent, HttpStatus.CREATED)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(
                ErrorMessage(
                errorCode = 500,
                errorMessage = "Server error"
            ), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/student/{slug}")
    fun getStudentBySlug(@PathVariable slug: String): ResponseEntity<Any> {
        try {
            val student: StudentModel? = studentService.getStudentData(slug)

            return ResponseEntity(student ?: "Nenhum aluno encontrado", HttpStatus.OK)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(ErrorMessage(
                errorCode = 500,
                errorMessage = "Não foi possível resgatar o aluno! :("
            ), HttpStatus.INTERNAL_SERVER_ERROR)
        }
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