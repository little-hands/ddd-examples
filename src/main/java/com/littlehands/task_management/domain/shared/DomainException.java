package com.littlehands.task_management.domain.shared;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }
}
