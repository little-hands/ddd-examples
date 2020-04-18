package com.littlehands.billing.domain.bill;

import com.sun.tools.javac.util.List;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class BillRdbRepository implements BillRepository {
  @Override
  public Optional<Bill> findByBillIdAndUserId(BillId billId) {
    // TODO: ここでBILLテーブルとBILL_DETAILデーブルをSQLで取得して、再構成用のコンストラクタでBIllオブジェクトのインスタンスを生成する
    Bill bill = new Bill(
        new BillId("id_from_SQL"),
        "title_form_SQL",
        List.of(new BillDetail(new BillDetailId("id_from_SQL"), "detail_title_from_SQL", 0)));
    return Optional.of(bill);
  }

  @Override
  public void insert(Bill bill) {
    // TODO: BILLテーブル、BILL_DETAILテーブルへのインサート文を書く
  }

  @Override
  public void update(Bill bill) {
    // TODO: BILLテーブル、BILL_DETAILテーブルへのインサート文を書く
    // BILL_DETAILテーブルの差分更新が難しければ、bill_idで一回deleteしてinsertでもOK.
    // 集約のオブジェクトは必ずひとまとまりで更新するので、そのような対応で問題ない。
    // ただ、今回はbill_detail_idを持っているので、
    // その値で存在確認してinsertとupdateをかき分けてもOK。
  }
}
