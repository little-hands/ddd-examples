package com.littlehands.aggregate_sample.bad_example1.domain.student;

import com.littlehands.aggregate_sample.bad_example1.domain.Dao;

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
