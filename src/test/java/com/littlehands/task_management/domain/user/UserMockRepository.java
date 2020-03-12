package com.littlehands.task_management.domain.user;

import java.util.HashMap;
import java.util.Map;

public class UserMockRepository implements UserRepository {
  private Map<UserId, User> map = new HashMap<>();

  @Override
  public User findById(UserId userId) {
    return map.get(userId);
  }

  @Override
  public void save(User user) {
    map.put(user.getUserId(), user);

  }
}
