package com.littlehands.billing.domain.bill;

import java.util.UUID;

public class BillDetailId {
  private String value;

  public BillDetailId() {
    this.value = UUID.randomUUID().toString();
  }

  public BillDetailId(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
