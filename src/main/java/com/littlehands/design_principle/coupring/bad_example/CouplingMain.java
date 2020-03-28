package com.littlehands.design_principle.coupring.bad_example;

public class CouplingMain {
  public static void main(String[] args) {
    Printer.print();         // 0を出力
    Counter.increment();

    // Printer.print();      // 何が出力される？
  }
}
