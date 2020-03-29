package com.littlehands.design_principle.coupring.advance.bad_example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Printer {
  private static final String FILE_NAME = "test.txt";

  void printCounter(Counter counter) {
    if (CouplingMain.isLocal) {
      System.out.println(counter.getNumber());
    }
    printToFile(Integer.toString(counter.getNumber()));
  }

  private void printToFile(String str) {
    PrintWriter printWriter = createPrintWriter();
    printWriter.println(str);
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
