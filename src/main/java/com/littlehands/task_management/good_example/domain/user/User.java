package com.littlehands.task_management.good_example.domain.user;

import lombok.Getter;

@Getter
public class User {
  private final UserId userId;
  private final String name;
  private UserStatus userStatus;

  public User(String name) {
    this.userId = new UserId();
    this.name = name;
    this.userStatus = UserStatus.ACTIVE;
  }

  public void deactivate() {
    this.userStatus = UserStatus.INACTIVE;
  }
}
