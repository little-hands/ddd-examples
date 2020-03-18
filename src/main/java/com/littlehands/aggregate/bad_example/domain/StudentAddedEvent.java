package com.littlehands.aggregate.bad_example.domain;

import com.littlehands.aggregate.bad_example.domain.event.DomainEvent;
import com.littlehands.aggregate.bad_example.domain.event.DomainEventSeed;
import com.littlehands.aggregate.bad_example.domain.student.StudentId;

public class StudentAddedEvent extends DomainEvent {
  private StudentId studentId;

  public StudentAddedEvent(DomainEventSeed seed, StudentId studentId) {
    super(seed);
    this.studentId = studentId;
  }
}
