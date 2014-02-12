package com.kasun.run;

import com.kasun.security.Security;

public class Run {
	
	public static void main(String [] args) throws Exception{
	
	Security security = new Security();
	
    String key="ezeon8547";   
    String plain="I am A SrI LAnKaN";
    
    String enc = security.encrypt(key, plain);;
    System.out.println("Original text: "+plain);
    System.out.println("Encrypted text: "+enc);
    String plainAfter=security.decrypt(key, enc);
    System.out.println("Original text after decryption: "+plainAfter);
    
	}
}
