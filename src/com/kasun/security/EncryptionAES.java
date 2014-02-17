package com.kasun.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionAES implements CryptoHelper {

	private String encryptionKey = "0123456789abcdef";
	static String IV = "AAAAAAAAAAAAAAAA";

	// private static byte[] key = {
	// 0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65,
	// 0x74, 0x4b, 0x65, 0x79};

	@Override
	public String encrypt(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
		System.out.println(key);
		cipher.init(Cipher.ENCRYPT_MODE, key,
				new IvParameterSpec(IV.getBytes("UTF-8")));
		byte[] bytes = cipher.doFinal(plainText.getBytes("UTF-8"));
		System.out.println("bytes : "+bytes);
		//String encryptedPlainText = new String(bytes);
		
		
		String encryptedPlainText = new String(bytes, "UTF-8");
		
		System.out.println("encryptedPlainText : "+encryptedPlainText);
		
		return encryptedPlainText;

	}

	@Override
	public String decrypt(String encryptedText) throws Exception {
		byte[] ciphertext = encryptedText.getBytes();
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"),
				"AES");
		cipher.init(Cipher.DECRYPT_MODE, key,
				new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(cipher.doFinal(ciphertext), "UTF-8");
	}
}
