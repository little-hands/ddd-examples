package com.littlehands.design_principle.coupring.advance.good_example;


@SuppressWarnings("ALL")
public class CouplingMain {
  public static void main(String[] args) {
    PrinterType printerType = PrinterType.FILE;
    process(DIContainer.getPrinter(printerType));
  }

  static void process(Printer printer) {
    Counter counter = new Counter();
    printer.printCounter(counter);
    counter.increment();
    printer.printCounter(counter);
  }
}
