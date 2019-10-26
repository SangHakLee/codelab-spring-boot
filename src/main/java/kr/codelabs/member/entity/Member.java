package kr.codelabs.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
public class Member {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Long id;

    @Column // 이 변수는 DB 컬럼이다
    private String name;

    @Column(name = "department_id")
    private Long departmentId;


    @Column(name = "created_at") // DB에 저장된 이름 지정
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void setCurrentTime() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(Member member) {
        this.name = member.getName();
        this.updatedAt = LocalDateTime.now();
    }
}
