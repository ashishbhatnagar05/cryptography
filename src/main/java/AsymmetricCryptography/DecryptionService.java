package AsymmetricCryptography;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

import javax.crypto.Cipher;

public class DecryptionService {

	public static String decrypt(byte[] dataBytes, PrivateKey privatekey, String XFORM) throws Exception {
		Cipher cipher = Cipher.getInstance(XFORM);
		cipher.init(Cipher.DECRYPT_MODE, privatekey);
		byte[] decryptDataBytes = cipher.doFinal(dataBytes);
		return new String(decryptDataBytes, StandardCharsets.UTF_8);
	}
}
