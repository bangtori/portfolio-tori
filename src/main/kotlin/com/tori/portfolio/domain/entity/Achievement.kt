package com.tori.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Achievement: BaseEntity() {
    @Id // PK 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id") // 데이터베이스 칼럼명: achievement_id
    var id: Long? = null // 소스 접근 시 변수명, 옵셔널로 널 허용 가능함
}