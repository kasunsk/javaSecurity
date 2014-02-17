package com.kasun.security;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import com.kasun.data.Document;

public class EncryptionDES implements CryptoHelper {

	private Document document;
	Cipher ecipher;
	Cipher dcipher;
	private String secretKey = "ezeon8547";

	public EncryptionDES() {

	}

	// 8-byte Salt
	byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
			(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };
	// Iteration count
	int iterationCount = 19;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document, String key) {
		this.document = document;
	}

	public Document encryptDocument(Document document)
			throws Exception {

		Document encrypteddocument = new Document();

		String encryptedUsername = encrypt(document.getUsername());
		String encryptedPassword = encrypt(document.getPassword());

		encrypteddocument.setUsername(encryptedUsername);
		encrypteddocument.setPassword(encryptedPassword);

		return encrypteddocument;
	}

	public Document decryptDocument(Document document) throws Exception {		

		Document decrypteddocument = new Document();

		String decryptedusername = decrypt( document.getUsername());
		String decryptedpassword = decrypt(document.getPassword());

		decrypteddocument.setUsername(decryptedusername);
		decrypteddocument.setPassword(decryptedpassword);

		return document;
	}

	@Override
	public String encrypt(String plainText) throws Exception {
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt,
				iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
				iterationCount);

		ecipher = Cipher.getInstance(key.getAlgorithm());
		ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		String charSet = "UTF-8";
		byte[] in = plainText.getBytes(charSet);
		byte[] out = ecipher.doFinal(in);
		@SuppressWarnings("restriction")
		String encStr = new sun.misc.BASE64Encoder().encode(out);
		return encStr;
	}

	@Override
	public String decrypt(String encryptedText) throws Exception {
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt,
				iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
				iterationCount);

		dcipher = Cipher.getInstance(key.getAlgorithm());
		dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		@SuppressWarnings("restriction")
		byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
		byte[] utf8 = dcipher.doFinal(enc);
		String charSet = "UTF-8";
		String plainStr = new String(utf8, charSet);
		return plainStr;
	}
}

