package com.littlehands.dddsample.usecase.task;

import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;
import com.littlehands.dddsample.domain.task.TaskStatus;
import com.littlehands.dddsample.domain.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
