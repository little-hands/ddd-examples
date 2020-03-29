package com.littlehands.design_principle.coupring.advance.bad_example;


@SuppressWarnings("ALL")
public class CouplingMain {
  static boolean isLocal = false;

  public static void main(String[] args) {
    process();
  }

  static void process() {
    Counter counter = new Counter();
    Printer printer = new Printer();

    printer.printCounter(counter);
    counter.increment();

    printer.printCounter(counter);          // このように渡す
  }
}
