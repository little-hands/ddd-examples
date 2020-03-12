package com.littlehands.aggregate_sample.bad_example1.domain.club_student;

import com.littlehands.aggregate_sample.bad_example1.domain.club.ClubId;
import com.littlehands.aggregate_sample.bad_example1.domain.student.StudentId;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ClubStudentDao {
  public Optional<ClubStudent> findById(ClubId clubId, StudentId studentId) {
    return Optional.empty(); // omitted
  }

  public List<ClubStudent> findByClubId(ClubId clubId) {
    return Collections.emptyList();
  }

  public void save(ClubStudent clubStudent) {
    // omitted
  }

  public void remove(ClubId clubId, StudentId studentId) {
    // omitted
  }
}
