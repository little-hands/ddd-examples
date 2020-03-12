package com.littlehands.task_management.infra.user;

import com.littlehands.task_management.domain.user.User;
import com.littlehands.task_management.domain.user.UserId;
import com.littlehands.task_management.domain.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRdbRepository implements UserRepository {
  @Override
  public User findById(UserId userId) {
    return null;
  }

  @Override
  public void save(User user) {

  }
}
