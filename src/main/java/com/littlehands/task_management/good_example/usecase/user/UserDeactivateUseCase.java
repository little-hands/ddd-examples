package com.littlehands.task_management.good_example.usecase.user;

import com.littlehands.task_management.good_example.domain.user.User;
import com.littlehands.task_management.good_example.domain.user.UserId;
import com.littlehands.task_management.good_example.domain.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserDeactivateUseCase {
  @NonNull
  private UserRepository userRepository;

  public void deactivateUser(UserId userId) {
    User user = userRepository.findById(userId);
    user.deactivate();
    userRepository.save(user);
  }

}
