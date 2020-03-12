package com.littlehands.aggregate.bad_example.domain.student;

import lombok.Getter;

@Getter
public class Student {
  private StudentId studentId;
  private String studentName;

  public Student(String studentName) {
    this.studentId = new StudentId();
    this.studentName = studentName;
  }
}
