package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProjectSkillRepository:JpaRepository<ProjectSkill, Long> {
    // select * from project_skill where project_id = :projectId and skill_id = :skillId
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>
}