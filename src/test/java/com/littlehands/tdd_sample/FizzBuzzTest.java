package com.littlehands.tdd_sample;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
  @Test
  void sampleTest() {
    FizzBuzz fizzBuzz = new FizzBuzz();
    assertThat(fizzBuzz).isNotNull();
  }

}