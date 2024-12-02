package com.tokito.tokito_api.lecture.repository

import com.tokito.tokito_api.lecture.model.LectureModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LectureRepository : CrudRepository<LectureModel, String> {
    fun getById(id: String): LectureModel?
}