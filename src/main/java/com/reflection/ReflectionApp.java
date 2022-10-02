package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionApp
{
  public static void main(String[] args) throws IllegalAccessException, InvocationTargetException
  {
    Cat myCat = new Cat("Stella", 6);
    Field[] catFields = myCat.getClass().getDeclaredFields();

    // gets access to all the fields of the class
    Stream.of(catFields).map(Field::getName)
        .collect(Collectors.toList()).forEach(System.out::println);

    // notice the Cat class does not have a setter and the name field is FINAL
    // myCat.name = "new name" will not compile as it is private and final
    // you can change the field even though it is not accessible and there are no setters
    // the setAccessible(true) allows Java to access this variable and modify it
    for(Field field : catFields) {
      if (field.getName().equals("name")) {
        field.setAccessible(true);
        field.set(myCat, "Kevin");
      }
    }

    System.out.println(myCat.getName());

    Method[] catMethods = myCat.getClass().getDeclaredMethods();
    Stream.of(catMethods).map(Method::getName).collect(Collectors.toList()).forEach(
        System.out::println);

    // you can execute any method to trigger methods, even if they are private
    for (Method method : catMethods) {
      if (method.getName().equals("meow")) {
        method.invoke(myCat);
      } else if (method.getName().equals("heyThisIsPrivate")) {
        method.setAccessible(true);
        method.invoke(myCat);
        // For static methods, you don't need an object to call them, so you can put null as argument
        // You can simply use invoke(null)
      } else if (method.getName().equals("thisIsAPublicStaticMethod")) {
        method.setAccessible(true);
        method.invoke(null);
      } else if (method.getName().equals("thisIsAPrivateStaticMethod")) {
        method.setAccessible(true);
        method.invoke(null);
      }
    }

    // Why use this?
    // This is use all over the place in frameworks such as Spring
    // The Spring framework for example uses reflection all over the place
    // because it has to be compatible with code that hasn't even been written yet
    // When you use a tool like Spring, it uses reflection to look at all the classes
    // that have written in your own code and also uses reflection to create objects
    // of those classes and manipulate them and inject them into other classes.

    // it may also be useful while testing when you need to set a specific field or
    // trigger a specific method.

    // Reflection is very easy to break!
    // It is not compiled (no compile optimisation) because it is done at runtime
    // If you can write code without reflection, it is best to do so
  }
}
