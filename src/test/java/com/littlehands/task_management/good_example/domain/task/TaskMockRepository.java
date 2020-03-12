package com.littlehands.task_management.good_example.domain.task;

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
