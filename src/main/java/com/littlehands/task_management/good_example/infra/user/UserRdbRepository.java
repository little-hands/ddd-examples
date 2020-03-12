package com.littlehands.task_management.good_example.infra.user;

import com.littlehands.task_management.good_example.domain.user.User;
import com.littlehands.task_management.good_example.domain.user.UserId;
import com.littlehands.task_management.good_example.domain.user.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRdbRepository implements UserRepository {
  @Override
  public User findById(UserId userId) {
    return null; // omitted
  }

  @Override
  public void save(User user) {
    // omitted
  }
}
