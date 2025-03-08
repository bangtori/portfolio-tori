package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.Achievement
import com.tori.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository:JpaRepository<Experience, Long> {

}