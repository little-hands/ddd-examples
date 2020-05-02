package com.littlehands.tdd_sample;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {
  private FizzBuzz fizzBuzz = new FizzBuzz();

  @Test
  void test_fizzBuzz(int input, String output) {
    fizzBuzz.execute();
  }

}