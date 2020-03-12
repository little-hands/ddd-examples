package com.littlehands.aggregate.good_example.domain.student;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class StudentId {
  private String value;

  public StudentId() {
    this.value = UUID.randomUUID().toString();
  }

  public String stringValue() {
    return value;
  }
}
