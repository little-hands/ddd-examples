package com.littlehands.cohesion.bad_example;

import lombok.Getter;

@Getter
class OperationUtil { // 責務が曖昧なクラス名
  private int count = 0;

  void increment() { // 何からの数値をインクリメント
    count++;
  }

  static void greet() { // 保持している数値関係ない挨拶
    System.out.println("hello.");
  }
}