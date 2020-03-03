package com.littlehands.dddsample.domain.user;

public interface UserRepository {
  User findById(UserId userId);
  void save(User user);
}
