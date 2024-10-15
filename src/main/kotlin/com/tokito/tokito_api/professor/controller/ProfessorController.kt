package com.tokito.tokito_api.professor.controller

import com.tokito.tokito_api.professor.model.Professor
import com.tokito.tokito_api.professor.service.ProfessorService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfessorController(private val professorService: ProfessorService) {
    @GetMapping("/professor/{slug}")
    fun getProfessor(@PathVariable slug: String): Professor {
        return professorService.getProfessorData(slug)
    }
}