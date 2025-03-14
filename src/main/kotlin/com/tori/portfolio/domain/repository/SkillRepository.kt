package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.constant.SkillType
import com.tori.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository:JpaRepository<Skill, Long> {
    // select * from skill where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Skill>

    // select * from skill where lower(name) = lower(:name) and skill_type = :type
    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>
}