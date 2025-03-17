package com.tori.portfolio.presentation.controller

import com.tori.portfolio.domain.constant.SkillType
import com.tori.portfolio.presentation.service.PortfolioService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val service: PortfolioService
) {
    @GetMapping("/test")
    fun test(): String {
        return "test"
    }
    @GetMapping("/")
    fun index(model: Model): String {
        val introductions = service.getIntroductions()
        model.addAttribute("introductions", introductions)
        val links = service.getLinks()
        model.addAttribute("links", links)
        return "presentation/index"
    }
    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = service.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())
        return "presentation/resume"
    }
    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projects = service.getProjects()
        model.addAttribute("projects", projects)
        return "presentation/projects"
    }
}