package com.tori.portfolio.presentation.service

import com.tori.portfolio.presentation.dto.*
import com.tori.portfolio.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PortfolioService(
    private val presentationRepository: PresentationRepository
) {

    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroductions()
        return introductions.map { introduction -> IntroductionDTO(introduction) }
    }

    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLinks()
        return links.map { link -> LinkDTO(link) }
    }

    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperiences()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkills()
        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }

    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProjects()
        return projects.map { project -> ProjectDTO(project) }
    }
}