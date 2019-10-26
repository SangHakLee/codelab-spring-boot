package kr.codelabs.member.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.codelabs.member.entity.Department;
import kr.codelabs.member.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "전체 부서 조회", notes = "모든 부서를 조회하는 API")
    public ResponseEntity<?> getAllDepartment() { // ?: wildcard
        List<Department> departments = departmentService.getAllDepartments();

        return ResponseEntity.ok(departments);
    }

    @ApiOperation(value = "부서 조회", notes = "ID 검색")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "부서 ID", paramType = "path", dataType = "long")
    })
    @GetMapping("/departments/{id}") // {id}: PathVariable
    public ResponseEntity<?> getDepartment(@PathVariable Long id) { // @PathVariable url로 넘어 온 값 사용
        Department department = departmentService.getDepartment(id);

        return ResponseEntity.ok(department);
    }

    @GetMapping("/departments/name") // /name: RequestParam
    public ResponseEntity<?> getDepartmentByName(@RequestParam String name) { // @RequestParam 파라미터로 넘어 온 값 사용
        Department department = departmentService.getDepartmentByName(name);

        return ResponseEntity.ok(department);
    }

    /*
    {
        "name": "기획"
    }
     */
    @PostMapping("/departments")
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        return new ResponseEntity<>(
                departmentService.createDepartment(department),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return new ResponseEntity<>(
                departmentService.updateDepartment(id, department),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
