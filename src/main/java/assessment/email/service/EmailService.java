package assessment.email.service;

import assessment.email.domain.Email;

/**
 * This interface has method called send
 * Respective implementation class should provide actual impl based on @See assessment.email.domain.Email
 * @author Kanagarajan
 */
public interface EmailService {

    void send(Email email);
}
