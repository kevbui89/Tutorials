package com.googleguice.requests;

import lombok.Getter;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.googleguice.services.DrawShape;

@Singleton
public class SquareRequest
{
  // @Inject
  // This is a field injection, not recommended either
  // It is better to use constructore injection
  @Getter
  DrawShape drawShape;

  @Inject
  public SquareRequest(DrawShape drawShape) {
    this.drawShape = drawShape;
  }

  public void makeRequest() {
    drawShape.draw();
  }

  // Setter injection
  // Not recommended, it is better to use constructor injection
  // @Inject
  // public void setDrawShape(DrawShape d) {
  //   this.drawShape = d;
  // }
}
