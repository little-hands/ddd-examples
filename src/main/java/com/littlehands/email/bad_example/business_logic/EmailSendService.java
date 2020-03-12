package com.littlehands.email.bad_example.business_logic;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.littlehands.email.bad_example.ApplicationProfile;
import com.littlehands.email.bad_example.data.user.User;
import com.littlehands.email.bad_example.data.user.UserId;
import com.littlehands.email.bad_example.data.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailSendService {
  private final UserRepository userRepository;
  private final ApplicationProfile applicationProfile;

  private static final String CONFIG_SET = "ConfigSet";

  private static final String FROM_ADDRESS = "sender@example.com";

  public void sendTaskAssignNotifyMail(UserId userId, String taskName) {
    User user = userRepository.findById(userId);
    String toEmailAddress = user.getEmailAddress();
    String subject = "タスク作成通知";
    String textBody = "タスク " + taskName + " の担当になりました。";

    sendMail(toEmailAddress, subject, textBody);
  }

  private void sendMail(String toEmailAddress, String subject, String textBody) {

    // ローカルの場合はメール送信をしない
    if (applicationProfile.isLocal()) {
      System.out.println("メール送信ログ");
      return;
    }

    // 検証、本番環境では実際にメールを送信する
    AmazonSimpleEmailService client =
        AmazonSimpleEmailServiceClientBuilder.standard()
            // Replace US_WEST_2 with the AWS Region you're using for
            // Amazon SES.
            .withRegion(Regions.US_WEST_2).build();
    SendEmailRequest request = new SendEmailRequest()
        .withDestination(
            new Destination().withToAddresses(toEmailAddress))
        .withMessage(new Message()
            .withBody(new Body()
                .withText(new Content()
                    .withCharset("UTF-8").withData(textBody)))
            .withSubject(new Content()
                .withCharset("UTF-8").withData(subject)))
        .withSource(FROM_ADDRESS)
        .withConfigurationSetName(CONFIG_SET);
    client.sendEmail(request);
    System.out.println("Email sent!");
  }


  public void sendATypeMail(User user) {
    String toEmailAddress = user.getEmailAddress();
    String subject = "タイプAのメール件名";
    String textBody = "タイプAのメール本文です";
    sendMail(toEmailAddress, subject, textBody);
  }

  public void sendBTypeMail(User user) {
    String toEmailAddress = user.getEmailAddress();
    String subject = "タイプBのメール件名";
    String textBody = "タイプBのメール本文です";
    sendMail(toEmailAddress, subject, textBody);
  }

  public void sendCTypeMail(User user) {
    String toEmailAddress = user.getEmailAddress();
    String subject = "タイプCのメールル件名";
    String textBody = "タイプCのメール本文です";
    sendMail(toEmailAddress, subject, textBody);
  }

  public void sendDTypeMail(User user) {
    String toEmailAddress = user.getEmailAddress();
    String subject = "タイプDのメールル件名";
    String textBody = "タイプDのメール本文です";
    sendMail(toEmailAddress, subject, textBody);
  }

  public void sendETypeMail(User user) {
    String toEmailAddress = user.getEmailAddress();
    String subject = "タイプEのメールル件名";
    String textBody = "タイプEのメール本文です";
    sendMail(toEmailAddress, subject, textBody);
  }

  public void sendFTypeMail(User user) {
    String toEmailAddress = user.getEmailAddress();
    String subject = "タイプFのメールル件名";
    String textBody = "タイプFのメール本文です";
    sendMail(toEmailAddress, subject, textBody);
  }
}
