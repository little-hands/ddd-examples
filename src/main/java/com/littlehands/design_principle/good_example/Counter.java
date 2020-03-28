package com.littlehands.design_principle.good_example;

class Counter {
  private int count = 0;

  void increment() { // 何からの数値をインクリメント
    count++;
  }

  int getCount() {
    return count;
  }
}
