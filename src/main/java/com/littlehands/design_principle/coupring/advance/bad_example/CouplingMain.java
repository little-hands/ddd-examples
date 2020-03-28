package com.littlehands.design_principle.coupring.advance.bad_example;


public class CouplingMain {
  static boolean isLocal = false;

  public static void main(String[] args) {
    Counter counter = new Counter();
    Printer printer = new Printer();

    printer.printCounter(counter);
    counter.increment();

    printer.printCounter(counter);          // このように渡す
  }
}
