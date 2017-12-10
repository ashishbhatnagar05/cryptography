package com.ashish.crypto;

public class Main {
	public static void main(String[] args) throws Exception {
		String string = "abcdefg";
		Encrypt encrypt = new Encrypt();
		Element e = encrypt.encryption(string);
		SignatureVerification signatureVerification = new SignatureVerification();
		System.out.println(signatureVerification.decryption(e));
	}

}
