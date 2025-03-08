package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.Achievement
import com.tori.portfolio.domain.entity.Experience
import com.tori.portfolio.domain.entity.Introduction
import com.tori.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {

}