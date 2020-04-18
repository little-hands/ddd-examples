package com.littlehands.task_management.good_example.usecase.task;

import com.littlehands.task_management.good_example.domain.task.TaskRepository;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class EvilTaskUseCase {
  @NonNull
  private TaskRepository taskRepository;

  // これらの整合性を壊すメソッドが一通りコンパイルエラーになるようになった

//  public TaskId evilCreateTask(String name) {
//    Task task = new Task();
//    task.setTaskId(new TaskId());
//    task.setName(name);
//    task.setDueDate(LocalDate.now());
//    task.setTaskStatus(TaskStatus.DONE);  // × 完了状態で始まる
//    task.setPostponeCount(-100); // × 延期回数が謎のマイナス
//    taskRepository.save(task);
//    return task.getTaskId();
//  }
//
//  public void evilPostponeTask(TaskId taskId) {
//    Task task = taskRepository.findByBillIdAndUserId(taskId);
//    task.setDueDate(task.getDueDate().plusDays(100)); // × いきなり100日延期
//    task.setPostponeCount(task.getPostponeCount() + 1); // × 延期回数を更新しない
//    taskRepository.save(task);
//  }
}
