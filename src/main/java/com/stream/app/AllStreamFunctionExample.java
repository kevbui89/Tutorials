package com.stream.app;

import com.stream.model.Employee;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AllStreamFunctionExample {

    static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(
                new Employee(1, "Kevin Bui", 1000, List.of("Project 1", "Project 2"))
        );
        employees.add(
                new Employee(2, "Lorena Mendes", 1500, List.of("Project 1", "Project 3"))
        );
        employees.add(
                new Employee(3, "Guilherme Renna", 1200, List.of("Project 4", "Project 2"))
        );
        employees.add(
                new Employee(4, "Jake Tee", 500, List.of("Project 3", "Project 4"))
        );
    }

    public static void main(String[] args) {

        // forEach() is a terminal operation, once the operation is performed
        // the stream pipeline is consumed and can no longer be used.
        employees.forEach(employee -> employee.incrementSalary(0.1));
        employees.forEach(System.out::println);

        // map() produces a new stream after applying function to each element
        // the new stream can be a different type
        // in this case, the list of employees is mapped to their integer ids
        // collect() gets the stuff out of the stream once done processing
        List<Integer> employeeIdList = employees.stream().map(Employee::getId).collect(Collectors.toList());
        System.out.println("\n" + List.of(employeeIdList));

        // filter() produces a new stream that contains elements of the first stream that pass
        // a given criteria
        List<Employee> filteredEmployee = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .collect(Collectors.toList());
        System.out.println("\n" + List.of(filteredEmployee));

        // findFirst() returns an Optional for the first entry in the stream
        // conditions can be used for this
        Optional<Employee> firstEmp = employees.stream()
                .filter(employee -> employee.getSalary() > 1000)
                .findFirst();
        System.out.println("\n" + firstEmp);

        // this should produce an Optional.empty as there are no employees below 500
        Optional<Employee> firstEmpOptional = employees.stream()
                .filter(employee -> employee.getSalary() < 500)
                .findFirst();
        System.out.println("\n" + firstEmpOptional);

        // toArray() is used to get an array out of a stream
        // Employee[]::new creates a new empty array of Employee
        Employee[] empArray = employees.toArray(Employee[]::new);
        System.out.println("\n" + Arrays.toString(empArray));

        //flatMap() flattens the data structure
        // Example: Stream<List<String>> -> Stream<String>
        List<List<String>> nestedNames = Arrays.asList(
                Arrays.asList("Kevin", "Bui"),
                Arrays.asList("Zachary", "Larouche"),
                Arrays.asList("Jake", "Tat"));

        // Output: [Kevin, Bui, Zachary, Larouche, Jake, Tat]
        List<String> flatNameList = nestedNames.stream()
                .flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("\n" + flatNameList + "\n");

        // peek() performs the specified operation on each element of the stream before
        // any terminal operation is applied
        employees.stream()
                .peek(employee -> employee.incrementSalary(0.10))
                .peek(System.out::println)
                .collect(Collectors.toList());

        // intermediate operations return a new stream, and further processing can be done
        // terminal operations marks the stream as consumed, and can no longer be used

        System.out.println("\nEmployee above 1000 salary: " + employees
                .stream()
                .filter(employee -> employee.getSalary() > 1000)
                .count());

        // some operations are deemed short-circuiting operations.
        // they allow computations on infinite streams to complete in finite time.
        Stream<Integer> inifiteStream = Stream.iterate(2, integer -> integer * 2);

        // skip will skip the first 3
        List<Integer> collect = inifiteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("\n" + collect);

        // sorted() sorts the stream elements based on the comparator provided
        List<Employee> sortedEmployee = employees.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
        System.out.println("\n" + sortedEmployee);

        // min() and max() return the minimum/maximum element of a stream
        Employee firstEmployee = employees.stream()
                .min((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);
        Employee lastEmployee = employees.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);
        System.out.println("\nFirst Employee: " + firstEmployee);
        System.out.println("\nLast Employee: " + lastEmployee);

        Employee maxSalaryEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("\nMaximum Salary Employee: " + maxSalaryEmployee);

        // distinct() does not take any argument, returns the distinct elements in
        // a stream, eliminating the duplicates
        // it uses equals() to decide whether two elements are equal or not
        List<Integer> intList = Arrays.asList(2,5,3,2,3,4,4,6);
        List<Integer> distinctIntList = intList.stream()
                .distinct().collect(Collectors.toList());
        System.out.println("\n" + distinctIntList);

        // allMatch(), anyMatch() and nonMatch()
        // these operations take a predicate and return a boolean
        // short-circuiting is applied and processing is stopped when a result is found

        // allMatch() returns true if all elements of the stream match condition
        List<Integer> ints = Arrays.asList(2,4,5,6,8);
        // returns false when it hits 5
        boolean allEven = ints.stream().allMatch(i -> i % 2 == 0);
        // returns true when it hits 2
        boolean anyMatch = ints.stream().anyMatch(i -> i % 2 == 0);
        // returns false when it hits 2
        boolean nonMatch = ints.stream().noneMatch(i -> i % 2 == 0);

        System.out.println("\nAll Even: " + allEven);
        System.out.println("\nAny Match: " + anyMatch);
        System.out.println("\nNon Match: " + nonMatch);

        // IntStream, LongStream and DoubleStream are primitive specializations
        // they extend BaseStream
        // most common way of creating an IntStream is mapToInt()
        int latestEmpId = employees.stream()
                .mapToInt(Employee::getId).max()
                .orElseThrow(NoSuchElementException::new);
        System.out.println("\n" + latestEmpId);

        // other methods of initializing IntStream
        // you can use boxed() to transform IntStream into Stream<Integer>
        List<Integer> intStream = IntStream.of(1,2,3).boxed()
                .collect(Collectors.toList());

        List<Integer> intStream2 = IntStream.range(10,19).boxed()
                .collect(Collectors.toList());

        System.out.println("\n" + intStream);
        System.out.println("\n" + intStream2);

        // sum(), average(), range(), etc.
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElseThrow(NoSuchElementException::new);
        double sumSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        List<Integer> rangeInteger = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        System.out.println("\nAverage Salary: " + averageSalary);
        System.out.println("\nSum Salary: " + sumSalary);
        System.out.println("\nRange Integer: " + rangeInteger);

        // reduce()T reduce(T identity, BinaryOperator<T> accumulator)
        // takes a sequence of input elements and combines them into a single summary result
        // by repeated application of a combining operation
        employees.get(0).setSalary(10);
        employees.get(1).setSalary(20);
        employees.get(2).setSalary(15);
        employees.get(3).setSalary(10);

        // identity is the base value
        Double sumSalaryReduce = employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);
        System.out.println("\nReduce Sum Salary: " + sumSalaryReduce);

        // joining() will insert a delimiter between String elements
        String employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("\n" + employeeNames);

        // toSet() get a set out of a stream
        Set<String> setEmployeeName = employees.stream()
                .map(Employee::getName).collect(Collectors.toSet());
        System.out.println("\n" + setEmployeeName);

        // toCollection get a collection out of a stream
        //The Vector class implements a growable array of objects.
        // Like an array, it contains components that can be accessed
        // using an integer index. However, the size of a Vector can grow or shrink
        // as needed to accommodate adding and removing items after the Vector has been created.
        Collection<String> collectionEmployeeName = employees.stream()
                .map(Employee::getName).collect(Collectors.toCollection(Vector::new));
        System.out.println("\n" + collectionEmployeeName);

        // groupingBy() is a classification function that is applied to each element
        // of the stream
        Map<Character, List<Employee>> alphabetEmployee = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getName().charAt(0)));
        System.out.println("\n" + alphabetEmployee.get('K').get(0).getName());

        // mapping() maps the stream elements into a particular type
        Map<Character, List<Integer>> idGroupedByAlphabet = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.mapping(Employee::getId, Collectors.toList())));
        System.out.println("\nID With Letter K at position 0: " + idGroupedByAlphabet.get('K').get(0));

        // infinite streams
        // generate()
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // iterate()
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
        List<Integer> collectEven = evenNumStream
                .limit(5)
                .collect(Collectors.toList());


        // takeWhile() takes while a given condition is true
        // stops evaluating as soon as it finds the first occurrence where the condition is false
        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .takeWhile(x -> x <= 5)
                .forEach(System.out::println);

        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .filter(x -> x <= 5)
                .forEach(System.out::println);

        // dropWhile()
        // the method drop while will stop dropping after the first element that fails
        // to match the predicate
        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .dropWhile(x -> x <= 5)
                .forEach(System.out::println);
    }
}
