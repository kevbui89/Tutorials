package com.abstraction;

import static com.abstraction.FixedFeeCalculator.*;

public class RevenueCalculatorRunner
{
  public static void main(String[] args) {
    final ClientEngagement clientEngagement =
        new ClientEngagement("Kevin", 100, 15_000);

    final double hourlyPrice = new HourlyRateCalculator(100).calculate(clientEngagement);
    System.out.println("hourlyPrice = " + hourlyPrice);

    final double fixedFeePrice = new FixedFeeCalculator(STANDARD_FEE).calculate(clientEngagement);
    System.out.println("fixedFeePrice = " + fixedFeePrice);

    final double royaltySharePrice = new RoyaltyShareCalculator(0.15).calculate(clientEngagement);
    System.out.println("royaltySharePrice = " + royaltySharePrice);

    // Since it was declared as a HourlyRateCalculator
    // It will use the calculate method from the HourlyRateCalculator class
    RevenueCalculator revenueCalculator = new HourlyRateCalculator(50);
    final double price = revenueCalculator.calculate(clientEngagement);
    System.out.println("Polymorphism - hourly price = " + price);

    // Since it was declared as a FixedFeeCalculator
    // It will use the calculate method from the FixedFeeCalculator class
    RevenueCalculator revenueCalculator2 = new FixedFeeCalculator(STANDARD_FEE);
    final double price2 = revenueCalculator2.calculate(clientEngagement);
    System.out.println("Polymorphism - fixed fee price = " + price2);
  }
}
