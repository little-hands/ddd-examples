package com.littlehands.email.bad_example.data.task;

import lombok.Getter;

@Getter
public class Task {
  private String name;

  public Task(String name) {
    this.name = name;
  }
}
