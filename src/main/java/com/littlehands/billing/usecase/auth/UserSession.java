package com.littlehands.billing.usecase.auth;

import com.littlehands.billing.domain.user.UserId;

public interface UserSession {
  UserId getUserId();
}
