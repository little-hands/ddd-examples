package com.littlehands.aggregate.bad_example.domain.club;

import com.littlehands.aggregate.bad_example.domain.AggregateRoot;
import com.littlehands.aggregate.bad_example.domain.DomainException;
import com.littlehands.aggregate.bad_example.domain.StudentAddedEvent;
import com.littlehands.aggregate.bad_example.domain.event.DomainEventSeed;
import com.littlehands.aggregate.bad_example.domain.student.StudentId;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * リファクタ前のクラブクラス
 * リファクタ後のコードは{@link com.littlehands.aggregate.good_example.domain.club.Club}参照
 */
@Getter
//@Setter
public class Club extends AggregateRoot {
  private ClubId clubId;
  private String name;
  private ClubStatus clubStatus;

  private List<StudentId> clubMemberStudentIds;

  public Club(String name) {
    super();
    this.clubId = new ClubId();
    this.name = name;
    this.clubStatus = ClubStatus.NOT_APPROVED;
    this.clubMemberStudentIds = new ArrayList<>();
  }

  void addStudent(DomainEventSeed seed,StudentId studentId) {
    if (clubMemberStudentIds.contains(studentId)) {
      throw new DomainException("登録済みの生徒です");
    }
    this.clubMemberStudentIds.add(studentId);
    super.addDomainEvent(new StudentAddedEvent(seed,studentId));
  }

  private static final int MINIMUM_APPROVE_STUDENT_NUMBER = 5;

  public void approve() {
    if (clubMemberStudentIds.size() < MINIMUM_APPROVE_STUDENT_NUMBER) {
      throw new DomainException("生徒数が5人未満です");
    }
    this.clubStatus = ClubStatus.APPROVED;
  }

  public void removeStudent(StudentId studentId) {
    this.clubMemberStudentIds.remove(studentId);
    if (clubMemberStudentIds.size() < MINIMUM_APPROVE_STUDENT_NUMBER) {
      this.clubStatus = ClubStatus.NOT_APPROVED;
    }
  }
}

