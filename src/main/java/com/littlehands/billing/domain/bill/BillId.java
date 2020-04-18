package com.littlehands.billing.domain.bill;

import java.util.UUID;

public class BillId {
  private String value;

  public BillId() {
    this.value = UUID.randomUUID().toString();
  }

  public BillId(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
