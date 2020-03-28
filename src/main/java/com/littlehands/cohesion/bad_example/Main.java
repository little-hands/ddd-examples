package com.littlehands.cohesion.bad_example;


public class Main {
  public static void main(String[] args) {
    OperationUtil operationUtil = new OperationUtil();
    operationUtil.increment();
    int count = operationUtil.getCount();
    System.out.println(count);
    OperationUtil.greet();
  }
}
