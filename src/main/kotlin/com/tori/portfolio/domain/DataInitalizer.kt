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
                title = "멋쟁이 사자처럼 iOS 앱스쿨 2기 최종 프로젝트 우수상",
                description = "PICO - 데이팅 앱 제작 / 좋아요 뷰, 푸시알림 기능 제작",
                        host = "멋쟁이 사자처럼",
                achievedDate = LocalDate.of(2023, 10, 6),
                isActive = true
            ),
            Achievement(
                title = "정보처리기사",
                description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                host = "한국산업인력공단",
                achievedDate = LocalDate.of(2021, 11, 26),
                isActive = true
            ),
        )
        achievementRepository.saveAll(achievements)
        // Introduction 초기화
        val introductions = mutableListOf<Introduction>(
            Introduction(content = "반복되는 작업, 코드를 지양하고 어떻게 하면 재사용성이 높은 코드를 작성할 수 있을지 늘 고민합니다.", isActive = true),
            Introduction(content = "사용자에게 효율적인 User Flow를 제공하기 위해 디자이너와 함께 고민합니다.",
                isActive = true),
            Introduction(content = "모듈화, 아키텍쳐, 사용자UX 등에 관심을 가지고 있습니다.",
                isActive = true)
        )
        introductionRepository.saveAll(introductions)

        // Link 초기화
        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/bangtori", isActive = true),
            Link(name = "Journals", content = "https://bang-tori.tistory.com/",
                isActive = true),
        )
        linkRepository.saveAll(links)

        // Experience / ExperienceDetail 초기화
        val experience1 = Experience(
            title = "공주대학교(Kongju Univ.)",
            description = "컴퓨터공학 전공",
            startYear = 2018,
            startMonth = 3,
            endYear = 2023,
            endMonth = 2,
            isActive = true,
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "학생회 활동", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "멋쟁이사자처럼 iOS 앱스쿨 2기",
            description = "iOS 개발 관련 지식 학습",
            startYear = 2023,
            startMonth = 5,
            endYear = 2023,
            endMonth = 10,
            isActive = true,
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "최종 프로젝트 우수상", isActive = true),
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        // Skill 초기화
        val swift = Skill(name = "Swift", type = SkillType.LANGUAGE.name, isActive = true)
        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val UIKit = Skill(name = "UIKit", type = SkillType.FRAMEWORK.name, isActive = true)
        val SwiftUI = Skill(name = "SwiftUI", type = SkillType.FRAMEWORK.name, isActive = true)
        val RxSwift = Skill(name = "RxSwift", type = SkillType.LIBRARY.name, isActive = true)
        val spm = Skill(name = "Swift Package Manager", type = SkillType.DEPENDENCY.name, isActive = true)
        val firebase = Skill(name = "Firebase", type = SkillType.LIBRARY.name, isActive = true)
        val realm = Skill(name = "Realm-swift", type = SkillType.LIBRARY.name, isActive = true)
        val mvc = Skill(name = "Cocoa-MVC", type = SkillType.ARCHITECTURE.name, isActive = true)
        val mvvm = Skill(name = "MVVM", type = SkillType.ARCHITECTURE.name, isActive = true)
        val cleanArchitecture = Skill(name = "Clean-Architecture", type = SkillType.ARCHITECTURE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(swift, UIKit, SwiftUI, python, RxSwift, spm, firebase, realm, mvc, mvvm, cleanArchitecture))
        // Project / ProjectDetail / project_skill 초기화
        val project1 = Project(
            name = "PICO",
            description = "MBTI를 활용한 매칭 시스템을 통해 사용자 간 커뮤니케이션을 지원하는 APP",
            startYear = 2023,
            startMonth = 9,
            endYear = 2024,
            endMonth = 2,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "공용 컴포넌트 디자인 시스템 구축 -> 코드 재사용성 및 디자인 통일성 향상",
                    url = null, isActive = true),
                ProjectDetail(content = "푸시 알림 클릭 시 알림 종류에 따른 화면 이동 처리를 통한 사용자 경험 향상",
                url = null, isActive= true),
                ProjectDetail(content = "스크롤 시 데이터 페이징 처리를 통한 뷰 로딩 속도 개선 및 메모리 관리",
                url = null, isActive= true),
                ProjectDetail(content = "Github Repository",
                    url = "https://github.com/bangtori/final-pico", isActive = true),
                ProjectDetail(content = "App Store Link",
                    url = "https://apps.apple.com/kr/app/%ED%94%BC%EC%BD%94-pico-pick-connect/id6473959557", isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = swift),
                ProjectSkill(project = project1, skill = UIKit),
                ProjectSkill(project = project1, skill = firebase),
                ProjectSkill(project = project1, skill = RxSwift),
                ProjectSkill(project = project1, skill = mvvm),
            )
        )
        val project2 = Project(
            name = "CATCHMATE",
            description = "같은 팀을 응원하는 사람들을 만나 직관하고 싶은 혼직관러, 혹은 갑자기 빈 티켓 자리를위한 사람들을 위한 KBO 직관 친구 구하기 APP",
            startYear = 2024,
            startMonth = 6,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "iOS 앱 개발 기여도 100, 관리자 웹페이지 개발 기여도 50%",
                    url = null, isActive = true),
                ProjectDetail(content = "Clean Architecture Layer 기반의 Error 구조 개선으로 에러 발생 위치와 맥락 정보를 추가해 UX와 DX를 효과적으로 통합 개선",
                    url = null, isActive = true),
                ProjectDetail(content = " AOS, iOS, 디자이너 간 각기 다른 컴포넌츠 언어를 하나의 용어로 정리한 Product Language를 정립하여 각 직군과의 소통 편의성 강화",
                    url = null, isActive = true),
                ProjectDetail(content = "Github Repository",
                    url = "https://github.com/Dugout-Developers/CatchMate-iOS", isActive = true)
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = swift),
                ProjectSkill(project = project2, skill = UIKit),
                ProjectSkill(project = project2, skill = RxSwift),
                ProjectSkill(project = project2, skill = cleanArchitecture),
            )
        )

        val project3 = Project(
            name = "DYCOLOR",
            description = "코드로 색상값 생성 시 간편하게 다크모드를 대응할 수 있는 모델 제공 라이브러리",
            startYear = 2024,
            startMonth = 6,
            endYear = null,
            endMonth = null,
            isActive = true
        )
        project3.addDetails(
            mutableListOf(
                ProjectDetail(content = "모델 생성자 1줄의 컬러 생성 코드와 프로퍼티를 통해 화면 모드에 대응하는 컬러값을 접근하여 코드수 약 50 감소시켜 프로젝트의 가독성 향상",
                    url = null, isActive = true),
                ProjectDetail(content = "UIColor, Color extension hex code init, 밝기와 채도 조절 인스턴스 함수 제공하여 편리성 향상",
                    url = null, isActive = true),
                ProjectDetail(content = "Swift Package Manager 를 통한 라이브러리 배포",
                    url = null, isActive = true),
                ProjectDetail(content = "Github Repository",
                    url = "https://github.com/bangtori/DYColor", isActive = true)
            )
        )
        project3.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project3, skill = swift),
                ProjectSkill(project = project3, skill = UIKit),
                ProjectSkill(project = project3, skill = SwiftUI),
                ProjectSkill(project = project3, skill = spm),
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2, project3))
        log.info("✅ 데이터 초기화 완료")
    }
}