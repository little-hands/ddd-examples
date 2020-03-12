package com.littlehands.task_management.bad_example.usecase.task;

import com.littlehands.task_management.bad_example.domain.shared.DomainException;
import com.littlehands.task_management.bad_example.domain.task.Task;
import com.littlehands.task_management.bad_example.domain.task.TaskId;
import com.littlehands.task_management.bad_example.domain.task.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * リファクタ後のコードは{@link com.littlehands.task_management.good_example.usecase.task.TaskPostponeUseCase}参照
 */
@Component
@RequiredArgsConstructor
public class TaskPostponeUseCase {
  private static final int MAX_POSTPONE_COUNT = 3;

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
