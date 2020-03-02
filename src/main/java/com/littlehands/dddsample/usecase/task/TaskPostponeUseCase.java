package com.littlehands.dddsample.usecase.task;

import com.littlehands.dddsample.domain.shared.DomainException;
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
  private static final int MAX_POSTPONE_COUNT = 2;

  @NonNull
  private TaskRepository taskRepository;

  public void postponeTask(TaskId taskId) throws DomainException {
    Task task = taskRepository.findById(taskId);
    validatePostPoneCount(task);
    task.setDueDate(task.getDueDate().plusDays(1));
    task.setPostponeCount(task.getPostponeCount() + 1);
    taskRepository.save(task);
  }

  private void validatePostPoneCount(Task task) throws DomainException {
    if (task.getPostponeCount() >= MAX_POSTPONE_COUNT) {
      throw new DomainException("最大延期回数を超えています");
    }
  }
}
