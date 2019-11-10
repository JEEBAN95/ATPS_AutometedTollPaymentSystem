package com.jk.commonsUtils;

import java.nio.charset.Charset;
import java.security.SecureRandom;

public class TemporaryPasswordGenerator {

	public static String getAlphaNumericString(int n) {
		
		byte[] array = new byte[256];
		new SecureRandom().nextBytes(array);

		String randomString = new String(array, Charset.forName("UTF-8"));
		StringBuffer r = new StringBuffer();
		String AlphaNumericString = randomString.replaceAll("[^A-Z0-9a-z]", "");
		for (int k = 0; k < AlphaNumericString.length(); k++) {

			if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0)
					|| Character.isDigit(AlphaNumericString.charAt(k)) && (n > 0)) {
				r.append(AlphaNumericString.charAt(k));
				n--;
			}
		}
		return r.toString();
	}
}
