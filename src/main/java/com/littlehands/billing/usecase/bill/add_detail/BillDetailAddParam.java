package com.littlehands.billing.usecase.bill.add_detail;

import com.littlehands.billing.domain.bill.BillId;
import lombok.Getter;

@Getter
public class BillDetailAddParam {
  private BillId billId;
  private String title;
  private int price;

  public BillDetailAddParam(BillId billId, String title, int price) {
    this.billId = billId;
    this.title = title;
    this.price = price;
  }
}
