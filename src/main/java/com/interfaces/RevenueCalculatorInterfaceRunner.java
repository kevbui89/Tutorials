package com.interfaces;

import com.abstraction.ClientEngagement;

public class RevenueCalculatorInterfaceRunner
{
  public static void main(String[] args) {
    final ClientEngagement clientEngagement =
        new ClientEngagement("Kevin", 100, 15_000);

    final double hourlyPrice = new HourlyRateCalculator(100).calculate(clientEngagement);
    System.out.println("hourlyPrice = " + hourlyPrice);
  }
}
