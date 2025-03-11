package com.tori.portfolio.domain

import com.tori.portfolio.domain.constant.SkillType
import com.tori.portfolio.domain.entity.*
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import com.tori.portfolio.domain.repository.AchievementRepository
import com.tori.portfolio.domain.repository.ExperienceRepository
import com.tori.portfolio.domain.repository.IntroductionRepository
import com.tori.portfolio.domain.repository.LinkRepository
import com.tori.portfolio.domain.repository.ProjectRepository
import com.tori.portfolio.domain.repository.SkillRepository
import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import java.time.LocalDate
import org.slf4j.Logger


// @Controller
// @Service
// @Repository
// 위의 세개 모두 컴포넌트와 같은 기능을 하지만 더 세부적으로 역할을 명시함
@Component // Spring Bean을 등록할 수 있도록 알려주는 역할
@Profile(value = ["default"]) // 프로필이 default 일때만 이 클래스를 생성해 빈으로 등록해라
class DataInitalizer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    // 생성자로 주입해준 레포지토리들도 스프링 빈에 등록됨
    private val log: Logger = LoggerFactory.getLogger(DataInitalizer::class.java)
    @PostConstruct // 스프링을 실행하면 모든 빈 등록완료 후 해당 메소드 실행하도록 함 -> 즉 데이터를 init할 수 있음
    fun initalizeData() {
        log.info("✅ 데이터 초기화 시작")

        // Achievement 초기화
        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2022 Catkao 해커톤 최우수상",
                description = "고양이 쇼핑몰 검색 서비스의 아키텍처, 데이터 모델링, API 개발 역할 수행",
                        host = "캣카오",
                achievedDate = LocalDate.of(2022, 8, 1),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2020, 2, 2),
                isActive = true
            ),
        )
        log.info("📌 Achievement 저장 시작")
        achievementRepository.saveAll(achievements)
        log.info("✅ Achievement 저장 완료")
        // Introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "주도적으로 문제를 찾고, 해결하는 고양이입니다.", isActive = true),
            Introduction(content = "기술을 위한 기술이 아닌, 비즈니스 문제를 풀기 위한 기술을 추구합니다.",
                isActive = true),
            Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.",
                isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // Link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/infomuscle", isActive = true),
            Link(name = "Linkedin", content = "https://www.linkedin.com/in/bokeunjeong",
                isActive = true),
        )
        linkRepository.saveAll(links)

        // Experience / ExperienceDetail 초기화
        val experience1 = Experience(
            title = "캣홀릭대학교(CatHolic Univ.)",
            description = "컴퓨터공학 전공"
            ,
            startYear = 2018,
            startMonth = 9,
            endYear = 2022,
            endMonth = 8,
            isActive = true,
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "GPA 4.3/4.5", isActive = true),
                ExperienceDetail(content = "소프트웨어 연구 학회 활동"
                    , isActive = true)
            )
        )
        val experience2 = Experience(
            title = "주식회사 캣카오(Catkao Corp.)",
            description = "소셜서비스팀 백엔드 개발자",
                    startYear = 2022,
            startMonth = 9,
            endYear = null,
            endMonth = null,
            isActive = true,
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "유기묘 위치 공유 서비스 개발"
                    , isActive = true),
                ExperienceDetail(content = "신입 교육 프로그램 우수상 수상"
                    , isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        // Skill 초기화
        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, python, spring, django, mysql,
            redis, kafka))
        // Project / ProjectDetail / project_skill 초기화
        val project1 = Project(
            name = "유기묘 발견 정보 공유 서비스",
            description = "유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스. 구글 맵스를 연동하여 유기묘 위치 정보를 직관적으로 파악할 수 있도록 하는 사용자 경험 개선 작업.",
                    startYear = 2022,
            startMonth = 9,
            endYear = 2022,
            endMonth = 12,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발",
                    url = null, isActive = true),
                ProjectDetail(content = "Redis 적용하여 인기 게시글의 조회 속도 1.5초 → 0.5초로 개선",
                url = null, isActive= true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
                ProjectSkill(project = project1, skill = redis)
            )
        )
        val project2 = Project(
            name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
            description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작업.",
            startYear = 2022,
            startMonth = 12,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "PIL(Pillow) 활용하여 이미지 분석 기능 개발",
                    url = null, isActive = true),
                ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소",
                    url = null, isActive = true),
                ProjectDetail(content = "Github Repository",
                    url = "https://github.com/infomuscle", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = python),
                ProjectSkill(project = project2, skill = django),
                ProjectSkill(project = project2, skill = kafka)
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))
        log.info("✅ 데이터 초기화 완료")
    }
}