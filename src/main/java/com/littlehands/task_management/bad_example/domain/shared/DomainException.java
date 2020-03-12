package com.littlehands.task_management.bad_example.domain.shared;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }
}
