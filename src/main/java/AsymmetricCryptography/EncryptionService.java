package AsymmetricCryptography;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class EncryptionService {
	
	public static byte[] encrypt(String data, PublicKey publicKey, String XFORM) throws Exception {
		byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
		Cipher cipher = Cipher.getInstance(XFORM);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(dataBytes);
	}
}
