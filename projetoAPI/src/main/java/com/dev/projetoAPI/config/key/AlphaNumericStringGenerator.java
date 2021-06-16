package com.dev.projetoAPI.config.key;

public class AlphaNumericStringGenerator {
	
	public static String getRandomString(int keyLength) { 
		
        String theAlphaNumericS;
        StringBuilder builder;
        
        
        theAlphaNumericS = "abcdefghijklmnopqrstuvwxyz" + "0123456789"; 

        builder = new StringBuilder(keyLength); 

        for (int m = 0; m < keyLength; m++) { 
        	
            int myindex 
                = (int)(theAlphaNumericS.length() * Math.random()); 

            builder.append(theAlphaNumericS.charAt(myindex)); 
        } 

        return builder.toString(); 
    } 

}
