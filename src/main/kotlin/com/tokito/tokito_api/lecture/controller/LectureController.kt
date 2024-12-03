package com.tokito.tokito_api.lecture.controller

import com.tokito.tokito_api.hello.model.ErrorMessage
import com.tokito.tokito_api.lecture.model.LectureModel
import com.tokito.tokito_api.lecture.service.LectureService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class LectureController(private val lectureService: LectureService) {
    @PostMapping("/lecture")
    @ResponseBody
    fun createLecture(@RequestBody body: LectureModel): ResponseEntity<Any> {
        try {
            val createdLecture = lectureService.createLecture(body)

            return ResponseEntity(createdLecture, HttpStatus.CREATED)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(
                ErrorMessage(
                    errorCode = 500,
                    errorMessage = "Server error | Não foi possível criar aula"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR,
            )
        }
    }

    @GetMapping("/lecture/{id}")
    fun getLectureById(@PathVariable id: String): ResponseEntity<Any>{
        try {
            val lecture: LectureModel? = lectureService.getLectureData(id)

            return ResponseEntity(lecture ?: "Não há aulas com o id: $id", HttpStatus.OK)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(
                ErrorMessage(
                    errorCode = 500,
                    errorMessage = "Server error | Não foi possível resgatar a aula"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR,
            )
        }
    }

    @GetMapping("/lecture/all")
    fun getAllLectures(): ResponseEntity<Any> {
        try {
            val lectures: MutableIterable<LectureModel>? = lectureService.getAll()

            return ResponseEntity(lectures ?: "Não há aulas cadastradas no sistema", HttpStatus.OK)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(
                ErrorMessage(
                    errorCode = 500,
                    errorMessage = "Server error | Não foi possível resgatar a aula"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR,
            )
        }
    }

    @DeleteMapping("/lecture/{id}")
    fun deleteLectureById(@PathVariable id: String): ResponseEntity<Any>{
        try {
            lectureService.deleteLectureById(id)

            return ResponseEntity("Aula $id deletada com sucesso!", HttpStatus.OK)
        } catch (e: Exception) {
            print("DEU RUM!")
            return ResponseEntity(
                ErrorMessage(
                    errorCode = 500,
                    errorMessage = "Server error | Não foi possível resgatar a aula"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR,
            )
        }
    }
}