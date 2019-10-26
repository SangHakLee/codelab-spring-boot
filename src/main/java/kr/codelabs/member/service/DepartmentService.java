package kr.codelabs.member.service;


import kr.codelabs.member.entity.Department;
import kr.codelabs.member.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Department getDepartment(Long id) { // `long` 은 null 불가
        Department department = departmentRepository.findById(id).orElse(null); // other는 문자가 아님

        if (department == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Department not found"
            );
        }
        return department;
    }

    public Department getDepartmentByName(String name) {
        Department department = departmentRepository.findByName(name).orElse(null);

        if (department == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Department not found"
            );
        }
        return department;
    }

    public Department createDepartment(Department department) {
        department.setCurrentTime();
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department) {
        Department savedDepartment = departmentRepository.findById(id).orElse(null); // other는 문자가 아님

        if (savedDepartment == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Department not found"
            );
        }

        savedDepartment.update(department);
        return departmentRepository.save(savedDepartment);
    }

    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null); // other는 문자가 아님

        if (departmentRepository.findById(id).orElse(null) == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Department not found"
            );
        }
        departmentRepository.deleteById(id);

    }

}
