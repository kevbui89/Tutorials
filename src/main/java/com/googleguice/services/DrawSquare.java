package com.googleguice.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.googleguice.annotations.ColorValue;
import com.googleguice.annotations.EdgeValue;

@Singleton
public class DrawSquare implements DrawShape
{
  private String color;
  private Integer edge;

  @Inject
  public DrawSquare(@ColorValue String color, @EdgeValue Integer edge) {
    super();
    this.color = color;
    this.edge = edge;
  }

  @Override
  public void draw()
  {
    System.out.println("Draw Square of color " + color + " and edge " + edge);
  }
}
