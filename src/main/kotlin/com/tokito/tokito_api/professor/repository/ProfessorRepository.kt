package com.tokito.tokito_api.professor.repository

import com.tokito.tokito_api.professor.model.Professor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessorRepository : CrudRepository<Professor, String>