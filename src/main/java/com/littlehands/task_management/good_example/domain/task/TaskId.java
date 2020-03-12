package com.littlehands.task_management.good_example.domain.task;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskId {
  public TaskId() {
    this.value = UUID.randomUUID().toString();
  }

  private String value;
}
