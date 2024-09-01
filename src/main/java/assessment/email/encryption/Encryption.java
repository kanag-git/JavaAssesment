package assessment.email.encryption;

/**
 * This interface has method called encrypt. A class which implements
 * this interface should provide encryption strategy
 * @author Kanagarajan
 */
public interface Encryption {
    String encrypt(String data);
}
