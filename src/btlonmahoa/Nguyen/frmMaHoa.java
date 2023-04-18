/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btlonmahoa.Nguyen;

import btlonmahoa.Huy.GiaiMaRSA;
import btlonmahoa.Huy.MaHoaRSA;
import btlonmahoa.Huy.RSA;
import btlonmahoa.Thanh.Blowfish2;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author anhch
 */
public class frmMaHoa extends javax.swing.JFrame {

    String path;
    key k=new key();
    String ten= null;
    String key=null;
    byte[] kq=null;
    String pathk=null;
    DES des=new DES(); 
    file g=new file();
    RSA rsa=new RSA();
       
    public frmMaHoa() {
        initComponents();
        buttonGroup1.add(rdGiaMa);
        buttonGroup1.add(rdMaHoa);
        buttonGroup2.add(cbCo);
        buttonGroup2.add(cbKhong);
        cbCo.setVisible(true);
        rdMaHoa.setSelected(true);
       jButton3.setVisible(false);
            jButton2.setVisible(true);
            txtkey.setVisible(true);
            btnFileKey.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnFileMa = new javax.swing.JButton();
        txtPath = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtkey = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnFileKey = new javax.swing.JButton();
        txtKeyPath = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rdMaHoa = new javax.swing.JRadioButton();
        rdGiaMa = new javax.swing.JRadioButton();
        cbCo = new javax.swing.JRadioButton();
        cbKhong = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFileMa.setText("Chọn file mã hoá");
        btnFileMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileMaActionPerformed(evt);
            }
        });

        jButton2.setText("Mã hoá");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtkey.setText("Key");

        jButton3.setText("Giải mã ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn chế độ ");

        btnFileKey.setText("Chọn file key ");
        btnFileKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileKeyActionPerformed(evt);
            }
        });

        jLabel2.setText("Chọn thuật toán: ");

        rdMaHoa.setText("Mã hoá");
        rdMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdMaHoaActionPerformed(evt);
            }
        });

        rdGiaMa.setText("Giải mã");
        rdGiaMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdGiaMaActionPerformed(evt);
            }
        });

        cbCo.setText("Có RSA");

        cbKhong.setText("Không RSA");

        jLabel3.setText("Chú ý: RSA chỉ mã hoá được File nhỏ hơn 117 Byte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFileKey)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKeyPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFileMa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdMaHoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdGiaMa)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbKhong)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCo)
                            .addComponent(cbKhong))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(25, 25, 25)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdMaHoa)
                            .addComponent(rdGiaMa))))
                .addGap(4, 4, 4)
                .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFileMa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFileKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtKeyPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel3))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFileMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileMaActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
    File file = fc.getSelectedFile();
    path=file.getAbsolutePath();
    k.setTenfile(file.getName());
            System.out.println(file.getName());
} else {
    // User clicked cancel
}
         
        txtPath.setText(path);
        
    }//GEN-LAST:event_btnFileMaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        key=txtkey.getText();
        Blowfish2 bf=new Blowfish2(txtkey.getText());
        Key sk=null;
        try {
            if(cbKhong.isSelected())
            {
                sk = des.taoKey();
                k.setDesKey(sk);
                k.setBlowfishKey(bf.getSkeySpec());
            }
            
            
            if(cbCo.isSelected())
            {
                sk = des.taoKey();
                k.setDesKey(sk);
                k.setBlowfishKey(bf.getSkeySpec());
                rsa.taokeyRSA(k);
            }
                
                g.ghiKey(k, "mahoa\\"+k.getTenfile()+".k");
        } catch (NoSuchAlgorithmException | IOException ex) {
            Logger.getLogger(frmMaHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            byte[] enDes=null;
            byte[] enBlow=null;
            byte[] enRSA=null;
            byte[] Bout = Files.readAllBytes(Paths.get(path));
            enDes= des.maHoa(Bout, k.getDesKey());
            enBlow = bf.Encrypt(enDes);
            if(cbKhong.isSelected())
            {
                FileUtils.writeByteArrayToFile(new File("mahoa\\"+k.getTenfile()+".ma"),enBlow);
                JOptionPane.showMessageDialog(null,
                    "Mã hoá thành công!!");
            }
            else if(cbCo.isSelected())
            {
                try {
                    enRSA = new MaHoaRSA().mahoaRSA(enBlow, k.getRsaPublicKey());
                    FileUtils.writeByteArrayToFile(new File("mahoa\\"+k.getTenfile()+".ma"),enRSA);
                    JOptionPane.showMessageDialog(null,
                    "Mã hoá thành công!!");
                } catch (HeadlessException | IOException e) {
                    JOptionPane.showMessageDialog(null,
                    "File quá 117 Bytes. Vui lòng không chọn RSA");
                }
                
            }
           
        } catch (IOException | GeneralSecurityException ex) {
            Logger.getLogger(frmMaHoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            k=null;
            k=g.docKey(pathk);
            Blowfish2 bf=new Blowfish2("aaa");
            bf.setSkeySpec(k.getBlowfishKey());
            DES des=new DES();
            byte[] deDes=null;
            byte[] deBlow=null;
            byte[] deRSA=null;
            byte[] Bout = Files.readAllBytes(Paths.get(path));
           
            if(cbKhong.isSelected())
            {
                deBlow=bf.Decrypt(Bout);
                deDes=des.giaiMa(deBlow, k.getDesKey());
                FileUtils.writeByteArrayToFile(new File("giaima\\"+k.getTenfile()+"."+k.getDuoifile()),deDes);
                JOptionPane.showMessageDialog(null,
                    "Giải mã thành công!!");
            }
            else if(cbCo.isSelected())
            {
                deRSA=new GiaiMaRSA().giamaRSA(Bout, k.getRsaPrivateKey());
                deBlow=bf.Decrypt(deRSA);
                deDes=des.giaiMa(deBlow, k.getDesKey());
                FileUtils.writeByteArrayToFile(new File("giaima\\"+k.getTenfile()+"."+k.getDuoifile()),deDes);
                JOptionPane.showMessageDialog(null,
                    "Giải mã thành công!!");
                
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(frmMaHoa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "File key lỗi");
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(frmMaHoa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,
                    "Giải mã lỗi !");
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnFileKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileKeyActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        pathk=file.getAbsolutePath();
        txtKeyPath.setText(pathk);
} else {
    // User clicked cancel
}
         
        txtPath.setText(path);
    }//GEN-LAST:event_btnFileKeyActionPerformed

    private void rdMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdMaHoaActionPerformed
        btnFileKey.setVisible(false);
            jButton3.setVisible(false);
            jButton2.setVisible(true);
            txtkey.setVisible(true);
    }//GEN-LAST:event_rdMaHoaActionPerformed

    private void rdGiaMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdGiaMaActionPerformed
        btnFileKey.setVisible(true);
             jButton3.setVisible(true);
             jButton2.setVisible(false);
             txtkey.setVisible(false);
    }//GEN-LAST:event_rdGiaMaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMaHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMaHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMaHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMaHoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMaHoa().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFileKey;
    private javax.swing.JButton btnFileMa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton cbCo;
    private javax.swing.JRadioButton cbKhong;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rdGiaMa;
    private javax.swing.JRadioButton rdMaHoa;
    private javax.swing.JLabel txtKeyPath;
    private javax.swing.JLabel txtPath;
    private javax.swing.JTextField txtkey;
    // End of variables declaration//GEN-END:variables
}