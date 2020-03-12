package com.littlehands.dddsample.usecase.email_sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailSendServiceTest {
  private EmailSendService emailSendService;

  @BeforeEach
  void setup() {
    this.emailSendService = new EmailSendService();
  }

  @Test
  void sendMailTest() {
    String to = "recipient@example.com";
    String subject = "Amazon SES test (AWS SDK for Java)";
    String textbody = "This email was sent through Amazon SES "
        + "using the AWS SDK for Java.";
    emailSendService.sendMail(to,  subject, textbody);
  }

}