package com.littlehands.aggregate.bad_example.domain.club;

public interface ClubRepository {
  Club findById(ClubId clubId);

  void save(Club club);
}
