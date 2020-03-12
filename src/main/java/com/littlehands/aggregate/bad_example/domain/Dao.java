package com.littlehands.aggregate.bad_example.domain;

public interface Dao<ENTITY, ID> {
  ENTITY findById(ID id);

  void save(ENTITY entity);
}
