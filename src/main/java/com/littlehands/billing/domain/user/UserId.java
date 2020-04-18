package com.littlehands.billing.domain.user;

import lombok.Getter;

@Getter
public class UserId {
  private String value;

  public UserId(String value) {
    this.value = value;
  }
}
