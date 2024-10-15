package com.tokito.tokito_api.professor.controller

import com.tokito.tokito_api.professor.model.Professor
import com.tokito.tokito_api.professor.service.ProfessorService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfessorController(private val professorService: ProfessorService) {
    @PostMapping("/professor")
    fun createProfessor(@RequestBody body: Professor): Professor {
        return professorService.createProfessor(body)
    }

    @PutMapping("/professor/{slug}")
    fun updateProfessor(@RequestBody body: Professor, @PathVariable slug: String): Professor {
        return professorService.updateProfessor(body, slug)
    }


    @GetMapping("/professor/{slug}")
    fun getProfessor(@PathVariable slug: String): Professor {
        return professorService.getProfessorData(slug)
    }

    @DeleteMapping("/professor/{slug}")
    fun deleteProfessor(@PathVariable slug: String): String {
        return professorService.deleteProfessor(slug).content
    }
}