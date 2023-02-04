package com.optional;

import java.util.Optional;

/**
 * To view more, visit https://www.baeldung.com/java-optional
 */
public class OptionalTutorial
{
  public static void main(String[] args) {
    Optional<String> empty = Optional.empty();
    // Optional.empty
    System.out.println(empty);

    String name = "Kevin";
    Optional<String> optOne = Optional.of(name);
    // Kevin
    System.out.println(optOne.get());

    String nameTwo = "baeldung";
    Optional<String> optTwo = Optional.ofNullable(nameTwo);
    // Optional[baeldung]
    System.out.println(optTwo);

    String nullName = null;
    String optThree = Optional.ofNullable(nullName).orElse("john");
    // john
    System.out.println(optThree);

    String nullNameTwo = null;
    String optFour = Optional.ofNullable(nullNameTwo).orElseGet(() -> "john");
    // john
    System.out.println(optFour);
  }
}
