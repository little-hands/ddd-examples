package com.littlehands.dddsample.domain.user;

import com.littlehands.dddsample.domain.user.User;
import com.littlehands.dddsample.domain.user.UserId;

public interface UserRepository {
  User findById(UserId userId);
  void save(User user);
}
