
package btlonmahoa.Nguyen;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.FileUtils;

public class DES  {
    
    
    public Key  taoKey() throws NoSuchAlgorithmException{
       KeyGenerator generator = KeyGenerator.getInstance("DES");
        generator.init(new SecureRandom());
        Key key = generator.generateKey();
        return key;
    }

    public DES() {
    }
    
    public final byte[] maHoa (byte []path, Key  key) throws GeneralSecurityException, IOException {
        
    
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] byteEncrypted = cipher.doFinal(path);
        return byteEncrypted;   
    }
     public final byte [] giaiMa (byte [] path, Key  key) throws GeneralSecurityException, IOException {
      
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] byteDecrypted = cipher.doFinal(path);
        return byteDecrypted;
     }
//    System.out.println("original  text: ");
//    System.out.println("encrypted text: " + encrypted);
//    System.out.println("decrypted text: " + decrypted);

//    public String maHoaFile(File file) throws GeneralSecurityException{
//        String ketqua=new String();
//         byte[] plant=null;
//        try {
//           plant = Files.readAllBytes(file.toPath());
//           FileUtils.writeByteArrayToFile(new File("mahoa.ci"),maHoa(plant) );
//        } catch (IOException ex) {
//            Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
//            return "Lỗi";
//        }
//        return ketqua; 
//    }
//    public boolean giaiMaFile(File file) throws GeneralSecurityException{
//        byte[] plant;
//        try {
//            plant = FileUtils.readFileToByteArray(file);
//            FileUtils.writeByteArrayToFile(new File("mahoa.mp3"),giaiMa(plant));
//        } catch (IOException ex) {
//            Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//        
//        return true; 
//    }
    
    
  
}
