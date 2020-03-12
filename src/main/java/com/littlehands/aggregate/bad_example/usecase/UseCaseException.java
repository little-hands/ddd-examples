package com.littlehands.aggregate.bad_example.usecase;

public class UseCaseException extends RuntimeException {
  public UseCaseException(String message) {
    super(message);
  }
}
