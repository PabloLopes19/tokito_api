package com.tokito.tokito_api.lecture.service

import com.tokito.tokito_api.lecture.model.LectureModel
import com.tokito.tokito_api.lecture.repository.LectureRepository
import org.springframework.stereotype.Service

@Service
class LectureService(private val repository: LectureRepository) {
    fun createLecture(lecture: LectureModel): LectureModel {
        return repository.save(lecture)
    }

    fun getLectureData(id: String): LectureModel? {
        return repository.getById(id)
    }

    fun getAll(): MutableIterable<LectureModel> {
        return repository.findAll()
    }

    fun deleteLectureById(id: String) {
        return repository.deleteById(id)
    }
}