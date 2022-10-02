package com.googleguice.requests;

import com.google.inject.Inject;
import com.googleguice.services.DrawShape;

public class SquareRequestSubClass extends SquareRequest
{
  @Inject
  public SquareRequestSubClass(DrawShape drawShape)
  {
    super(drawShape);
  }
  @Override
  public void makeRequest() {
    System.out.println("Deletating call to draw method");
    drawShape.draw();
  }
}
