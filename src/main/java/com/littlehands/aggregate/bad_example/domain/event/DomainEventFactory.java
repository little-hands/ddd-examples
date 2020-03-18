package com.littlehands.aggregate.bad_example.domain.event;

public class DomainEventFactory {
  public DomainEventSeed createSeed() {
    return new DomainEventSeed();
  }
}
