package com.googleguiceproviders.providesannotation;

//import com.google.inject.Provides;
import com.google.inject.Provides;
import java.time.LocalTime;

//import com.google.inject.Provides;
//import java.time.LocalTime;
public class DiscountGuiceModule extends com.google.inject.AbstractModule {

  @Override
  protected void configure() {
    //bind(Discountable.class).toProvider(DiscountProvider.class);
    //removed DiscountProvider implementation from example
  }

  // The @Provides annotation does what bind does
  // It binds Discountable to the @Provides annotation
  // It will create the class for you (EarlyBirdDiscount/NightOwlDiscount/NoDiscount)
  // Meant for simple logic, else use the Provider Design Pattern
  // You are not injecting in the provider
  @Provides
  public Discountable get() {
    int hour = LocalTime.now().getHour();

    if (isEarlyMorning(hour)) {
      return new EarlyBirdDiscount();
    } else if (isLateAtNight(hour)) {
      return new NightOwlDiscount();
    }

    return new NoDiscount();
  }

  private boolean isEarlyMorning(int currentHour) {
    return (currentHour >= 5 && currentHour <= 9);
  }

  private boolean isLateAtNight(int currentHour) {
    return (currentHour >= 0 && currentHour <= 4);
  }

}

