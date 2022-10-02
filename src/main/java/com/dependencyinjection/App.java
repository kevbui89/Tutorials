package com.dependencyinjection;

public class App
{
  public static void main(String[] args) {

    // Dependency injection: decoupled the construction of our main class from the
    // construction of its dependencies
    // main class: chef class
    // dependency: food class
    Chef pizzaChef = new Chef(new Pizza());

  }
}
