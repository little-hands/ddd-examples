package com.littlehands.task_management.good_example.domain.user;

public interface UserRepository {
  User findById(UserId userId);

  void save(User user);
}
