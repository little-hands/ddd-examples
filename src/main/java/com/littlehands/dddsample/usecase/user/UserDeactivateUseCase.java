package com.littlehands.dddsample.usecase.user;

import com.littlehands.dddsample.domain.user.User;
import com.littlehands.dddsample.domain.user.UserId;
import com.littlehands.dddsample.domain.user.UserRepository;
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
