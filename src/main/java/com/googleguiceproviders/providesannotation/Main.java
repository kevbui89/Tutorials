package com.googleguiceproviders.providesannotation;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

  public static void main(String[] args) {
    // 1. Injecting master factory (Guice in this case)
    Injector guice = Guice.createInjector(new DiscountGuiceModule());
    // 2. Inject your application and create a separate object containing all your
    // business and application logic
    CheckoutService service = guice.getInstance(CheckoutService.class);
    // 3. Call your top level class (Main in this example)
    // Guice will inject all static dependency that were requested via @Inject/etc.
    service.checkout(100.00D);
  }
}
