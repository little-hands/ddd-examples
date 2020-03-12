package com.littlehands.aggregate.good_example.domain.student;

import com.littlehands.aggregate.good_example.domain.Dao;

public class StudentRepository implements Dao<Student, StudentId> {
  @Override
  public Student findById(StudentId studentId) {
    return null; //omitted
  }

  @Override
  public void save(Student student) {
    //omitted
  }
}
