package com.littlehands.task_management.bad_example.domain.task;

public interface TaskRepository {
  Task findById(TaskId taskId);
  void save(Task task);
}
