package com.kasun.run;

import com.kasun.data.Document;
import com.kasun.security.EncryptionAES;
import com.kasun.security.EncryptionDES;

public class Run {
	
	public static void main(String [] args) throws Exception{
	
	EncryptionDES securityDES = new EncryptionDES();
	EncryptionAES securityAES = new EncryptionAES();
	
//	Document document = new Document("username","password");
//	Document encryptedDocument = new Document();
//	  
//    encryptedDocument = security.encryptDocument(document);
//    encryptedDocument.display();
//    
//    Document decryptedDocument = new Document();
//    decryptedDocument = security.decryptDocument(decryptedDocument);
//    encryptedDocument.display();
    
		String centence = "This is massage from DES";
		System.out.println("plaintext  : "+centence);	
		
		String cipher = securityDES.encrypt(centence);
		System.out.println("cipher : "+cipher);
		
		String plaintext = securityDES.decrypt(cipher);
		System.out.println("plaintext  : "+plaintext);
		
		System.out.println();
		
		String centence1 = "This is massage from AES";
		System.out.println("plaintext  : "+centence1);	
		
		String cipher1 = securityAES.encrypt(centence);
		System.out.println("cipher : "+cipher1);
		
		String plaintext1 = securityAES.decrypt(cipher);
		System.out.println("plaintext  : "+plaintext1);
	
	}
}
