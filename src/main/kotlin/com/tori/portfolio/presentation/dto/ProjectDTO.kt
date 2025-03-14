package com.tori.portfolio.presentation.dto

import com.tori.portfolio.domain.entity.Project


data class ProjectDTO(
    val name: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String,
    val details: List<ProjectDetailDTO>,
    val skills: List<SkillDTO>
) {
    constructor(project: Project): this(
        name = project.name,
        description = project.description,
        startYearMonth = "${project.startYear}.${project.startMonth}", // 2023.9
        endYearMonth = project.getEndYearMonth(),
        details = project.details.map { details -> ProjectDetailDTO(details) },
        skills = project.skills.map { projectSkill -> SkillDTO(projectSkill.skill) }
    )
}