package com.littlehands.design_principle.cohesion.bad_example;


public class CohesionMain {
  public static void main(String[] args) {
    OperationUtil operationUtil = new OperationUtil();
    operationUtil.increment();
    int count = operationUtil.getCount();
    System.out.println(count);
    OperationUtil.greet();
  }
}
