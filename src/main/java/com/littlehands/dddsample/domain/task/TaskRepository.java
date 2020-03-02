package com.littlehands.dddsample.domain.task;

public interface TaskRepository {
  Task findById(TaskId taskId);
  void save(Task task);
}
