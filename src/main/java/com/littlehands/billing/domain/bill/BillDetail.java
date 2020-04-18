package com.littlehands.billing.domain.bill;

import lombok.Getter;

@Getter
public class BillDetail {
  private BillDetailId billDetailId;
  private String title;
  private int price;

  public BillDetail(String title, int price) {
    this.billDetailId = new BillDetailId();
    this.title = title;
    this.price = price;
  }

  BillDetail(BillDetailId billDetailId, String title, int price) {
    this.billDetailId = billDetailId;
    this.title = title;
    this.price = price;
  }
}
