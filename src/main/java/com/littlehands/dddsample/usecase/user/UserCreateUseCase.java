package com.littlehands.dddsample.usecase.user;

import com.littlehands.dddsample.domain.user.User;
import com.littlehands.dddsample.domain.user.UserId;
import com.littlehands.dddsample.domain.user.UserRepository;
import com.littlehands.dddsample.domain.user.UserStatus;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserCreateUseCase {
  @NonNull
  private UserRepository userRepository;

  public UserId createUser(String userName) {
    User user = new User();
    user.setUserId(new UserId());
    user.setName(userName);
    user.setUserStatus(UserStatus.ACTIVE);
    userRepository.save(user);
    return user.getUserId();
  }

}
