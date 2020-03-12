package com.littlehands.email.good_example.domain.task;

import lombok.Getter;

@Getter
public class Task {
  private String name;

  public Task(String name) {
    this.name = name;
  }
}
