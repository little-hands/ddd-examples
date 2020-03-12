package com.littlehands.task_management.good_example.domain.task;

import com.littlehands.task_management.good_example.domain.shared.DomainException;
import lombok.Getter;

import java.time.LocalDate;

/**
 * リファクタ後のタスククラス
 * リファクタ前のコードは{@link com.littlehands.task_management.bad_example.domain.task.Task}参照
 */
@Getter
public class Task {
  private TaskId taskId;
  private String name;
  private TaskStatus taskStatus;
  private int postponeCount;
  private LocalDate dueDate;

  public Task(String name, LocalDate dueDate) {
    this.taskId = new TaskId();
    this.name = name;
    this.dueDate = dueDate;
    this.taskStatus = TaskStatus.UNDONE;
    this.postponeCount = 0;
  }

  public void postpone() {
    validatePostPoneCount();
    this.dueDate = this.dueDate.plusDays(1);
    this.postponeCount = this.postponeCount + 1;
  }

  private static final int MAX_POSTPONE_COUNT = 3;

  private void validatePostPoneCount() throws DomainException {
    if (this.postponeCount >= MAX_POSTPONE_COUNT) {
      throw new DomainException("最大延期回数を超えています");
    }
  }
}
