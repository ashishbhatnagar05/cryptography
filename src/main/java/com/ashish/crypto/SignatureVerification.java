package com.ashish.crypto;

import java.security.PublicKey;
import java.security.Signature;

public class SignatureVerification {

  public boolean decryption(Element e) throws Exception {
    PublicKey publicKey = e.getPublickey();
    byte[] data = e.getData();
    byte[] digitalSignature = e.getDigitalSignature();
    Signature signature2 = Signature.getInstance("SHA256WithDSA");
    signature2.initVerify(publicKey);
    signature2.update(data);
    boolean verified = signature2.verify(digitalSignature);
    return verified;
  }
}
