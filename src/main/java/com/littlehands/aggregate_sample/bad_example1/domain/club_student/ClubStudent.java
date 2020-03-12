package com.littlehands.aggregate_sample.bad_example1.domain.club_student;

import com.littlehands.aggregate_sample.bad_example1.domain.club.ClubId;
import com.littlehands.aggregate_sample.bad_example1.domain.student.StudentId;
import lombok.Getter;

/**
 * ClubとStudentの紐付けを表すクラス
 */
@Getter
public class ClubStudent {

  private final ClubId clubId;
  private final StudentId studentId;

  public ClubStudent(ClubId clubId, StudentId studentId) {
    this.clubId = clubId;
    this.studentId = studentId;
  }
}
