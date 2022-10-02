package com.googleguiceproviders.toto;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import static com.googleguiceproviders.customfactory.DiscountGuiceModule.DiscountOption.*;
import com.googleguiceproviders.customfactory.DiscountGuiceModule.DiscountOption;
import com.googleguiceproviders.customfactory.*;


import java.time.LocalTime;
import java.util.Map;

@Singleton
public class DiscountFactory {

  final Map<DiscountOption, Provider<Discountable>> discountableBinder;

  @Inject
  public DiscountFactory(Map<DiscountOption, Provider<Discountable>> mapBinder) {
    this.discountableBinder = mapBinder;
  }

  public Discountable getDiscount(LocalTime localTime) {
    return getDiscountProvider(localTime).get();
  }

  private Provider<Discountable> getDiscountProvider(LocalTime localTime) {
    int currentHour = localTime.getHour();

    if (isEarlyMorning(currentHour)) {
      return discountableBinder.get(EarlyBird);
    } else if (isLateAtNight(currentHour)) {
      return discountableBinder.get(NightOwl);
    }

    return discountableBinder.get(NoDiscount);
  }

  private boolean isEarlyMorning(int currentHour) {
    return (currentHour >= 5 && currentHour <= 9);
  }

  private boolean isLateAtNight(int currentHour) {
    return (currentHour >= 0 && currentHour <= 4);
  }
}
