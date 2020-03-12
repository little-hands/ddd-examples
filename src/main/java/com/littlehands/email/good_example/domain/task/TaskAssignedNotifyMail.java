package com.littlehands.email.good_example.domain.task;

import com.littlehands.email.good_example.domain.email.Email;
import com.littlehands.email.good_example.domain.user.User;

/**
 * タスクのアサインを通知するメールです
 */
public class TaskAssignedNotifyMail extends Email {
  private static final String FROM_ADDRESS = "sender@example.com";
  private static final String SUBJECT = "タスク作成通知";

  public TaskAssignedNotifyMail(Task task, User user) {
    super(user.getEmailAddress(),
        FROM_ADDRESS,
        SUBJECT,
        "タスク " + task.getName() + " の担当になりました。");
  }

}
