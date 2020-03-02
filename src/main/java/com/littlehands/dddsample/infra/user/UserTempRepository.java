package com.littlehands.dddsample.infra.user;

import com.littlehands.dddsample.domain.user.User;
import com.littlehands.dddsample.domain.user.UserId;
import com.littlehands.dddsample.domain.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserTempRepository implements UserRepository {
  @Override
  public User findById(UserId userId) {
    return null;
  }

  @Override
  public void save(User user) {

  }
}
