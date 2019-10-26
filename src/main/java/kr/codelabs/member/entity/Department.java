package kr.codelabs.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
setCurrentTime 현재시간 넣어주는 메소드
 */

@Entity
@Table(name= "department") // 기본적으로 Table 이름은 클래스와 동일하게 만들어짐.
@Getter // 자동으로 getter 만들어줌
public class Department {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Long id;

    @Column // 이 변수는 DB 컬럼이다
    private String name;

    @Column(name = "created_at") // DB에 저장된 이름 지정
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /*
     */
    public void setCurrentTime() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(Department department) {
        this.name = department.getName();
        this.updatedAt = LocalDateTime.now();
    }

}
