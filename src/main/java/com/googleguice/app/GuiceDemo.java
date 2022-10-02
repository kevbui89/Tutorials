package com.googleguice.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.googleguice.modules.AppModule;
import com.googleguice.requests.SquareRequest;

@Singleton
public class GuiceDemo
{
  private static final String SQUARE_REQ = "SQUARE";

  public static void main(String[] args) {
    sendRequestGuice(SQUARE_REQ);
  }

  /**
   * Code done with GUICE
   * @param request
   */
  private static void sendRequestGuice(String request) {
    if (request.equals(SQUARE_REQ)) {
      Injector injector = Guice.createInjector(new AppModule());
      SquareRequest sq = injector.getInstance(SquareRequest.class);
      sq.makeRequest();

      // You can also run the code below
      // Injector injector = Guice.createInjector(new AppModule());
      // DrawShape d = injector.getInstance(DrawShape.class);
      // SquareRequest request = new SquareRequest(d);
      // request.makeRequest();

      SquareRequest sq2 = injector.getInstance(SquareRequest.class);
      sq2.makeRequest();

      System.out.println("Were the draw shapes equal: " + (sq.getDrawShape() == sq2.getDrawShape()));
      System.out.println("Were square requests equal: " + (sq == sq2));
    }
  }
}
