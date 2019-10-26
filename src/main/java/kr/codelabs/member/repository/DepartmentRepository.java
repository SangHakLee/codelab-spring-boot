package kr.codelabs.member.repository;

import kr.codelabs.member.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
1. @Repository
2. extends JpaRepository<Department, Long>
    - JpaRepository 이 기본적인 ORM 함수 갖고 있다. findById, ...

---

findByName
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String string);
}
