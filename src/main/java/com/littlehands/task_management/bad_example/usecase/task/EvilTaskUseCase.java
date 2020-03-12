package com.littlehands.task_management.bad_example.usecase.task;

import com.littlehands.task_management.bad_example.domain.task.Task;
import com.littlehands.task_management.bad_example.domain.task.TaskId;
import com.littlehands.task_management.bad_example.domain.task.TaskRepository;
import com.littlehands.task_management.bad_example.domain.task.TaskStatus;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EvilTaskUseCase {
  @NonNull
  private TaskRepository taskRepository;

  public TaskId evilCreateTask(String name) {
    Task task = new Task();
    task.setTaskId(new TaskId());
    task.setName(name);
    task.setDueDate(LocalDate.now());
    task.setTaskStatus(TaskStatus.DONE);  // × 完了状態で始まる
    task.setPostponeCount(-100); // × 延期回数が謎のマイナス
    taskRepository.save(task);
    return task.getTaskId();
  }

  public void evilPostponeTask(TaskId taskId) {
    Task task = taskRepository.findById(taskId);
    task.setDueDate(task.getDueDate().plusDays(100)); // × いきなり100日延期
//    task.setPostponeCount(task.getPostponeCount() + 1); // × 延期回数を更新しない
    taskRepository.save(task);
  }
}
