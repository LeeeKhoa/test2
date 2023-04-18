/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btlonmahoa.Huy;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author NITRO 5
 */
public class MaHoaRSA {
    public byte[] mahoaRSA(byte[] in ,PublicKey pubKey  ) {
         try {
			// Đọc file chứa public key
//			FileInputStream fis = new FileInputStream("publicKey.rsa");
//			byte[] b = new byte[fis.available()];
//			fis.read(b);
//			fis.close();

			// Tạo public key
//			X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
//			KeyFactory factory = KeyFactory.getInstance("RSA");
//			PublicKey pubKey = factory.generatePublic(spec);

			// Mã hoá dữ liệu
			Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			c.init(Cipher.ENCRYPT_MODE, pubKey);
//                        byte[] test= new byte [f.available()];
//                        f.read();
			byte encryptOut[] = c.doFinal(in);
			return encryptOut;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
         return null;
	}
    
}
