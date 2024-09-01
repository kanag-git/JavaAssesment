package assessment.email.service.impl;

import assessment.email.domain.Email;
import assessment.email.service.EmailService;

/**
 * Default implementation of EmailService
 * @author Kanagarajan
 */
public class DefaultEmailServiceImpl implements EmailService {
    @Override
    public void send(Email email) {
        System.out.println("Sending email: " + email.getBody());
    }
}
