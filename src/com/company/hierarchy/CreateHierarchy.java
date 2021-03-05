package com.company.hierarchy;

import java.util.*;

public class CreateHierarchy {

    private Map<Long, EmployeeRecord> employees;
    private EmployeeRecord root;

    public CreateHierarchy() {
        this.employees = new HashMap<>();
    }

    public void fillMap(String[] input){
        EmployeeRecord employeeRecord;
        for (String str : input) {
            String[] values = str.split("\\s+");
            if(values.length == 1){
                employeeRecord = new EmployeeRecord(values[0], null);
            }else{
                employeeRecord = new EmployeeRecord(values[0], values[1]);
            }
            this.employees.put(employeeRecord.getId(), employeeRecord);
            if(employeeRecord.getManagerId() == null){
                this.root = employeeRecord;
            }
        }

        fillRecords(this.root);
    }


    private List<EmployeeRecord> getSubordinates(Long managerId) {
        List<EmployeeRecord> subordinates = new ArrayList<>();
        for (EmployeeRecord emp : this.employees.values()) {
            if(managerId.equals(emp.getManagerId())){
                subordinates.add(emp);
            }
        }
        return subordinates;
    }

    private void fillRecords(EmployeeRecord traversal){

        List<EmployeeRecord> subordinates = getSubordinates(traversal.getId());
        traversal.setEmployees(subordinates);
        if(subordinates.size() == 0){
            return;
        }
        for (EmployeeRecord subordinate : subordinates) {
            fillRecords(subordinate);
        }
        System.out.println("Manager id:" + traversal.getId());
        System.out.print("Employees: ");
        traversal.getEmployees().forEach(employeeRecord -> System.out.print("Id:" + employeeRecord.getId() + " "));
        System.out.println();
    }
}
