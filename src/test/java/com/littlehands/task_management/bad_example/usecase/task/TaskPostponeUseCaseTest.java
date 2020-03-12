package com.littlehands.task_management.bad_example.usecase.task;

import com.littlehands.task_management.bad_example.domain.shared.DomainException;
import com.littlehands.task_management.bad_example.domain.task.Task;
import com.littlehands.task_management.bad_example.domain.task.TaskId;
import com.littlehands.task_management.bad_example.domain.task.TaskMockRepository;
import com.littlehands.task_management.bad_example.domain.task.TaskRepository;
import com.littlehands.task_management.bad_example.domain.user.UserMockRepository;
import com.littlehands.task_management.bad_example.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskPostponeUseCaseTest {
  private UserRepository userRepository;
  private TaskRepository taskRepository;
  private TaskPostponeUseCase taskPostponeUseCase;

  TaskPostponeUseCaseTest() {
    this.userRepository = new UserMockRepository();
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
    return new TaskCreateUseCase(this.taskRepository, this.userRepository)
        .createTask(name, dueDate);
  }
}