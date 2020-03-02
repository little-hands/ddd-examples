package com.littlehands.dddsample.usecase.task;

import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;
import com.littlehands.dddsample.domain.task.TaskStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TaskPostponeUseCase {
  @NonNull
  private TaskRepository taskRepository;

  public void postponeTask(TaskId taskId) {
    Task task = taskRepository.findById(taskId);
    task.setDueDate(task.getDueDate().plusDays(1));
    task.setPostponeCount(task.getPostponeCount() + 1);
    taskRepository.save(task);
  }
}
