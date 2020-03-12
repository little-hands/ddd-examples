package com.littlehands.task_management.domain.task;

public interface TaskRepository {
  Task findById(TaskId taskId);
  void save(Task task);
}
