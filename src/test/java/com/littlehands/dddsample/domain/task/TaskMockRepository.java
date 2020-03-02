package com.littlehands.dddsample.domain.task;

import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;

import java.util.HashMap;
import java.util.Map;

public class TaskMockRepository implements TaskRepository {
  private Map<TaskId, Task> map = new HashMap<>();

  @Override
  public Task findById(TaskId taskId) {
    return map.get(taskId);
  }

  @Override
  public void save(Task task) {
    map.put(task.getTaskId(), task);

  }
}
