package com.littlehands.dddsample.usecase.user;

import com.littlehands.dddsample.domain.user.*;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UserDeactivateUseCaseTest {

  private UserRepository userRepository;
  private UserDeactivateUseCase userDeactivateUseCase;
  private UserCreateUseCase userCreateUseCase;


  UserDeactivateUseCaseTest() {
    this.userRepository = new UserMockRepository();
    this.userDeactivateUseCase = new UserDeactivateUseCase(this.userRepository);
    this.userCreateUseCase = new UserCreateUseCase(this.userRepository);
  }

  @Test
  void deactivateUser_success() {
    // given: ユーザーが登録されている
    UserId createdUserId = userCreateUseCase.createUser("sample user");

    // when: ユーザーIDを指定して非活性化すると
    userDeactivateUseCase.deactivateUser(createdUserId);

    // then: ユーザーが非活性化された状態で永続化されている
    User deactivatedUser = userRepository.findById(createdUserId);
    assertThat(deactivatedUser.getUserStatus(), is(UserStatus.INACTIVE));
  }

}