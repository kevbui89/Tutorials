package com.googleguiceproviders.implicitprovider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.googleguiceproviders.explicitprovider.DiscountGuiceModule;

public class Main {

  public static void main(String[] args) {
    Injector guice = Guice.createInjector(new DiscountGuiceModule());
    CheckoutService service = guice.getInstance(CheckoutService.class);

    service.checkout(100.00D);
  }
}
