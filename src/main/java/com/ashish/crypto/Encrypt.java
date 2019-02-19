package com.ashish.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;

public class Encrypt {

  public Element encryption(String string) throws Exception {
    SecureRandom secureRandom = new SecureRandom();
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    Signature signature = Signature.getInstance("SHA256WithDSA");
    signature.initSign(keyPair.getPrivate(), secureRandom);
    byte[] data = string.getBytes("UTF-8");
    signature.update(data);
    byte[] digitalSignature = signature.sign();
    Element e = new Element();
    e.setData(data);
    e.setDigitalSignature(digitalSignature);
    e.setPublickey(keyPair.getPublic());
    return e;
  }
}
