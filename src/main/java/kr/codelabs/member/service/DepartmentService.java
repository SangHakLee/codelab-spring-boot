package kr.codelabs.member.service;


import kr.codelabs.member.entity.Department;
import kr.codelabs.member.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
1. @Service
2. 전체 부서 조회 API 생성
3. @AllArgsConstructor : 생성자를 통한 주입
4. getAllDepartment
 */

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll(); // JPA 기본적으로 제공하는 ORM 함수 사용
    }
}
