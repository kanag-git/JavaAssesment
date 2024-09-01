package assessment.email;

import assessment.email.domain.Email;
import assessment.email.domain.LoginDetails;
import assessment.email.domain.ServiceType;
import assessment.email.encryption.Encryption;
import assessment.email.encryption.impl.AESEncryptionImpl;
import assessment.email.encryption.impl.DESEncryptionImpl;
import assessment.email.factory.EmailServiceFactory;
import assessment.email.service.EmailService;

/**
 * Email client is a test class to send mail
 * @author Kanagarajan
 */
public class EmailClient
{

    public static void main(String[] args) {

        //-sending a plain text email to an outside resource,
        // with a disclaimer added at the end, unencrypted and no retry

        System.out.println("---------------case 1 - Plan text, Outside resource(with disclaimer), No encryption and No retry. Starts---------------");

        final LoginDetails loginDetails = new LoginDetails("User", "<pass>");

        EmailService emailService =
                EmailServiceFactory.getInstance(ServiceType.EXTERNAL, loginDetails,null,false);

        Email plainEmail = new Email("Plain email", ServiceType.EXTERNAL);

        emailService.send(plainEmail);

        System.out.println("------------------------------case 1 - ends!--------------------------------------\n");


        //sending an HTML email to an internal server (so without the disclaimer),
        // encrypted with DES, with the retry functionality

        System.out.println("---------------case 2 - HTML email, Internal resource, DES encrypted and with Retry. Starts---------------");

        emailService =
                EmailServiceFactory.getInstance(ServiceType.INTERNAL, null,new Encryption[] {new DESEncryptionImpl()},true);

        Email htmlEmail = new Email("<h1>html email</>", ServiceType.INTERNAL);

        emailService.send(htmlEmail);

        System.out.println("------------------------------case 2 - ends!--------------------------------------\n");


        //sending an HTML email to an outside resource,
        // with a disclaimer added at the end and encrypted with AES with retries in case of errors

        System.out.println("---------------case 3 - HTML email, Outside resource(with disclaimer), AES encrypted and with Retry. Starts---------------");

        emailService =
                EmailServiceFactory.getInstance(ServiceType.EXTERNAL, loginDetails,new Encryption[] {new AESEncryptionImpl()},true);

        htmlEmail = new Email("<h1>html email</>", ServiceType.EXTERNAL);

        emailService.send(htmlEmail);

        System.out.println("------------------------------case 3 - ends!--------------------------------------\n");

        //sending a plain text email to an outside resource and encrypted first with DES and then with AES
        System.out.println("---------------case 4 - Plan text, Outside resource(with disclaimer), DES and then AES encrypted, No retry. Starts---------------");

        emailService =
                EmailServiceFactory.getInstance(ServiceType.EXTERNAL, loginDetails,new Encryption[] {new DESEncryptionImpl(), new AESEncryptionImpl()},false);

        plainEmail = new Email("Plain email", ServiceType.EXTERNAL);

        emailService.send(plainEmail);

        System.out.println("------------------------------case 4 - ends!--------------------------------------");

    }

}
