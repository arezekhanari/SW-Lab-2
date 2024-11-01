package edu.sharif.selab.services;

import edu.sharif.selab.models.SmsMessage;

public class SmsMessageService implements SmsService {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        if (validatePhoneNumber(smsMessage.getPhoneNumber())) {
            System.out.println("SMS sent to: " + smsMessage.getPhoneNumber());
        } else {
            System.out.println("Invalid phone number.");
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}");
    }
}
