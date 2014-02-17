package com.kasun.security;

public interface CryptoHelper {
	
	public String encrypt(String plainText) throws Exception;
	public String decrypt(String encryptedText) throws Exception;

}
