package btlonmahoa.Thanh;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import javax.crypto.*;
import javax.crypto.spec.*;



public class Blowfish2 {
	
	/* Constructor of Blowfish class
	 * Key param
	 * */

	public Blowfish2(String key) {
		skeySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
		// Preparing Blowfish mode
		try { 
                    ecipher = Cipher.getInstance("Blowfish/ECB/NoPadding");} 
			catch (Exception e) {e.printStackTrace();}			
	}

    public Cipher getEcipher() {
        return ecipher;
    }

    public void setEcipher(Cipher ecipher) {
        this.ecipher = ecipher;
    }

    public SecretKeySpec getSkeySpec() {
        return skeySpec;
    }

    public void setSkeySpec(SecretKeySpec skeySpec) {
        this.skeySpec = skeySpec;
    }
	
	/* Encrypt function	 */
	public byte[] Encrypt(byte[] BEncrypt) {
		
		// Mode cypher in Encrypt mode
		try { ecipher.init(Cipher.ENCRYPT_MODE, skeySpec); }
			catch (InvalidKeyException e) {e.printStackTrace();}
		
		String REncrypt = "";
		// Paddind the String
		//byte[] BEncrypt = tocrypt.getBytes();
		int Taille = BEncrypt.length;
		int Limit = 8 - (BEncrypt.length % 8);
		byte[] buff = new byte[Taille + Limit];

		for (int i = 0; i < Taille; i++)
			buff[i] = BEncrypt[i];

		for (int i = Taille; i < Taille + Limit; i++)
			buff[i] = 0x0;

		try { 
			// Encrypt the padding string
			byte[] encrypted = ecipher.doFinal(buff); 
			// B64 ENCRYPTION (mircryption needed)
                        return encrypted;

			//REncrypt = bytetoB64(encrypted);
		} catch (Exception e)
                {e.printStackTrace();}

		//REncrypt = Begin.concat(REncrypt);
		//System.out.println("Blowfish Encrypt : "+Begin.concat(REncrypt));
		return null;
	}
	
	/* Decrypt function */
	public byte[] Decrypt(byte[] Again) throws UnsupportedEncodingException {
		
		//System.out.println("Before Blowfish Decrypt : "+encrypt);
		
//		if(encrypt.startsWith("+OK ")) {encrypt = encrypt.substring(4,encrypt.length());}
//		if(encrypt.startsWith("mcps "))	{encrypt = encrypt.substring(5,encrypt.length());}
		
		// B64 DECRYPTION (mircryption needed)
//		byte[] Again = B64tobyte(encrypt); 
		
		byte[] decrypted = null;
		
		try {
			// Mode cypher in Decrypt mode
			ecipher.init(Cipher.DECRYPT_MODE, skeySpec);
			decrypted = ecipher.doFinal(Again);
		
			// Recup exact length
//			int leng = 0;
//			while(decrypted[leng] != 0x0) {leng++;}
//			byte[] Final = new byte[leng];
//			// Format & Limit the Result String
//			int i = 0;
//			while(decrypted[i] != 0x0) {
//				Final[i] = decrypted[i];
//				i++;
//			}			
			//Force again the encoding result string
			//return new String(Final,"8859_1");
                        return decrypted;
		} catch (Exception e) {
			//return e.getMessage();
			// Exception, not necessary padding, return directly
			// The decypted string
			System.out.println("Blowfish Decrypt : "+new String(decrypted,"8859_1"));
			//return new String(decrypted,"8859_1");
                        return null;
		}
	}

	public static byte[] B64tobyte(String ec) {

		String dc = "";
		
		int k = -1;
		while (k < (ec.length() - 1)) {

			int right = 0;
			int left = 0;
			int v = 0;
			int w = 0;
			int z = 0;

			for (int i = 0; i < 6; i++) {
				k++;
				v = B64.indexOf(ec.charAt(k));
				right |= v << (i * 6);
			}

			for (int i = 0; i < 6; i++) {
				k++;
				v = B64.indexOf(ec.charAt(k));
				left |= v << (i * 6);
			}

			for (int i = 0; i < 4; i++) {
				w = ((left & (0xFF << ((3 - i) * 8))));
				z = w >> ((3 - i) * 8);
				if(z < 0) {z = z + 256;}
				dc += (char)z;
			}
				
			for (int i = 0; i < 4; i++) { 
				w = ((right & (0xFF << ((3 - i) * 8)))); 
				z = w >> ((3 - i) * 8);
				if(z < 0) {z = z + 256;}
				dc += (char)z;
			}
		}	
		
		byte[] Result = new byte[1024];
		try {
			// Force the encoding result string
			Result = dc.getBytes("8859_1");
		} catch (UnsupportedEncodingException e) {e.printStackTrace();}		
		return Result;
	}

	public static String bytetoB64(byte[] ec) {

		String dc = "";

		int left = 0;
		int right = 0;
		int k = -1;
		int v;

		while (k < (ec.length - 1)) {
			k++;
			v=ec[k]; if (v<0) v+=256;
			left = v << 24;
			k++;
			v=ec[k]; if (v<0) v+=256;
			left += v << 16;
			k++;
			v=ec[k]; if (v<0) v+=256;
			left += v << 8;
			k++;
			v=ec[k]; if (v<0) v+=256;
			left += v;

			k++;
			v=ec[k]; if (v<0) v+=256;
			right = v << 24;
			k++;
			v=ec[k]; if (v<0) v+=256;
			right += v << 16;
			k++;
			v=ec[k]; if (v<0) v+=256;
			right += v << 8;
			k++;
			v=ec[k]; if (v<0) v+=256;
			right += v;

			for (int i = 0; i < 6; i++) {
				dc += B64.charAt(right & 0x3F);
				right = right >> 6;
			}

			for (int i = 0; i < 6; i++) {
				dc += B64.charAt(left & 0x3F);
				left = left >> 6;
			}
		}
		return dc;
	}
	private static String Begin = "+OK ";
	private static String B64 = "./0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ\\`[]_^";
	private Cipher ecipher;
	private SecretKeySpec skeySpec;
}
