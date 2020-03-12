package com.littlehands.email.good_example.usecase;

import com.littlehands.email.good_example.domain.email.EmailSender;
import com.littlehands.email.good_example.domain.task.Task;
import com.littlehands.email.good_example.domain.task.TaskAssignedNotifyMail;
import com.littlehands.email.good_example.domain.task.TaskRepository;
import com.littlehands.email.good_example.domain.user.User;
import com.littlehands.email.good_example.domain.user.UserId;
import com.littlehands.email.good_example.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskCreateUseCase {
  private final TaskRepository taskRepository;
  private final UserRepository userRepository;
  private final EmailSender emailSender;

  public void createTask(String taskName, UserId userId) {
    User user = userRepository.findById(userId);

    Task task = new Task(taskName);
    taskRepository.save(task);

    TaskAssignedNotifyMail notifyMail = new TaskAssignedNotifyMail(task, user);
    emailSender.send(notifyMail);

  }

}
