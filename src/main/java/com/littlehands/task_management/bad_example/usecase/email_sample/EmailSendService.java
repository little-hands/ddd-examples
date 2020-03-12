package com.littlehands.task_management.bad_example.usecase.email_sample;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

public class EmailSendService {
  private static final String CONFIG_SET = "ConfigSet";

  private static final String FROM_ADDRESS = "sender@example.com";

  public void sendMail(String toAddress, String subject, String textBody) {
    AmazonSimpleEmailService client =
        AmazonSimpleEmailServiceClientBuilder.standard()
            // Replace US_WEST_2 with the AWS Region you're using for
            // Amazon SES.
            .withRegion(Regions.US_WEST_2).build();
    SendEmailRequest request = new SendEmailRequest()
        .withDestination(
            new Destination().withToAddresses(toAddress))
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
}
