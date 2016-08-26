package com.nepxion.util.encryption;

/**
 * <p>Title: Nepxion Utility</p>
 * <p>Description: Nepxion Utility Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email 1394997@qq.com
 * @version 1.0
 */

import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptionUtil
	implements EncryptionConstants
{
	/**
	 * Encrypts the text with MD5.
	 * @param text the text string
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encryptMD5(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_MD5);
	}
	
	/**
	 * Encrypts the text by a charset with MD5.
	 * @param text the text string
	 * @param charset the charset string
	 * @return the encrypted text string
	 * @throws Exception
	 * @see #encrypt
	 */
	public static String encryptMD5(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_MD5, charset);
	}
	
	/**
	 * Encrypts the text with SHA.
	 * @param text the text string
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encryptSHA(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA);
	}
	
	/**
	 * Encrypts the text by a charset with SHA.
	 * @param text the text string
	 * @param charset the charset string
	 * @return the encrypted text string
	 * @throws Exception
	 * @see #encrypt
	 */
	public static String encryptSHA(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA, charset);
	}
	
	/**
	 * Encrypts the text with SHA_256.
	 * @param text the text string
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encryptSHA256(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_256);
	}
	
	/**
	 * Encrypts the text by a charset with SHA_256.
	 * @param text the text string
	 * @param charset the charset string
	 * @return the encrypted text string
	 * @throws Exception
	 * @see #encrypt
	 */
	public static String encryptSHA256(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_256, charset);
	}
	
	/**
	 * Encrypts the text with SHA_512.
	 * @param text the text string
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encryptSHA512(String text)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_512);
	}
	
	/**
	 * Encrypts the text by a charset with SHA_512.
	 * @param text the text string
	 * @param charset the charset string
	 * @return the encrypted text string
	 * @throws Exception
	 * @see #encrypt
	 */
	public static String encryptSHA512(String text, String charset)
		throws Exception
	{
		return encrypt(text, ALGORITHM_SHA_512, charset);
	}
	
	/**
	 * Encrypts the text by an algorithm and UTF-8 charset.
	 * @param text the text string
	 * @param algorithm the algorithm string
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encrypt(String text, String algorithm)
		throws Exception
	{
		return encrypt(text, algorithm, "UTF-8");
	}
	
	/**
	 * Encrypts the text by an algorithm and charset.
	 * @param text the text string
	 * @param algorithm the algorithm string
	 * @param charset the charset string
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encrypt(String text, String algorithm, String charset)
		throws Exception
	{
		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
		byte[] bytes = messageDigest.digest(text.getBytes(charset));
		
		return encryptBASE64(bytes);
	}
	
	/**
	 * Encrypts the byte array with BASE64.
	 * @param bytes the byte array
	 * @return the encrypted text string
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] bytes)
		throws Exception
	{
		BASE64Encoder base64Encoder = new BASE64Encoder();
		
		return base64Encoder.encodeBuffer(bytes);
	}
	
	/**
	 * Decrypts the text with BASE64.
	 * @param text the text string
	 * @return the decrypted byte array
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String text)
		throws Exception
	{
		BASE64Decoder base64Decoder = new BASE64Decoder();
		
		return base64Decoder.decodeBuffer(text);
	}
	
	public static void main(String[] args)
	{
		try
		{
			String password = EncryptionUtil.encryptMD5("admin");
			System.out.println(password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}