package com.kasun.run;

import com.kasun.data.Document;
import com.kasun.security.Security;

public class Run {
	
	public static void main(String [] args) throws Exception{
	
	Security security = new Security();
	Document document = new Document("username","password");
	Document encryptedDocument = new Document();
	
    String key="ezeon8547";   
    
    encryptedDocument = security.encryptDocument(document,key);
    encryptedDocument.display();
    
	}
}
