package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

import java.util.regex.Pattern;

public class TelegramMessageService implements MessageService {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {

    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {

    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (validateTelegramID(telegramMessage.getTargetTelegramId()) &&
                validateTelegramID(telegramMessage.getSourceTelegramId())) {
            System.out.println("Sending a Telegram Message from " + telegramMessage.getSourceTelegramId() + " to " +
                    telegramMessage.getTargetTelegramId() + " with content : " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Telegram ID is Not Correct!");
        }
    }

    public boolean validateTelegramID(String telegramID) {
        // Regular expression pattern for validating telegram id
        String telegramIDRegex = "^https://t.me/[a-zA-Z0-9_.+-]+$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(telegramIDRegex);

        // Check if the telegram ID string matches the regex pattern
        return pattern.matcher(telegramID).matches();
    }
}
