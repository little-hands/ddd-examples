package com.littlehands.aggregate_sample.good_example.domain.club;

import com.littlehands.aggregate_sample.good_example.domain.DomainException;
import com.littlehands.aggregate_sample.good_example.domain.student.StudentId;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Club {
  private ClubId clubId;
  private String name;
  private ClubStatus clubStatus;
  private List<StudentId> studentIds;

  private static final int MINIMUM_APPROVE_STUDENT_NUMBER = 5;

  public Club(String name) {
    this.clubId = new ClubId();
    this.name = name;
    this.clubStatus = ClubStatus.NOT_APPROVED;
    this.studentIds = new ArrayList<>();
  }

  /**
   * クラブに生徒を登録します
   */
  public void addStudent(StudentId studentId) {
    if (studentIds.contains(studentId)) {
      throw new DomainException("登録済みの生徒です");
    }
    studentIds.add(studentId);
  }

  /**
   * クラブの参加人数をチェックし、を承認状態にします。
   */
  public void approve() {
    if (studentIds.size() < MINIMUM_APPROVE_STUDENT_NUMBER) {
      throw new DomainException("生徒数が5人未満です");
    }
    this.clubStatus = ClubStatus.APPROVED;
  }


  /**
   * クラブから生徒を退会させます
   */
  public void removeStudent(StudentId studentId) {
    // 生徒をクラブから退会
    this.studentIds.remove(studentId);

    // メンバー数が最低承認人数を下回ったら、承認取り下げ
    if (this.studentIds.size() < MINIMUM_APPROVE_STUDENT_NUMBER) {
      this.clubStatus = ClubStatus.NOT_APPROVED;
    }

  }
}

