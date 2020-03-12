package com.littlehands.task_management.good_example.usecase.task;

import com.littlehands.task_management.good_example.domain.shared.DomainException;
import com.littlehands.task_management.good_example.domain.task.Task;
import com.littlehands.task_management.good_example.domain.task.TaskId;
import com.littlehands.task_management.good_example.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskPostponeUseCase {
  private final TaskRepository taskRepository;

  public void postponeTask(TaskId taskId) throws DomainException {
    Task task = taskRepository.findById(taskId);
    task.postpone();
    taskRepository.save(task);
  }

}
