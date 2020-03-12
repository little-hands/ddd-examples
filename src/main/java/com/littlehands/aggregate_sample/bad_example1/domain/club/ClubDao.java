package com.littlehands.aggregate_sample.bad_example1.domain.club;

import com.littlehands.aggregate_sample.bad_example1.domain.Dao;

public class ClubDao implements Dao<Club, ClubId> {
  @Override
  public Club findById(ClubId clubId) {
    return null; // omitted
  }

  @Override
  public void save(Club club) {
    // omitted
  }
}
