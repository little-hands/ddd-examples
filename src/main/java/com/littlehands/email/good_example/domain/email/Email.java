package com.littlehands.email.good_example.domain.email;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Email {
  private String toEmailAddress;
  private String fromEmailAddress;
  private String subject;
  private String body;

  protected Email(String toEmailAddress, String fromEmailAddress, String subject, String body) {
    this.toEmailAddress = toEmailAddress;
    this.fromEmailAddress = fromEmailAddress;
    this.subject = subject;
    this.body = body;
  }
}
