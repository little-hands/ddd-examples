package com.littlehands.task_management.domain.user;

import lombok.Getter;

@Getter
public class User {
  private UserId userId;
  private String name;
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
