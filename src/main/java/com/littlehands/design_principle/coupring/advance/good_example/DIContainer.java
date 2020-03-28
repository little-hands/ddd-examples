package com.littlehands.design_principle.coupring.advance.good_example;

import com.littlehands.design_principle.coupring.advance.good_example.infra.FilePrinter;
import com.littlehands.design_principle.coupring.advance.good_example.infra.SOutPrinter;

class DIContainer {
  static Printer getPrinter(PrinterType printerType) {
    if (printerType == PrinterType.FILE) {
      return new FilePrinter();
    } else {
      return new SOutPrinter();
    }
  }

}