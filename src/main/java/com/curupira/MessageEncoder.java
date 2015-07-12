package com.curupira;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;



public class MessageEncoder {
	
	public static String encode(String toEncode, String passKey){
		
		DESKeySpec keySpec;
		try {
			keySpec = new DESKeySpec(passKey.getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(keySpec);
			Base64 base64encoder = new Base64();
			byte[] cleartext = toEncode.getBytes("UTF8");      

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			String encryptedPwd = new String(base64encoder.encode(cipher.doFinal(cleartext)));
			return encryptedPwd;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static String decode(String encoded, String password){
		DESKeySpec keySpec;
		String decoded="No message for this!";
		try {
			keySpec = new DESKeySpec(password.getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(keySpec);
			
			Base64 base64decoder = new Base64();
			
			byte[] encrypedPwdBytes = base64decoder.decode(encoded);

			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
			
			decoded = new String(plainTextPwdBytes);
		} catch(Exception e){
			e.printStackTrace();
		}
		return decoded;
	}
}
