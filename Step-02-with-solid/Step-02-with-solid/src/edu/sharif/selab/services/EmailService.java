package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;

public interface EmailService {
    void sendEmailMessage(EmailMessage emailMessage);
}