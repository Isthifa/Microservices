package com.example.employeeservice.entity;

public record Employee(Long id, Long departmentId, String name, int age, String position) {
}
