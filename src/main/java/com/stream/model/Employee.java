package com.stream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private double salary;

    private List<String> projects;

    @Override
    public String toString() {
        return "Employee{" + "id_=" + id + ", name_='" + name + '\'' + ", salary_=" + salary + ", projects_=" + projects + '}';
    }

    public void incrementSalary(double percent) {
        this.salary = (salary * percent) + salary;
    }
}
