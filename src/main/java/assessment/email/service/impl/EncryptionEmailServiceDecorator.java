package assessment.email.service.impl;

import assessment.email.domain.Email;
import assessment.email.encryption.Encryption;
import assessment.email.service.EmailService;

import java.util.Objects;

/**
 * This class apply encryption to email body before sending email based on caller input
 * @author Kanagarajan
 */
public final class EncryptionEmailServiceDecorator implements EmailService {

    private final EmailService emailService;

    private final Encryption encryptionStrategies [];

    public EncryptionEmailServiceDecorator(EmailService emailService, Encryption encryptionStrategies []){

        this.emailService = Objects.requireNonNull(emailService, "EmailService cannot be a null");
        this.encryptionStrategies = encryptionStrategies;
    }

    @Override
    public void send(Email email) {

        if(encryptionStrategies!=null){
            for(Encryption encryptionStrategy : encryptionStrategies){
                System.out.println("Applying encryption Strategies..." + encryptionStrategy);
                email.setBody(encryptionStrategy.encrypt(email.getBody()));
            }
        }

        emailService.send(email);

    }
}
