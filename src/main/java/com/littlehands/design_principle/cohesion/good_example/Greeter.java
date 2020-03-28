package com.littlehands.design_principle.cohesion.good_example;

class Greeter {
  private static final String GREET_MESSAGE = "hello.";

  static void printGreet() { // 保持している数値関係ない挨拶
    System.out.println(GREET_MESSAGE);
  }
}
