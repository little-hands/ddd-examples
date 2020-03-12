package com.littlehands.aggregate_sample.good_example.usecase;

import com.littlehands.aggregate_sample.good_example.domain.club.Club;
import com.littlehands.aggregate_sample.good_example.domain.club.ClubId;
import com.littlehands.aggregate_sample.good_example.domain.club.ClubRepository;
import com.littlehands.aggregate_sample.good_example.domain.student.StudentId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClubUseCase {

  private final ClubRepository clubRepository;


  /**
   * クラブに生徒を登録します
   */
  public void addStudent(ClubId clubId, StudentId studentId) {
    Club club = clubRepository.findById(clubId);
    club.addStudent(studentId);
    clubRepository.save(club);
  }

  /**
   * クラブの参加人数をチェックし、を承認状態にします。
   */
  public void approveClub(ClubId clubId) {
    Club club = clubRepository.findById(clubId);
    club.approve();
    clubRepository.save(club);
  }


  /**
   * クラブから生徒を退会させます
   */
  public void reemoveStudent(ClubId clubId, StudentId studentId) {
    Club club = clubRepository.findById(clubId);
    club.removeStudent(studentId);
    clubRepository.save(club);
  }

}
