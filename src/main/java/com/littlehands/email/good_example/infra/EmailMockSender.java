package com.littlehands.email.good_example.infra;

import com.littlehands.email.good_example.domain.email.Email;
import com.littlehands.email.good_example.domain.email.EmailSender;
import org.springframework.context.annotation.Profile;

@Profile("local")
public class EmailMockSender implements EmailSender {
  @Override
  public void send(Email email) {
    System.out.println("email sent.");
    System.out.println(email);
  }
}
