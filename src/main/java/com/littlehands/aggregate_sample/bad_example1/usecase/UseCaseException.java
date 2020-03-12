package com.littlehands.aggregate_sample.bad_example1.usecase;

public class UseCaseException extends RuntimeException {
  public UseCaseException(String message) {
    super(message);
  }
}
