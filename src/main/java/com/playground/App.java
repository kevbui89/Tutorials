package com.playground;

import java.util.Random;

public class App
{
  public static void main(String[] args) {
    double random = Math.random();
    if (random > 0.5) {
      //System.out.println("Tails");
    } else {
      //System.out.println("Heads");
    }
    //System.out.println(random);

    // Random object
    Random rand = new Random();
    int num = rand.nextInt(2);
    // System.out.println(num);

    double modulus = 6.5 % 2;
    System.out.println(modulus);

  }

}
