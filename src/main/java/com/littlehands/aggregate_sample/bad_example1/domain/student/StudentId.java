package com.littlehands.aggregate_sample.bad_example1.domain.student;

import java.util.UUID;

public class StudentId {
  private String value;
  public StudentId() {
    this.value = UUID.randomUUID().toString();
  }
  public String stringValue() {
    return value;
  }
}
