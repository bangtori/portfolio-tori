package com.tori.portfolio.domain.repository

import com.tori.portfolio.domain.entity.*
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository:JpaRepository<HttpInterface, Long> {

}