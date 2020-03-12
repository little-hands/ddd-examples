package com.littlehands.aggregate_sample.bad_example.domain;

public interface Dao<ENTITY, ID> {
  ENTITY findById(ID id);

  void save(ENTITY entity);
}
