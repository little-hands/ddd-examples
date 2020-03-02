package com.littlehands.dddsample.domain.task;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskId {
  public TaskId() {
    this.value = UUID.randomUUID().toString();
  }

  private String value;
}
