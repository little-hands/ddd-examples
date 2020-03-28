package com.littlehands.design_principle.good_example;


public class CohesionMain {
  public static void main(String[] args) {
    Counter counter = new Counter();
    counter.increment();
    int count = counter.getCount();
    System.out.println(count);

    Greeter.printGreet();
  }
}
