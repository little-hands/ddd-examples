package com.littlehands.aggregate.bad_example.domain.club;

import com.littlehands.aggregate.bad_example.domain.student.StudentDao;
import com.littlehands.aggregate.bad_example.domain.student.StudentId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClubDomainService {
  private final ClubRepository clubRepository;
  private final StudentDao studentDao;

  public void addStudent(ClubId clubId, StudentId studentId) {
    // 生徒とクラブの追加をする
    Club club = clubRepository.findById(clubId);
    club.addStudent(domainEventFactory.createSeed(), studentId);
  }
}
