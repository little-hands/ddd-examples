package com.littlehands.billing.usecase.auth;

import com.littlehands.billing.domain.user.UserId;
import org.springframework.stereotype.Component;

@Component
public class MockUserSessionProvider implements UserSessionProvider {
  @Override
  public UserSession getUserSession() {
    return new MockUserSession(new UserId("00001"));
  }
}
