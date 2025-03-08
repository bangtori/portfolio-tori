package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository:JpaRepository<Achievement, Long> { // <엔티티, id 자료형>
    // jpa 라이브러리를 통해 기본적인 CRUD 기능 사용 가능
}