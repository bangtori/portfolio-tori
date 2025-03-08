package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.Achievement
import com.tori.portfolio.domain.entity.Experience
import com.tori.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {

}