package assessment.email.service.impl;

import assessment.email.domain.Email;
import assessment.email.domain.LoginDetails;
import assessment.email.domain.ServiceType;
import assessment.email.service.EmailService;

import java.util.Objects;

/**
 *  This class provides implementation to login  external server with given server details
 * if service type is external.
 * @author Kanagarajan
 */
public final class LoginEmailServiceDecorator implements EmailService {

    private final EmailService emailService;

    private final LoginDetails loginDetails;

    public LoginEmailServiceDecorator(EmailService emailService, LoginDetails loginDetails){
        this.emailService = Objects.requireNonNull(emailService, "EmailService cannot be a null");
        this.loginDetails = loginDetails;
    }

    @Override
    public void send(Email email) {

        if (ServiceType.EXTERNAL == email.getServiceType()) {

            if (loginDetails == null) {
                System.out.println("Login attempt failed.");
                throw new RuntimeException("Login attempt failed while connecting external mail server. Login Details " + loginDetails);
            }

            System.out.println("Login external mail server....");
        }

        emailService.send(email);
    }
}
