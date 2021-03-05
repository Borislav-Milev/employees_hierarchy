package com.company.hierarchy;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRecord {

    private Long id;
    private Long managerId;
    private List<EmployeeRecord> employees;

    public EmployeeRecord(String id, String managerId) {
        this.id = Long.parseLong(id);
        this.managerId = managerId == null ? null : Long.valueOf(managerId);
        this.employees = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public List<EmployeeRecord> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeRecord> employees) {
        this.employees = employees;
    }
}
