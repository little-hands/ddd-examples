package com.littlehands.email.good_example.infra;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.littlehands.email.good_example.domain.email.Email;
import com.littlehands.email.good_example.domain.email.EmailSender;
import org.springframework.context.annotation.Profile;

@Profile({"production", "staging"})
public class EmailAwsSesSender implements EmailSender {
  private static final String CONFIG_SET = "ConfigSet";

  @Override
  public void send(Email email) {
    AmazonSimpleEmailService client =
        AmazonSimpleEmailServiceClientBuilder.standard()
            // Replace US_WEST_2 with the AWS Region you're using for
            // Amazon SES.
            .withRegion(Regions.US_WEST_2).build();
    SendEmailRequest request = new SendEmailRequest()
        .withDestination(
            new Destination().withToAddresses(email.getToEmailAddress()))
        .withMessage(new Message()
            .withBody(new Body()
                .withText(new Content()
                    .withCharset("UTF-8").withData(email.getBody())))
            .withSubject(new Content()
                .withCharset("UTF-8").withData(email.getSubject())))
        .withSource(email.getFromEmailAddress())
        .withConfigurationSetName(CONFIG_SET);
    client.sendEmail(request);
    System.out.println("Email sent!");

  }
}
