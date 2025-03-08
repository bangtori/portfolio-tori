package com.tori.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
): BaseEntity() { // 생성자로 필요한 값 주입
    @Id // PK 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id") // 데이터베이스 칼럼명: achievement_id
    var id: Long? = null // 소스 접근 시 변수명, 옵셔널로 널 허용 가능함

    // Column 어노테이션을 안쓸 경우 jpa 에서 알아서 데이터베이스에서 동일한 이름을 찾아 매핑
    // 단 isActive 처럼 카멜케이스의 경우 is_active 처럼 알아서 변환해서 매핑
    var title: String = title
    var description: String = description
    var achievedDate: LocalDate? = achievedDate
    var host: String = host
    var isActive: Boolean = isActive
}