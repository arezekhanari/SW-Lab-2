package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

import java.util.regex.Pattern;

public class EmailMessageService implements EmailService {
    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        if (validateEmail(emailMessage.getRecipient())) {
            System.out.println("Email sent to: " + emailMessage.getRecipient());
        } else {
            System.out.println("Invalid email address.");
        }
    }

    private boolean validateEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
