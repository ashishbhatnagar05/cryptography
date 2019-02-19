package MessageDigest;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class MessageGeneratorTest {

  private static String algorithm = "SHA-256";

  @Test
  public void generate_sha256() throws Exception {
    String input = "ashish is great";
    String hex = MessageGenerator.getHash(input.getBytes("UTF-8"));
    System.out.println("Message Digest: " + hex);
    Assert.assertEquals("aa601981b4e42ded27d737b43deaef43c2d61465287a3274b7fbe091fb62dce7", hex);
  }

  @Test
  public void generate_sha256_fromFile() throws IOException, NoSuchAlgorithmException {
    String hex = MessageGenerator.getHash("C:\\torrent\\kali-linux-2019-1-amd64-iso\\kali-linux-2019.1-amd64.iso", algorithm);
    System.out.println("Message Digest of type " + "algorithm " + hex);
    Assert.assertEquals("3d907cf89a1c90d7a6b32f75310fb2201d988da33f1f6168a06848fed30d5417", hex);
  }
}
