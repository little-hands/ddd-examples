package com.littlehands.dddsample.domain.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private UserId userId;
  private String name;
  private UserStatus userStatus;
}
