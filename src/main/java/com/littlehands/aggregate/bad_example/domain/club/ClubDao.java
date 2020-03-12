package com.littlehands.aggregate.bad_example.domain.club;

import com.littlehands.aggregate.bad_example.domain.Dao;

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
