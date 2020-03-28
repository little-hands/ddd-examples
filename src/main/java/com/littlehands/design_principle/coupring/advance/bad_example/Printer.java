package com.littlehands.design_principle.coupring.advance.bad_example;

import java.io.FileWriter;
import java.io.IOException;

class Printer {
  private static final String FILE_NAME = "test.txt";

  void printCounter(Counter counter) {
    if (CouplingMain.isLocal) {
      System.out.println(counter.getNumber());
    }
    printToFile(Integer.toString(counter.getNumber()));
  }

  private void printToFile(String str) {
    try {

      FileWriter fw = new FileWriter(FILE_NAME);
      fw.write(str);
      fw.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
