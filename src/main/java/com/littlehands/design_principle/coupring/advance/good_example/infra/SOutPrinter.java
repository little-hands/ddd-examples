package com.littlehands.design_principle.coupring.advance.good_example.infra;

import com.littlehands.design_principle.coupring.advance.good_example.Counter;
import com.littlehands.design_principle.coupring.advance.good_example.Printer;

public class SOutPrinter implements Printer {
  public void printCounter(Counter counter) {
    System.out.println(counter.getNumber());
  }
}
