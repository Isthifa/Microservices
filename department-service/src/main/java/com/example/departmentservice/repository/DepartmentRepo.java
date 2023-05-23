package com.example.departmentservice.repository;

import com.example.departmentservice.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepo {
    private List<Department> departments=new ArrayList<>();

    public Department add(Department department)
    {
        departments.add(department);
        return department;
    }

    public Department findbyid(long id)
    {
        return departments.stream().filter(department -> departments.get((int) id).equals(id)).findFirst().orElseThrow();
    }
    public List<Department> listall()
    {
        return departments;
    }
}
