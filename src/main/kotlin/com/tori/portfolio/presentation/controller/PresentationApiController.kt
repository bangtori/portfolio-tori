package com.tori.portfolio.presentation.controller

import com.tori.portfolio.presentation.dto.IntroductionDTO
import com.tori.portfolio.presentation.dto.LinkDTO
import com.tori.portfolio.presentation.dto.ProjectDTO
import com.tori.portfolio.presentation.dto.ResumeDTO
import com.tori.portfolio.presentation.service.PortfolioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val service: PortfolioService
) {

    @GetMapping("/test")
    fun test(): String {
        return "PresentationApiController"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return service.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return service.getLinks()
    }
    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return service.getResume()
    }
    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return service.getProjects()
    }
}