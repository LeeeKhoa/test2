/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btlonmahoa.Nguyen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author anhch
 */
public class file {
    
    public void ghiKey(key key,String path) throws IOException{
            try {
            FileOutputStream fileOut = new FileOutputStream(new File(path));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(key);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (IOException iOException) {
        }
    }  
    public key docKey(String path) throws ClassNotFoundException, IOException{
        key key=new key();
         try {
             
            FileInputStream fileIn = new FileInputStream(new File(path));
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            key = (key) objectIn.readObject();
            System.out.println("The Object  was succesfully read to a file");
            objectIn.close();
            return key;
         }catch (IOException iOException) {
             System.out.println(iOException);
            return null; 

        }
         
    }
    public file() {
    }

    public Object docFile(String keyk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
