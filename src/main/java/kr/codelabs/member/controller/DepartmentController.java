package kr.codelabs.member.controller;

import kr.codelabs.member.entity.Department;
import kr.codelabs.member.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
컨트롤러에선 파라미터 조작만 할것,

1. @RestController
1. @RequestMapping : api end-point url 지정
    /api/departments
 */

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<?> getAllDepartment() { // ?: wildcard
        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }
}
