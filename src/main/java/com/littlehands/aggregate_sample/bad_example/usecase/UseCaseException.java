package com.littlehands.aggregate_sample.bad_example.usecase;

public class UseCaseException extends RuntimeException {
  public UseCaseException(String message) {
    super(message);
  }
}
