package com.littlehands.aggregate.bad_example.domain;

import com.littlehands.aggregate.bad_example.domain.event.DomainEvent;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AggregateRoot {
  private List<DomainEvent> domainEvents;

  public AggregateRoot() {
    this.domainEvents = new ArrayList<>();
  }

  protected void addDomainEvent(DomainEvent domainEvent) {
    domainEvents.add(domainEvent);
  }

}
