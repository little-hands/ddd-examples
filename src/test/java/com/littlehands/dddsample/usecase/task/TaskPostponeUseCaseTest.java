package com.littlehands.dddsample.usecase.task;

import com.littlehands.dddsample.domain.shared.DomainException;
import com.littlehands.dddsample.domain.task.Task;
import com.littlehands.dddsample.domain.task.TaskId;
import com.littlehands.dddsample.domain.task.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
  void postponeTaskTest_success() throws DomainException {
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

  @Test
  void postponeTaskTest_success_postpone3times() throws DomainException {
    // given
    LocalDate dueDate = LocalDate.of(2020, 1, 1);
    TaskId taskId = this.prepareTask("sample", dueDate);

    // when: 3回延期すると
    taskPostponeUseCase.postponeTask(taskId);
    taskPostponeUseCase.postponeTask(taskId);
    taskPostponeUseCase.postponeTask(taskId);

    // then
    Task postponedTask = taskRepository.findById(taskId);
    // 期日、延期際数がそれぞれ3増えている　
    assertThat(postponedTask.getDueDate(), is(dueDate.plusDays(3)));
    assertThat(postponedTask.getPostponeCount(), is(3));
  }

  @Test
  void postponeTaskTest_fail_postpone4times() throws DomainException {
    // given
    LocalDate dueDate = LocalDate.of(2020, 1, 1);
    TaskId taskId = this.prepareTask("sample", dueDate);

    // 3回延期した状態で
    taskPostponeUseCase.postponeTask(taskId);
    taskPostponeUseCase.postponeTask(taskId);
    taskPostponeUseCase.postponeTask(taskId);

    // when: 4回目の延期をすると
    Executable target = () -> taskPostponeUseCase.postponeTask(taskId);

    // then: 例外が投げられる
    DomainException exception = assertThrows(DomainException.class, target);
    assertThat(exception.getMessage(), is("最大延期回数を超えています"));
  }


  // private methods

  private TaskId prepareTask(String name, LocalDate dueDate) {
    return new TaskCreateUseCase(this.taskRepository)
        .createTask(name, dueDate);
  }
}