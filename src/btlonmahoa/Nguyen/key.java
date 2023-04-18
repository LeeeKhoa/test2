/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btlonmahoa.Nguyen;

import java.io.Serializable;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author anhch
 */
public class key implements Serializable {
   
    private Key desKey;
    private PublicKey rsaPublicKey;
    private PrivateKey rsaPrivateKey;
    private SecretKeySpec blowfishKey;
    private String tenfile;

    public String getTenfile() {
        String[] words=tenfile.split("\\.");
        return words[0];
    }
    public String getDuoifile() {
        String[] words=tenfile.split("\\.");
        return words[1];
    }

    public void setTenfile(String tenfile) {
        this.tenfile = tenfile;
    }

    public key() {
    }

    public key(Key desKey, PublicKey rsaPublicKey, PrivateKey rsaPrivateKey, SecretKeySpec blowfishKey) {
        this.desKey = desKey;
        this.rsaPublicKey = rsaPublicKey;
        this.rsaPrivateKey = rsaPrivateKey;
        this.blowfishKey = blowfishKey;
    }

    public SecretKey getDesKey() {
        return (SecretKey) desKey;
    }

    public void setDesKey(Key desKey) {
        this.desKey = desKey;
    }

    public PublicKey getRsaPublicKey() {
        return rsaPublicKey;
    }

    public void setRsaPublicKey(PublicKey rsaPublicKey) {
        this.rsaPublicKey = rsaPublicKey;
    }

    public PrivateKey getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(PrivateKey rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }

    public SecretKeySpec getBlowfishKey() {
        return blowfishKey;
    }

    public void setBlowfishKey(SecretKeySpec blowfishKey) {
        this.blowfishKey = blowfishKey;
    }
    
    
}

