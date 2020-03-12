package com.littlehands.task_management.bad_example.usecase.user;

import com.littlehands.task_management.bad_example.domain.user.User;
import com.littlehands.task_management.bad_example.domain.user.UserId;
import com.littlehands.task_management.bad_example.domain.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserCreateUseCase {
  @NonNull
  private UserRepository userRepository;

  public UserId createUser(String userName) {
    User user = new User(userName);
    userRepository.save(user);
    return user.getUserId();
  }

}
