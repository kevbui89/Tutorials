package com.googleguiceproviders.customfactory;

import com.google.inject.ImplementedBy;

// You can use the @ImplementedBy annotation if your interface
// only has one implementation
@ImplementedBy(CartDiscountFactory.class)
interface DiscountFactory {
  public Discountable getDiscount(ShoppingCart cart);
}