package com.littlehands.aggregate.bad_example.usecase;

import com.littlehands.aggregate.bad_example.domain.club.Club;
import com.littlehands.aggregate.bad_example.domain.club.ClubDao;
import com.littlehands.aggregate.bad_example.domain.club.ClubId;
import com.littlehands.aggregate.bad_example.domain.club.ClubStatus;
import com.littlehands.aggregate.bad_example.domain.club_student.ClubStudent;
import com.littlehands.aggregate.bad_example.domain.club_student.ClubStudentDao;
import com.littlehands.aggregate.bad_example.domain.student.StudentId;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClubUseCase {

  private final ClubDao clubDao;
  private final ClubStudentDao clubStudentDao;


  /**
   * クラブに生徒を登録します
   */
  public void addStudent(ClubId clubId, StudentId studentId) {
    boolean isRegistered = clubStudentDao.findById(clubId, studentId).isPresent();
    if (isRegistered) {
      return; // 登録済みの場合
    }
    // 未登録なら新しくクラブに生徒を登録する
    ClubStudent clubStudent = new ClubStudent(clubId, studentId);
    clubStudentDao.save(clubStudent);
  }


  private static final int MINIMUM_APPROVE_STUDENT_NUMBER = 5;

  /**
   * クラブの参加人数をチェックし、を承認状態にします。
   */
  public void approveClub(ClubId clubId) {
    // 参加人数をチェックします
    List<ClubStudent> clubStudents = clubStudentDao.findByClubId(clubId);
    if (clubStudents.size() < MINIMUM_APPROVE_STUDENT_NUMBER) {
      throw new UseCaseException("生徒数が5人未満です");
    }

    // 人数が十分だったら、承認します
    Club club = clubDao.findById(clubId);
    club.setClubStatus(ClubStatus.APPROVED);
    clubDao.save(club);
  }


  // --------------------------------------------------


  /**
   * クラブから生徒を退会させます
   */
  public void evilRemoveStudent(ClubId clubId, StudentId studentId) {
    clubStudentDao.remove(clubId, studentId);
  }

}
