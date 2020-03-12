package com.littlehands.aggregate.good_example.domain;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }
}
