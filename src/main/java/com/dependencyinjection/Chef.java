package com.dependencyinjection;

public class Chef
{
  private Food food;

  // used for field injection
  public Food pubFood;

  // constructor injection: this is the most recommended
  // the dependencies are provided through a class constructor
  // we provide the class we depend on (food) while instantiating the chef object.
  public Chef(Food food) {
    this.food = food;
  }

  // setter injection: the client exposes a setter method that the injector
  // uses to inject the dependency.  Instead of having a constructor parameter
  // we will have a setter to pass it
  // this approach is not very recommended because by doing that, we hid that dependency
  // and by reading the constructor signature or creating our main object, we cannot
  // identify that there is a dependency right away and may cause NullPointerExceptions
  public Chef() {}

  public void setFood(Food food) {
    this.food = food;
  }

  // field injection: the only way for field injection to work is either directly mutate the
  // field because it's a non-private and non-final field, or modify a final/private field
  // using reflection
  // this method has the same problem as the setter injection
  // this type of injection adds complexity due to the mutation or reflection required
  // Chef chef = new Chef();
  // chef.pubFood = new Pizza();

  public void prepareFood() {
    //TODO
  }

  // Inversion of Control: principle in software engineering which transfers the control of
  // objects or portions of a program to a framework
  // Enables a framework to take control over the flow of a program and make calls to our custom code
  // to do this, frameworks use abstractions, hence, to add a behavior, we extend the classes
  // of the framework
}
