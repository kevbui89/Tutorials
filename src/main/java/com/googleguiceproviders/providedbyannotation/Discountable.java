package com.googleguiceproviders.providedbyannotation;

import com.google.inject.ProvidedBy;

@ProvidedBy(DiscountProvider.class)
public interface Discountable {
  double getDiscount ();
}
