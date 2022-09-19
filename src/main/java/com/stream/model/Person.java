package com.stream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int age;
    private String city;

    @Override
    public String toString() {
        return "Person{name=" + name + ", age=" + age + ", city=" + city + "}";
    }
}
