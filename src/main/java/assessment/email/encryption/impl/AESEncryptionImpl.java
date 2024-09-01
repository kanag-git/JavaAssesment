package assessment.email.encryption.impl;

import assessment.email.encryption.Encryption;

/**
 * Implementation for AES encryption
 * @author Kanagarajan
 */
public final class AESEncryptionImpl implements Encryption {
    @Override
    public String encrypt(String data) {
        return "AES - " + data;
    }

    @Override
    public String toString() {
        return "AESEncryptionImpl{}";
    }
}

