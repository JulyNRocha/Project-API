package com.dev.projetoAPI.config.key;

public class AlphaNumericStringGenerator {

	public static String getRandomString(int keyLength) {

		String theAlphaNumeric;
		StringBuilder builder;

		theAlphaNumeric = "abcdefghijklmnopqrstuvwxyz" + "0123456789";

		builder = new StringBuilder(keyLength);

		for (int m = 0; m < keyLength; m++) {

			int myindex = (int) (theAlphaNumeric.length() * Math.random());

			builder.append(theAlphaNumeric.charAt(myindex));
		}

		return builder.toString();
	}

}
