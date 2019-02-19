package AsymmetricCryptography;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyPairGenerationService {
  public static KeyPair getKeyPair(String instance, int keySize) throws Exception {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(instance);
    keyPairGenerator.initialize(keySize);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    return keyPair;
  }
}
