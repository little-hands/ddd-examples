package com.littlehands.aggregate.bad_example.domain.club;

import lombok.Getter;
import lombok.Setter;

/**
 * リファクタ前のクラブクラス
 * リファクタ後のコードは{@link com.littlehands.aggregate.good_example.domain.club.Club}参照
 */
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

