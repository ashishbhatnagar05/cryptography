package AsymmetricCryptography;

import static org.junit.Assert.assertEquals;

import java.security.KeyPair;

import org.junit.Test;

public class AsymmetricCryptographyTest {
  private static final String XFORM = "RSA/ECB/PKCS1PADDING";
  private static final String INSTANCE_RSA = "RSA";
  private static final Integer KEY_SIZE = 512;

  @Test
  public void testCorrectDecryption() throws Exception {
    KeyPair keyPair = KeyPairGenerationService.getKeyPair(INSTANCE_RSA, KEY_SIZE);
    String data = "Ashish is cool";
    byte[] dataBytes = EncryptionService.encrypt(data, keyPair.getPublic(), XFORM);
    String decryptData = DecryptionService.decrypt(dataBytes, keyPair.getPrivate(), XFORM);
    assertEquals(decryptData, data);
  }
}
