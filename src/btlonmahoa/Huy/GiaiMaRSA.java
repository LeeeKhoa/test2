
package btlonmahoa.Huy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import org.apache.commons.io.FileUtils;
public class GiaiMaRSA {
    public byte[] giamaRSA(byte[] out, PrivateKey priKey ) {
       try {
//			// Đọc file chứa private key
//			FileInputStream fis = new FileInputStream("privateKey.rsa");
//			byte[] b = new byte[fis.available()];
//			fis.read(b);
//			fis.close();
//
//			// Tạo private key
//			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
//			KeyFactory factory = KeyFactory.getInstance("RSA");
//			PrivateKey priKey = factory.generatePrivate(spec);
//
//			// Giải mã dữ liệu
			Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			c.init(Cipher.DECRYPT_MODE, priKey);
                	byte decryptOut[] = c.doFinal(out);
//Base64.getDecoder().decode(
//					"lIduM8qoFis1sZ1Am/jvI9vfIKSOMse6/G1QvtUx+eXuTqUkTPLJletOlXiC3jH7HDfPTHOWZFycblQhNgoGYLInVx8HfoV7/Xo/QzcDydTGk7nyMbSHXg9iI8hpNI9vIGhttMXtU2Cvr/17q8b4WpAa+i/eE9pF6R1YmadwJ2s="));
			return decryptOut;
                        
		} catch (Exception ex) {
			ex.printStackTrace();
                }
       return null;
  }
}

