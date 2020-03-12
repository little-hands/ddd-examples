package com.littlehands.aggregate_sample.bad_example1.domain.club;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Club {
  private ClubId clubId;
  private String name;
  private ClubStatus clubStatus;

  public Club(String name) {
    this.clubId = new ClubId();
    this.name = name;
    this.clubStatus = ClubStatus.NOT_APPROVED;
  }
}

