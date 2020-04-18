package com.littlehands.billing.usecase.bill.add_detail;

import com.littlehands.billing.domain.bill.Bill;
import com.littlehands.billing.domain.bill.BillDetail;
import com.littlehands.billing.domain.bill.BillRepository;
import com.littlehands.billing.usecase.auth.UserSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddBillDetailUseCase {
  private BillRepository billRepository;

  public AddBillDetailUseCase(BillRepository billRepository) {
    this.billRepository = billRepository;
  }

  @Transactional
  public void addBillDetail(BillDetailAddParam param, UserSession userSession) {
    Bill bill = billRepository.findByBillIdAndUserId(param.getBillId(), userSession.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("存在しないBIllIdです"));

    BillDetail billDetail = new BillDetail(param.getTitle(), param.getPrice());
    bill.addDetail(billDetail);

    billRepository.update(bill);
  }
}
