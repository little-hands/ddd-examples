package com.littlehands.design_principle.cohesion.bad_example;

class OperationUtil { // 責務が曖昧なクラス名
  private int count = 0;

  void increment() { // 何からの数値をインクリメント
    count++;
  }

  int getCount() {
    return count;
  }

  static void greet() { // 保持している数値関係ない挨拶
    System.out.println("hello.");
  }
}