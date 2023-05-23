package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {


    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping("/add")
    public Department add(@RequestBody Department department)
    {
        LOGGER.info("Department added{}"+department);
        return departmentRepo.add(department);
    }
    @GetMapping("/list")
    public List<Department> listall()
    {
        return departmentRepo.listall();
    }
    @GetMapping("/{id}")
    public Department findById(@PathVariable long id) {
        LOGGER.info("Department find: id={}", id);
        return departmentRepo.findbyid(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments
                = departmentRepo.listall();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())));
        return  departments;
    }

}


