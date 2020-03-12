package com.littlehands.aggregate.bad_example.domain;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }
}
