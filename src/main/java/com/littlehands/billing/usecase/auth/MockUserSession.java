package com.littlehands.billing.usecase.auth;

import com.littlehands.billing.domain.user.UserId;

public class MockUserSession implements UserSession {
  private UserId userId;

  public MockUserSession(UserId userId) {
    this.userId = userId;
  }

  @Override
  public UserId getUserId() {
    return userId;
  }
}
