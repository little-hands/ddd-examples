package com.littlehands.aggregate_sample.bad_example1.domain.club;

import java.util.UUID;

public class ClubId {
  private String value;
  public ClubId() {
    this.value = UUID.randomUUID().toString();
  }
  public String stringValue() {
    return value;
  }
}
