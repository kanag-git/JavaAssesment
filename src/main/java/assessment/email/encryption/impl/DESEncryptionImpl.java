package assessment.email.encryption.impl;

import assessment.email.encryption.Encryption;

/**
 * Implementation for DES encryption
 * @author Kanagarajan
 */
public final class DESEncryptionImpl implements Encryption {
    @Override
    public String encrypt(String data) {
       return  "DES - " + data;
    }

    @Override
    public String toString() {
        return "DESEncryptionImpl{}";
    }
}
