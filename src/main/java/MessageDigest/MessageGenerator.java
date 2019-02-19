package MessageDigest;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageGenerator {

  public static String getHash(byte[] input) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hashInBytes = md.digest(input);
    return bytesToHex(hashInBytes);
  }
  // windows utility to get hash: certUtil -hashfile
  // C:\torrent\kali-linux-2019-1-amd64-iso\kali-linux-2019.1-amd64.iso SHA256
  public static String getHash(String filepath, String alogorithm)
      throws IOException, NoSuchAlgorithmException {
    return bytesToHex(checksum(filepath, MessageDigest.getInstance(alogorithm)));
  }

  private static byte[] checksum(String filepath, MessageDigest md) throws IOException {
    try (DigestInputStream dis = new DigestInputStream(new FileInputStream(filepath), md)) {
      while (dis.read() != -1) ; // empty loop to clear the data
      md = dis.getMessageDigest();
    }
    return md.digest();
  }

  private static String bytesToHex(byte[] hashInBytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : hashInBytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }
}
