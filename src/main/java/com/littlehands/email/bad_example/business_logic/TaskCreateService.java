package com.littlehands.email.bad_example.business_logic;

import com.littlehands.email.bad_example.data.task.Task;
import com.littlehands.email.bad_example.data.task.TaskRepository;
import com.littlehands.email.bad_example.data.user.UserId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskCreateService {
  private final EmailSendService emailSendService;
  private final TaskRepository taskRepository;

  public void createTask(String taskName, UserId userId) {
    Task task = new Task(taskName);
    taskRepository.save(task);
    emailSendService.sendTaskAssignNotifyMail(userId, task.getName());
  }

}
