package com.tori.portfolio.domain.entity

import com.tori.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean
): BaseEntity() {
    @Id // PK 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    var name: String = name
    @Column(name = "skill_type") // 따로 type이 아닌 skill_type으로 데이터베이스 컬럼명을 지정하는 이유는 type은 데이터베이스에 따라 예약어일 수 있기때문에 조심해야함
    @Enumerated(value = EnumType.STRING) // 기본값은 코드 작성 순서대로 정수가 지정되는데 이는 코드 변경 시 데이터가 어긋날 수 있으므로 String으로 선언 꼭하기, String은 enum 이름 그대로 들어감
    var type: SkillType = SkillType.valueOf(type)
    var isActive: Boolean = isActive
}