import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;
import edu.sharif.selab.services.*;

public class Main {
    private final EmailService emailService;
    private final SmsService smsService;
    private final TelegramService telegramService;

    public Main(EmailService emailService, SmsService smsService, TelegramService telegramService) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.telegramService = telegramService;
    }

    public void sendMessage(Message message) {
        if (message instanceof EmailMessage) {
            emailService.sendEmailMessage((EmailMessage) message);
        } else if (message instanceof SmsMessage) {
            smsService.sendSmsMessage((SmsMessage) message);
        } else if (message instanceof TelegramMessage) {
            telegramService.sendTelegramMessage((TelegramMessage) message);
        }
    }

    public static void main(String[] args) {
        EmailService emailService = new EmailMessageService();
        SmsService smsService = new SmsMessageService();
        TelegramService telegramService = new TelegramMessageService();

        Main mainApp = new Main(emailService, smsService, telegramService);

        EmailMessage email = new EmailMessage();
        email.setRecipient("example@example.com");
        mainApp.sendMessage(email);

        SmsMessage sms = new SmsMessage();
        sms.setPhoneNumber("1234567890");
        mainApp.sendMessage(sms);

        TelegramMessage telegram = new TelegramMessage();
        telegram.setTelegramId("123456789");
        mainApp.sendMessage(telegram);
    }
}
