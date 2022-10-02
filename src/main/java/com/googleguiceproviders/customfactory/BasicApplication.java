package com.googleguiceproviders.customfactory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class BasicApplication {

  private final CheckoutService checkoutService;

  @Inject
  public BasicApplication(CheckoutService checkoutService) {
    this.checkoutService = checkoutService;
  }

  void start() {
    while (true) {
      checkoutService.checkout(getNewUserCheckout());
    }
  }

  public static void main(String[] args) {
    // 1. Injecting master factory (Guice in this case)
    Injector guice = Guice.createInjector(new DiscountGuiceModule());
    // 2. Inject your application and create a separate object containing all your
    // business and application logic
    BasicApplication application = guice.getInstance(BasicApplication.class);
    // 3. Call your top level class (BasicApplication in this example)
    // Guice will inject all static dependency that were requested via @Inject/etc.
    application.start();
  }



  /**********************************************************/
  /****************  Our GUI simulator **********************/
  /**********************************************************/

  ShoppingCart getNewUserCheckout() {
    ShoppingCart cart = new ShoppingCart();
    cart.setCartTotal(getTotalFromInput());
    cart.setTimeOfCheckout(getCheckoutTimeFromInput());

    return cart;
  }

  private double getTotalFromInput() {
    String total = null;
    System.out.print("Enter cart total: ");

    try {
      BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
      total = bufferRead.readLine();
    } catch (IOException doh) {
    }

    return Double.valueOf(total);
  }

  private LocalTime getCheckoutTimeFromInput() {
    LocalTime checkoutTime = null;
    String hour = null;
    System.out.print("Enter Checkout hour: ");

    try {
      BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
      hour = bufferRead.readLine();
    } catch (IOException doh) {
    }

    return LocalTime.of(Integer.valueOf(hour), 0);
  }
}


