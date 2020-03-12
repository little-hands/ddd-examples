package com.littlehands.aggregate_sample.bad_example.domain.student;

import com.littlehands.aggregate_sample.bad_example.domain.Dao;

public class StudentDao implements Dao<Student, StudentId> {
  @Override
  public Student findById(StudentId studentId) {
    return null; //omitted
  }

  @Override
  public void save(Student student) {
    //omitted
  }
}
