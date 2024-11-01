package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

import java.util.regex.Pattern;

public class TelegramMessageService implements TelegramService {
    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (validateTelegramId(telegramMessage.getTelegramId())) {
            // Logic to send Telegram message
            System.out.println("Telegram message sent to: " + telegramMessage.getTelegramId());
        } else {
            System.out.println("Invalid Telegram ID.");
        }
    }

    private boolean validateTelegramId(String telegramId) {
        // Example validation for telegram ID, assuming it should be numeric
        return telegramId != null && telegramId.matches("^[0-9]+$");
    }
}
