package com.googleguice.modules;

import com.google.inject.AbstractModule;
import com.googleguice.annotations.ColorValue;
import com.googleguice.annotations.EdgeValue;
import com.googleguice.services.DrawShape;
import com.googleguice.services.DrawSquare;

public class AppModule extends AbstractModule
{
  @Override
  public void configure() {
    bind(DrawShape.class).to(DrawSquare.class);
    // Inline singleton declaration instead of putting the @Singleton on the DrawSquare class.
    // bind(DrawShape.class).to(DrawSquare.class).in(Scopes.SINGLETON);
    // bind(SquareRequest.class).to(SquareRequestSubClass.class);

    // Use to instantiate via instance
    // bind(String.class).toInstance("Red");
    // bind(Integer.class).toInstance(40);

    // Use to instantiate via annotations (annotations package)
    bind(String.class).annotatedWith(ColorValue.class).toInstance("Red");
    bind(Integer.class).annotatedWith(EdgeValue.class).toInstance(40);

  }
}
