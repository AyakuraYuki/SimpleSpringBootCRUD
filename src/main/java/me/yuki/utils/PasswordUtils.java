package me.yuki.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
public class PasswordUtils {

	private final static char[] HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	public final static String SHA256 = "sha-256";
	public final static String SHA1 = "sha-1";
	public final static String MD5 = "md5";

	/**
	 * @param message
	 *            : content
	 * @param type
	 *            : encrypt type
	 * @return byte[] : raw content
	 */
	private final static byte[] GetEncodeByte(String message, String type) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(type);
			messageDigest.update(message.getBytes());
			return messageDigest.digest();
		}
		catch (NoSuchAlgorithmException e) {
			System.err.println("Type " + type + " is not support.");
			return null;
		}
	}

	/**
	 * @param raw
	 *            : content
	 * @return encrypt password
	 */
	private final static String ConvertToString(byte[] raw) {
		StringBuffer stringBuffer = new StringBuffer();
		for (byte b : raw) {
			stringBuffer.append(HEX[(b >>> 4) & 0x0f]);
			stringBuffer.append(HEX[b & 0x0f]);
		}
		return stringBuffer.toString().toLowerCase();
	}

	public final static String Encrypt(String message, String type) {
		String result = "";
		for (int i = 0; i < 10; i++) {
			result = ConvertToString(GetEncodeByte(message, type));
		}
		return result;
	}

}
