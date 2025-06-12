package com.bank.app.helper;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

	  private static final String KEY = "1234567890123456";
	    private static final String INIT_VECTOR = "abcdefghijklmnop";

	    public static String encrypt(String value) {
	        try {
	            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
	            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	            byte[] encrypted = cipher.doFinal(value.getBytes());
	            return Base64.getEncoder().encodeToString(encrypted);
	        } catch (Exception ex) {
	            throw new RuntimeException("Encryption error", ex);
	        }
	    }

	    public static String decrypt(String encrypted) {
	        try {
	            if (encrypted == null || encrypted.trim().isEmpty()) {
	                return null;
	            }

	            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
	            SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

	            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
	            return new String(original);
	        } catch (Exception ex) {
	            throw new RuntimeException("Decryption error", ex);
	        }
	    }

}
