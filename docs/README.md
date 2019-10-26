# [Spring Boot]

- Embeded Tomcat 이용한 단독 실행
- Spring Actuator: 모니터링과 관리


## DB setting
```sql
create database codelab_db default character set utf8;

grant all privileges on codelab_db.* to codelab@localhost identified by 'codelab';

flush privileges;
```

#### 오류
```
You must reset your password using ALTER USER statement before executing this statement.
```
```
mysql> set password = password('PASSWORD');
```

https://kogun82.tistory.com/122

# 실습 1
## IntelliJ

1. Create Project - Spring initializr
2. New Project
3. Dependencies
	4. Dev Tools - `lombok`
	5. WEB - `Spring Web`
	6. SQL - `Spring Data JPA, MySQL Driver`

### DB 연결 정보 셋팅

1. `src` - `main` - `resources`
	1. application.properties 삭제
	1. application.yml 만들기
	```yaml
	spring:
	  datasource:
	    url: jdbc:mysql://127.0.0.1:3306/codelab_db?serverTimezone=Asia/Seoul&useSSL=false&characterEncoding=utf-8
	    username: codelab
	    password: codelab
	    driver-class-name: com.mysql.jdbc.Driver
	  jpa:
	    hibernate:
	      ddl-auto: update # 없으면 만들고 있으면 그대로 사용
	    show-sql: true # mysql debug mode, 실제 쿼리가 로그로 보임
	    database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
	    properties:
	      hibernate: # custom options
	        format_sql: true # sql 로그를 포매팅해서 보여줌
	logging:
	  level:
	    org.hibernate.type: trace # bind 쿼리의 내용까지 출력. ? 부분이 실제 값으로 표현됨
	server:
	  port: 8080
	```

---

- ddl-auto
	- update: 없으면 만들고 있으면 그대로 사용
	- create: 무조건 새로 만듦 


### 기본 컨트롤러  작성

1. `src` - `main` - `java` - `kr.codelabs.member`
	1. package: controller
	1. class: **MyController**
		1. `@RestController`
		1. `@GetMapping`


**RUN!!**

# 실습 2
## DB
1. `src` - `main` - `java` - `kr.codelabs.member`
	1. package: entity
	1. class: **Department**
		1. `@Entity`
		1. `@Table`
		1. `@Getter`
	1. package: repository
	1. interface: **DepartmentRepository**
	1. package: service
	1. interface: **DepartmentService**
	1. package: controller
	1. class: **DepartmentController**