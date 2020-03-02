package com.littlehands.dddsample.infra.task;

import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskTempRepository implements TaskRepository {
  @Override
  public Task findById(TaskId taskId) {
    return null;
  }

  @Override
  public void save(Task task) {

  }
}
