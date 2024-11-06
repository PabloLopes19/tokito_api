package com.tokito.tokito_api.professor.controller

import com.tokito.tokito_api.hello.model.ErrorMessage
import com.tokito.tokito_api.professor.model.Professor
import com.tokito.tokito_api.professor.service.ProfessorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProfessorController(@Autowired private val professorService: ProfessorService) {
    @PostMapping("/professor")
    fun createProfessor(@RequestBody body: Professor): ResponseEntity<Any> {
        try {
            val createdUser = professorService.saveProfessor(body)

            return ResponseEntity(createdUser, HttpStatus.CREATED)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(ErrorMessage(
                errorCode = 500,
                errorMessage = "Server error"
            ), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/professor/{slug}")
    fun getProfessor(@PathVariable slug: String): ResponseEntity<Any> {
        try {
            val professor: Professor? = professorService.getProfessorData(slug)

            return ResponseEntity(professor ?: "Nenhum professor encontrado", HttpStatus.OK)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(ErrorMessage(
                errorCode = 500,
                errorMessage = "Não foi possível resgatar o professor! :("
            ), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("/professor/{slug}")
    fun updateProfessor(@RequestBody body: Professor, @PathVariable slug: String): Professor {
        return professorService.updateProfessor(body, slug)
    }

    @DeleteMapping("/professor/{slug}")
    fun deleteProfessor(@PathVariable slug: String): String {
        return professorService.deleteProfessor(slug).content
    }
}