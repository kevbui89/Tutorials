package com.reflection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cat
{
  private final String name;

  @Setter
  private int age;

  public void meow() {
    System.out.println("Meow");
  }

  private void heyThisIsPrivate() {
    System.out.println("How did you call this?");
  }

  public static void thisIsAPublicStaticMethod() {
    System.out.println("I'm public and static");
  }

  private static void thisIsAPrivateStaticMethod() {
    System.out.println("Hey, I'm private and static");
  }
}
