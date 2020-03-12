package com.littlehands.task_management.bad_example.usecase.task;

import com.littlehands.task_management.bad_example.domain.task.Task;
import com.littlehands.task_management.bad_example.domain.task.TaskId;
import com.littlehands.task_management.bad_example.domain.task.TaskRepository;
import com.littlehands.task_management.bad_example.domain.task.TaskStatus;
import com.littlehands.task_management.bad_example.domain.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * リファクタ後のコードは{@link com.littlehands.task_management.good_example.usecase.task.TaskCreateUseCase}参照
 */
@Component
@RequiredArgsConstructor
public class TaskCreateUseCase {
  @NonNull
  private TaskRepository taskRepository;
  @NonNull
  private UserRepository userRepository;

  public TaskId createTask(String name, LocalDate dueDate) {
    Task task = new Task();
    task.setTaskId(new TaskId());
    task.setName(name);
    task.setDueDate(dueDate);
    task.setTaskStatus(TaskStatus.UNDONE);
    task.setPostponeCount(0);
    taskRepository.save(task);
    return task.getTaskId();
  }

}
