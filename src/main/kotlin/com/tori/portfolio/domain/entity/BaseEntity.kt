package com.tori.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDateTime: LocalDateTime = LocalDateTime.now()

    @CreatedDate
    @Column(nullable = false)
    var updatedDateTime: LocalDateTime = LocalDateTime.now()
}