package com.littlehands.design_principle.coupring.basic.good_example;

public class CouplingMain {
  public static void main(String[] args) {
    Printer printer = new Printer();
    Counter counter = new Counter();

    printer.printCounter(counter);
    counter.increment();

    printer.printCounter(counter);          // このように渡す
//    printer.printInt(counter.getNumber());  // もしくはこう
  }
}
