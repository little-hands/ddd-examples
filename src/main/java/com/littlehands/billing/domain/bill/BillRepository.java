package com.littlehands.billing.domain.bill;

import com.littlehands.billing.domain.user.UserId;

import java.util.Optional;

public interface BillRepository {
  Optional<Bill> findByBillIdAndUserId(BillId billId, UserId userId);

  void insert(Bill bill);

  void update(Bill bill);
}
