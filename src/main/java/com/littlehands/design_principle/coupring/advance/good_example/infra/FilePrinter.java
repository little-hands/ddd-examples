package com.littlehands.design_principle.coupring.advance.good_example.infra;

import com.littlehands.design_principle.coupring.advance.good_example.Counter;
import com.littlehands.design_principle.coupring.advance.good_example.Printer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinter implements Printer {
  private static final String FILE_NAME = "test.txt";

  @Override
  public void printCounter(Counter counter) {
    String printStr = Integer.toString(counter.getNumber());
    PrintWriter printWriter = createPrintWriter();
    printWriter.println(printStr);
    printWriter.close();
  }

  private PrintWriter createPrintWriter() {
    try {
      FileWriter fileWriter = new FileWriter(FILE_NAME, true);
      return new PrintWriter(fileWriter);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
