package com.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetWithComparatorExample {
    public void perform() {

        // Objects to be placed in the set
        Employee emps[] = {new Employee("Finance", "Degree, Debbie"),
                new Employee("Finance", "Grade, Geri"),
                new Employee("Finance", "Extent, Ester"),
                new Employee("Engineering", "Measure, Mary"),
                new Employee("Engineering", "Amount, Anastasia"),
                new Employee("Engineering", "Ratio, Ringo"),
                new Employee("Sales", "Stint, Sarah"),
                new Employee("Sales", "Pitch, Paula"),
                new Employee("Support", "Rate, Rhoda"),};

        // Convert the array into an object that supporst the Set interface
        Set<Employee> set = new TreeSet<>(Arrays.asList(emps));
        System.out.println("Set");
        System.out.println(set);

        // Initializes a TreeSet with a Collections algorithm
        Set<Employee> set2 = new TreeSet<>(Collections.reverseOrder());
        set2.addAll(Arrays.asList(emps));
        System.out.println("Set2");
        System.out.println(set2);

        // Initializes a TreeSet with a comparator
        Set<Employee> set3 = new TreeSet<>(new EmpComparator());
        for (int i = 0, n = emps.length; i < n; i++) {
            set3.add(emps[i]);
        }
        System.out.println("Set3");
        System.out.println(set3);
    }

    public static void main(String args[]) throws Exception {
        SetWithComparatorExample ace = new SetWithComparatorExample();
        ace.perform();
        System.exit(0);
    }
}

/**
 * Comparator class
 *
 * @author Ken Fogel
 */
class EmpComparator implements Comparator<Object> {

    @Override
    public int compare(Object obj1, Object obj2) {
        Employee emp1 = (Employee) obj1;
        Employee emp2 = (Employee) obj2;

        int nameComp = emp1.getName().compareTo(emp2.getName());

        return ((nameComp == 0) ? emp1.getDepartment().compareTo(
                emp2.getDepartment()) : nameComp);
    }
}

/**
 * Employee class
 *
 * @author Ken Fogel
 */
class Employee implements Comparable<Object> {

    String department, name;

    public Employee(String department, String name) {
        this.department = department;
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[dept=" + department + ",name=" + name + "]";
    }

    @Override
    public int compareTo(Object obj) {
        Employee emp = (Employee) obj;
        int deptComp = department.compareTo(emp.getDepartment());

        return ((deptComp == 0) ? name.compareTo(emp.getName()) : deptComp);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee emp = (Employee) obj;
        return department.equals(emp.getDepartment())
                && name.equals(emp.getName());
    }

    @Override
    public int hashCode() {
        return 31 * department.hashCode() + name.hashCode();
    }
}
