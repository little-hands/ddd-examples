package com.littlehands.task_management.bad_example.usecase.user;

import com.littlehands.task_management.bad_example.domain.user.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UserCreateUseCaseTest {
  private UserCreateUseCase userCreateUseCase;
  private UserRepository userRepository;

  UserCreateUseCaseTest() {
    this.userRepository = new UserMockRepository();
    this.userCreateUseCase = new UserCreateUseCase(this.userRepository);
  }

  @Test
  void createUserTest() {
    // when
    // タスクを作成すると
    String userName = "user name";
    UserId createdUserId = userCreateUseCase.createUser(userName);

    // then
    User createdUser = userRepository.findById(createdUserId);

    // 名前が入力した値になっている
    assertThat(createdUser.getName(), is(userName));
    // 活性状態になっている
    assertThat(createdUser.getUserStatus(), is(UserStatus.ACTIVE));
  }

}