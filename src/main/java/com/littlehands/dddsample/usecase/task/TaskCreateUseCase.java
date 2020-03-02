package com.littlehands.dddsample.usecase.task;

import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;
import com.littlehands.dddsample.domain.task.TaskStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskCreateUseCase {
  @NonNull
  private TaskRepository taskRepository;

  public TaskId createUser(String name) {
    Task task = new Task();
    task.setTaskId(new TaskId());
    task.setName(name);
    task.setTaskStatus(TaskStatus.UNDONE);
    task.setPostponeCount(0);
    taskRepository.save(task);
    return task.getTaskId();
  }
}
