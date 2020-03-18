package com.littlehands.aggregate.bad_example.usecase;

import com.littlehands.aggregate.bad_example.domain.club.Club;
import com.littlehands.aggregate.bad_example.domain.club.ClubRepository;
import com.littlehands.aggregate.bad_example.domain.club.ClubId;
import com.littlehands.aggregate.bad_example.domain.event.DomainEventFactory;
import com.littlehands.aggregate.bad_example.domain.student.Student;
import com.littlehands.aggregate.bad_example.domain.student.StudentDao;
import com.littlehands.aggregate.bad_example.domain.student.StudentId;
import lombok.RequiredArgsConstructor;

/**
 * リファクタ前のユースケースクラス
 * リファクタ後のコードは{@link com.littlehands.aggregate.good_example.usecase.ClubUseCase}参照
 */
@RequiredArgsConstructor
public class ClubUseCase {
  private final ClubRepository clubRepository;
  private final StudentDao studentDao;

  private final DomainEventFactory domainEventFactory;

  /**
   * クラブに生徒を登録します
   */
  public void addStudent(ClubId clubId, StudentId studentId) {
    Club club = clubRepository.findById(clubId);
    club.addStudent(domainEventFactory.createSeed(),studentId);
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
  public void evilRemoveStudent(ClubId clubId, StudentId studentId) {
    Club club = clubRepository.findById(clubId);
    club.removeStudent(studentId);
    clubRepository.save(club);
  }

}
