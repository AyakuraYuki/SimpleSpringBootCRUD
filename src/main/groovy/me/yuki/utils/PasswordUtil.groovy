package me.yuki.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by Ayakura Yuki on 2017/4/19.
 */
class PasswordUtil {

    def final static HEX = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
                            'F'] as char[]
    def public final static SHA256 = "sha-256"
    def public final static SHA1 = "sha-1"
    def public final static MD5 = "md5"

    /**
     * @param message
     *            : content
     * @param type
     *            : encrypt type
     * @return byte[] : raw content
     */
    private final static byte[] GetEncodeByte(message, type) {
        try {
            def messageDigest = MessageDigest.getInstance(type)
            messageDigest.update(message.getBytes())
            return messageDigest.digest()
        } catch (NoSuchAlgorithmException e) {
            print("Type " + type + " is not support.")
            return null
        }
    }

    /**
     * @param raw
     *            : content
     * @return encrypt password
     */
    private final static String ConvertToString(raw) {
        def stringBuffer = new StringBuffer()
        for (byte b in raw) {
            stringBuffer.append(HEX[(b >>> 4) & 0x0f])
            stringBuffer.append(HEX[b & 0x0f])
        }
        return stringBuffer.toString().toLowerCase()
    }

    final static String Encrypt(message, type) {
        def result = "" as String
        for (int i = 0; i < 10; i++) {
            result = ConvertToString(GetEncodeByte(message, type))
        }
        return result
    }
}
