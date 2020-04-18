package com.littlehands.billing.domain.bill;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bill {
  private BillId billId;
  private String title;
  private List<BillDetail> billDetails;

  public Bill(String title) {
    this.billId = new BillId();
    this.billDetails = new ArrayList<>();
    this.title = title;
  }

  public void addDetail(BillDetail billDetail) {
    this.billDetails.add(billDetail);
  }

  /**
   * リポジトリからよぶ再構成用のコンストラクタ
   * パッケージプライベートなのでパッケージ外から呼び出せない
   */
  Bill(BillId billId, String title, List<BillDetail> billDetails) {
    this.billId = billId;
    this.title = title;
    this.billDetails = billDetails;
  }
}
