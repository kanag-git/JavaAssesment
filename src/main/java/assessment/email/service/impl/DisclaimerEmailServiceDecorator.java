package assessment.email.service.impl;

import assessment.email.domain.Email;
import assessment.email.domain.ServiceType;
import assessment.email.service.EmailService;

import java.util.Objects;

/**
 * This class adding disclaimer to email body If service type is external
 * @author Kanagarajan
 */
public final class DisclaimerEmailServiceDecorator implements EmailService {

    final private String DISCLAIMER = "\nDisclaimer :- <Disclaimer place holder>";
    final private EmailService emailService;

    public DisclaimerEmailServiceDecorator(EmailService emailService){
        this.emailService = Objects.requireNonNull(emailService, "EmailService cannot be a null");
    }

    @Override
    public void send(Email email) {

        if(ServiceType.EXTERNAL==email.getServiceType()){
            email.setBody(email.getBody() + DISCLAIMER);
        }

        emailService.send(email);
    }


}
