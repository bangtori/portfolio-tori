package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.Experience
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository


interface ExperienceRepository:JpaRepository<Experience, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Experience>
    override fun findById(id: Long): Optional<Experience>
}