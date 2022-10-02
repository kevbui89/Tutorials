package com.stream.app;

import com.stream.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEmployeeApp
{

    static List<Employee> employees = new ArrayList<>();
    static Employee[] arrayOfEmps = {
            new Employee(1, "Kevin Bui", 5000, List.of("Project 1", "Project 2")),
            new Employee(2, "Zachary Larouche", 2500, List.of("Project 2", "Project 3")),
            new Employee(3, "Victor Bui", 1000, List.of("Project 3", "Project 4"))
    };

    static {
        employees.add(
                new Employee(1, "Kevin Bui", 5000, List.of("Project 1", "Project 2"))
        );
        employees.add(
                new Employee(2, "Lorena Mendes", 2500, List.of("Project 1", "Project 3"))
        );
        employees.add(
                new Employee(3, "Guilherme Renna", 1000, List.of("Project 4", "Project 2"))
        );
        employees.add(
                new Employee(4, "Jake Tee", 4000, List.of("Project 3", "Project 4"))
        );
    }

    public static void main(String[] args) {
        /**
         * forEach()
         */
        // For array
        //Stream.of(arrayOfEmps).forEach(employee -> System.out.println(employee));

        // For list
        //employees.stream().forEach(employee -> System.out.println(employee));

        /**
         * map() & collect()
         */
        List<Employee> increasedSalary = employees.stream().map(employee -> new Employee(
                employee.getId(),
                employee.getName(),
                employee.getSalary() * 1.1,
                employee.getProjects()
        )).collect(Collectors.toList());
        //System.out.println(increasedSalary);

        /**
         * filter()
         */
        List<Employee> filteredEmployee =
                employees.stream().filter(employee -> employee.getSalary() >= 5000).map(employee -> new Employee(
                employee.getId(),
                employee.getName(),
                employee.getSalary() * 1.1,
                employee.getProjects()
        )).collect(Collectors.toList());
        //System.out.println(filteredEmployee);

        /**
         * findFirst()
         */
        Employee firstEmployee =
                employees.stream().filter(employee -> employee.getSalary() >= 5000).map(employee -> new Employee(
                        employee.getId(),
                        employee.getName(),
                        employee.getSalary() * 1.1,
                        employee.getProjects()
                )).findFirst().orElse(null);
        //System.out.println(firstEmployee);

        /**
         * flatMap()
         */
        String projects = employees.stream()
                .map(Employee::getProjects)
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));
        //System.out.println(projects);

        /**
         * Short-Circuit Operations
         */
        List<Employee> shortCircuitEmployee = employees.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());
        //System.out.println(shortCircuitEmployee);

        /**
         * Finite Data
         */
        Stream.generate(Math::random).limit(5)
                .forEach(System.out::println);

        /**
         * sorting
         */
        List<Employee> sortedEmployees = employees.stream()
                .sorted(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())))
                .collect(Collectors.toList());
        //System.out.println(sortedEmployees);

        /**
         * min() or max()
         */
        Employee maxEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        //System.out.println(maxEmployee);

        /**
         * reduce()
         */
        Double totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        //System.out.println(totalSalary);

        /**
         * parallel stream
         */
        Double totalSalaryParallel = employees.parallelStream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        //System.out.println(totalSalary);
    }
}
