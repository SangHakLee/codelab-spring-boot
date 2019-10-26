package kr.codelabs.member.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "department") // 기본적으로 Table 이름은 클래스와 동일하게 만들어짐.
@Getter // 자동으로 getter 만들어줌
public class Department {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Long id;

    @Column // 이 변수는 DB 컬럼이다
    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
