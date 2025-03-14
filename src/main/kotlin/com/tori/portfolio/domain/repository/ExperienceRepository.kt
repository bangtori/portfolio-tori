package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.Experience
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface ExperienceRepository:JpaRepository<Experience, Long> {
    @Query("select e from Experience e join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>
    @Query("select e from Experience e join fetch e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
}