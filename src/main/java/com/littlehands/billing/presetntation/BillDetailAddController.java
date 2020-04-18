package com.littlehands.billing.presetntation;

import com.littlehands.billing.domain.bill.BillId;
import com.littlehands.billing.usecase.auth.UserSessionProvider;
import com.littlehands.billing.usecase.bill.add_detail.AddBillDetailUseCase;
import com.littlehands.billing.usecase.bill.add_detail.BillDetailAddParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class BillDetailAddController {
  private UserSessionProvider userSessionProvider;
  private AddBillDetailUseCase addBillDetailUseCase;

  public BillDetailAddController(UserSessionProvider userSessionProvider, AddBillDetailUseCase addBillDetailUseCase) {
    this.userSessionProvider = userSessionProvider;
    this.addBillDetailUseCase = addBillDetailUseCase;
  }

  @PostMapping("/bills/${id}/details")
  public void addBillDetail(@PathVariable String id) {
    // TODO: titleとpriceはコントローラーへのリクエストボディから詰め替える
    BillDetailAddParam param = new BillDetailAddParam(new BillId(id), "detail title", 0);
    addBillDetailUseCase.addBillDetail(param, userSessionProvider.getUserSession());
  }

}
