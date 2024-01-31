package org.charles.coding.exercises;

public class Employee {
    private String empName;
    private int empSalary;

    public Employee(String empName, int empSalary) {
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }
}
