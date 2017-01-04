package com.quya.core.utils;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class CryptoUtils {
	private static final String ALGO = "AES";
	private static final byte[] keyValue = { 116, 104, 101, 66, 101, 83, 116, 83, 101, 67, 114, 101, 116, 75, 69, 121 };

	public static String digest(String plain) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			return new String(Base64.encodeBase64(md.digest(plain.getBytes())));
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	public static String encrypt(String plain) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance("AES");
		c.init(1, key);
		return new String(Base64.encodeBase64(c.doFinal(plain.getBytes())));
	}

	public static String decrypt(String encrypted) throws Exception {
		Key key = generateKey();
		Cipher c = Cipher.getInstance("AES");
		c.init(2, key);
		byte[] decordedValue = Base64.decodeBase64(encrypted.getBytes());
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	public static String encrypt(String key, String content) throws Exception {
		SecretKeySpec keyspec = new SecretKeySpec(Base64.decodeBase64(key.getBytes("UTF8")), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(1, keyspec);
		byte[] bytes = cipher.doFinal(content.getBytes("UTF8"));
		return new String(new Base64().encode(bytes), "UTF8");
	}

	public static String decrypt(String key, String content) throws Exception {
		SecretKeySpec keyspec = new SecretKeySpec(Base64.decodeBase64(key.getBytes("UTF8")), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(2, keyspec);
		byte[] bytes = Base64.decodeBase64(content.getBytes());
		return new String(cipher.doFinal(bytes), "UTF8");
	}

	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, "AES");
		return key;
	}
}