package com.littlehands.task_management.good_example.usecase.task;

import com.littlehands.task_management.good_example.domain.task.Task;
import com.littlehands.task_management.good_example.domain.task.TaskId;
import com.littlehands.task_management.good_example.domain.task.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * リファクタ前のコードは{@link com.littlehands.task_management.bad_example.usecase.task.TaskCreateUseCase}参照
 */
@Component
@RequiredArgsConstructor
public class TaskCreateUseCase {
  @NonNull
  private TaskRepository taskRepository;

  public TaskId createTask(String name, LocalDate dueDate) {
    Task task = new Task(name, dueDate);
    taskRepository.save(task);
    return task.getTaskId();
  }
}
