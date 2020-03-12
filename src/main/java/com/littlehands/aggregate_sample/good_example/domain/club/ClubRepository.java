package com.littlehands.aggregate_sample.good_example.domain.club;

import com.littlehands.aggregate_sample.good_example.domain.Dao;

public class ClubRepository implements Dao<Club, ClubId> {
  @Override
  public Club findById(ClubId clubId) {
    return null; // omitted
  }

  @Override
  public void save(Club club) {
    // omitted
  }
}
