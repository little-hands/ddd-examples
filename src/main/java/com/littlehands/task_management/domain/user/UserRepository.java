package com.littlehands.task_management.domain.user;

public interface UserRepository {
  User findById(UserId userId);
  void save(User user);
}
