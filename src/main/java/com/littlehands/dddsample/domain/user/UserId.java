package com.littlehands.dddsample.domain.user;

import lombok.Value;

import java.util.UUID;

@Value
public class UserId {
  public UserId() {
    this.value = UUID.randomUUID().toString();
  }

  private String value;
}
