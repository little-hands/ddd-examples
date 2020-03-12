package com.littlehands.task_management.good_example.infra.task;

import com.littlehands.task_management.good_example.domain.task.Task;
import com.littlehands.task_management.good_example.domain.task.TaskId;
import com.littlehands.task_management.good_example.domain.task.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskRdbRepository implements TaskRepository {
  @Override
  public Task findById(TaskId taskId) {
    return null; // omitted
  }

  @Override
  public void save(Task task) {
    // omitted
  }
}
