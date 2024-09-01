package assessment.email.factory;

import assessment.email.domain.LoginDetails;
import assessment.email.domain.ServiceType;
import assessment.email.encryption.Encryption;
import assessment.email.service.EmailService;
import assessment.email.service.impl.*;

/**
 *  This factory class is responsible to create EmailService instance based on user input.
 *  Based on user input, factory method knows how to create expected email service instance.
 *  @author Kanagarajan
 */
public final class EmailServiceFactory {

    public static final EmailService getInstance(ServiceType serviceType,
                                           LoginDetails loginDetails,
                                           Encryption[] encryptionStrategies,
                                           boolean retry) {

        EmailService service = new DefaultEmailServiceImpl();

        if (encryptionStrategies != null) {
            service = new EncryptionEmailServiceDecorator(service, encryptionStrategies);
        }

        if (ServiceType.EXTERNAL == serviceType) {
            service = new DisclaimerEmailServiceDecorator(new LoginEmailServiceDecorator(service, loginDetails));
        }

        if (retry) {
            service = new RetryEmailServiceDecorator(service, 3);
        }

        return service;

    }

}
