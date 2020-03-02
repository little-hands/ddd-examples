package com.littlehands.dddsample.usecase.task;

import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskPostponeUseCaseTest {
  private TaskPostponeUseCase taskPostponeUseCase;
  private TaskRepository taskRepository;

  TaskPostponeUseCaseTest() {
    this.taskRepository = new TaskMockRepository();
    this.taskPostponeUseCase = new TaskPostponeUseCase(this.taskRepository);
  }

  @Test
  void postponeTaskTest() {
    // given
    LocalDate dueDate = LocalDate.of(2020, 1, 1);
    TaskId taskId = this.prepareTask("sample", dueDate);

    // when
    // タスクを延期すると
    taskPostponeUseCase.postponeTask(taskId);

    // then
    Task postponedTask = taskRepository.findById(taskId);
    // 期日が1日後になっている
    assertThat(postponedTask.getDueDate(), is(dueDate.plusDays(1)));
    // 延期回数が1増えている
    assertThat(postponedTask.getPostponeCount(), is(1));
  }


  // private methods

  private TaskId prepareTask(String name, LocalDate dueDate) {
    return new TaskCreateUseCase(this.taskRepository)
        .createTask(name, dueDate);
  }
}