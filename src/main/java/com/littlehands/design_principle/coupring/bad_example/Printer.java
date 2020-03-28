package com.littlehands.design_principle.coupring.bad_example;

class Printer {
  static void print() {
    System.out.println(Counter.number); // 処理結果がCounterの内部の値に依存している
  }
}
