package assessment.email.service.impl;

import assessment.email.domain.Email;
import assessment.email.service.EmailService;

import java.util.Objects;

/**
 * It provides implementation for retry mechanism if retry is enabled.
 * @author Kanagarajan
 */
public final class RetryEmailServiceDecorator implements EmailService {

    final private EmailService emailService;
    final int maxRetry;

    public RetryEmailServiceDecorator(EmailService emailService, int maxRetry){
        this.emailService = Objects.requireNonNull(emailService, "EmailService cannot be a null");
        this.maxRetry = maxRetry;
    }

    @Override
    public void send(Email email) {
        int retry = 0;
        while (retry < maxRetry) {
            try {

                // the below code should be uncommented for retry test.
                /*if(true){
                    throw new RuntimeException();
                }*/

                emailService.send(email);
                return;
            } catch (Exception e) {
                System.out.println("Exception while sending mail. Email details " + email);
                retry++;
                System.out.println("Retrying..." + retry);
            }
        }

        System.out.println("Retry attempt unsuccessful.");

    }
}
