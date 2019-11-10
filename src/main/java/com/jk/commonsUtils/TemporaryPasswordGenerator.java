package com.jk.commons;

import java.nio.charset.Charset;
import java.security.SecureRandom;

public class TemporaryPasswordGenerator {

	public static String getAlphaNumericString(int n) {
		// length is bounded by 256 Character
		// Create a StringBuffer to store the result
		byte[] array = new byte[256];
		new SecureRandom().nextBytes(array);

		String randomString = new String(array, Charset.forName("UTF-8"));
		StringBuffer r = new StringBuffer();

		// remove all spacial char
		String AlphaNumericString = randomString.replaceAll("[^A-Z0-9a-z]", "");

		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < AlphaNumericString.length(); k++) {

			if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0)
					|| Character.isDigit(AlphaNumericString.charAt(k)) && (n > 0)) {
				r.append(AlphaNumericString.charAt(k));
				n--;
			}
		}
		// return the resultant string
		return r.toString();
	}
}
