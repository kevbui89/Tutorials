package com.abstractionandinterfaces.abstraction;

public class HourlyRateCalculator extends RevenueCalculator
{
  private static final double HOURLY_RATE = 50;

  private final double hourlyRate;

  public HourlyRateCalculator(final double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  @Override
  public double calculate(final ClientEngagement clientEngagement)
  {
    return HOURLY_RATE * clientEngagement.getHoursWorked();
  }
}
