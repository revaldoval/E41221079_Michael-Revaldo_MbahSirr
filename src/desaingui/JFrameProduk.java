/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desaingui;

import com.sun.glass.events.KeyEvent;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class JFrameProduk extends javax.swing.JFrame {

    /**
     * Creates new form JFrameProduk
     */
    public String createkd(){
        try{
            // menyiapkan query untuk mendapatkan id terakhir
            String query = "SELECT * FROM tbl_barang ORDER BY kd_barang DESC LIMIT 0,1", lastID, kd_barang;
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            // cek apakah query berhasil dieksekusi
            if(res.next()){
                // mendapatkan id terakhir
                lastID =  res.getString("kd_barang");
                if(lastID != null){
                    // mendapatkan nomor id
                    kd_barang = lastID.substring(2);
                }else{
                    kd_barang= "BG000";
                }
                // jika id barang belum exist maka id akan dibuat
                return String.format("BG%04d", Integer.parseInt(kd_barang)+1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public JFrameProduk() {
        initComponents();
         this.jButton1.setBackground(new java.awt.Color(0,0,0,0));
            this.jButton2.setBackground(new java.awt.Color(0,0,0,0));
              this.jButton3.setBackground(new java.awt.Color(0,0,0,0));
                this.jButton4.setBackground(new java.awt.Color(0,0,0,0));
                  this.jButton5.setBackground(new java.awt.Color(0,0,0,0));
                   this.jButton6.setBackground(new java.awt.Color(0,0,0,0));
                   this.jButton7Tambahdataproduk.setBackground(new java.awt.Color(0,0,0,0));
                   this.jButton8hapusbarang.setBackground(new java.awt.Color(0,0,0,0));
                   this.jButton9ubahbarang.setBackground(new java.awt.Color(0,0,0,0));
                   this.jButton7pencarian.setBackground(new java.awt.Color(0,0,0,0));
                   this.jTextField1kolompencarian.setBackground(new java.awt.Color(0,0,0,0));
                   this.jTextField2kdproduk.setBackground(new java.awt.Color(0,0,0,0));
                   this.jTextField3namaproduk.setBackground(new java.awt.Color(0,0,0,0));
                   this.jTextField4hargaproduk.setBackground(new java.awt.Color(0,0,0,0));
                   this.jTextField5stokproduk.setBackground(new java.awt.Color(0,0,0,0));
                   updateTable();
                   createkd();
                   
                   this.jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
         this.jTextField2kdproduk.setText(this.createkd());
    }
    
    private void updateTable() {
        String[] columnNames = {"kd_produk", "nama_produk", "harga", "stok",};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        
        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT kd_barang, nama_barang, harga_barang, stok_barang FROM tbl_barang");
            
            while(rs.next()) {
                String kd_produk = rs.getString("kd_barang"),
                            nama_produk = rs.getString("nama_barang"),
                            harga = rs.getString("harga_barang"),
                            stok = rs.getString("stok_barang");
                            
                
                // create a single array of one rows worth of data
                String[] data = {kd_produk, nama_produk, harga, stok};
                tablemodel.addRow(data);
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.jTable1.setModel(tablemodel);
    }
    private String idSelected;
        
      private void showData() {
        try{
            
           this.idSelected = this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString();
            String sql = "SELECT * FROM tbl_barang WHERE kd_barang = '" + this.idSelected + "'";
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            // get data
            if (r.next()) {
                String nama_produk = r.getString("nama_barang"),
                            harga = r.getString("harga_barang"),
                            stok = r.getString("stok_barang");
                            
                
                // menampilkan data
                this.jTextField2kdproduk.setText(this.idSelected);
                this.jTextField3namaproduk.setText(nama_produk);
                this.jTextField4hargaproduk.setText(harga);
                this.jTextField5stokproduk.setText(stok);
               
                
                
            } 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
    }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jButton8hapusbarang = new javax.swing.JButton();
        jButton9ubahbarang = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton7pencarian = new javax.swing.JButton();
        jTextField2kdproduk = new javax.swing.JTextField();
        jTextField1kolompencarian = new javax.swing.JTextField();
        jTextField3namaproduk = new javax.swing.JTextField();
        jTextField4hargaproduk = new javax.swing.JTextField();
        jTextField5stokproduk = new javax.swing.JTextField();
        jButton7Tambahdataproduk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1975, 1080));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 660, -1, -1));

        jButton8hapusbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8hapusbarangActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8hapusbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 110, 210, 60));

        jButton9ubahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ubahbarangActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9ubahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 110, 210, 60));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 320, 50));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 320, 50));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 320, 50));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 320, 50));

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 320, 50));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 320, 50));

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(26);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 300, 850, -1));

        jButton7pencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7pencarianActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7pencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 220, 60, 50));

        jTextField2kdproduk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField2kdproduk.setBorder(null);
        getContentPane().add(jTextField2kdproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 400, 40));

        jTextField1kolompencarian.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField1kolompencarian.setBorder(null);
        jTextField1kolompencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1kolompencarianActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1kolompencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 220, 500, 50));

        jTextField3namaproduk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField3namaproduk.setBorder(null);
        getContentPane().add(jTextField3namaproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 400, 40));

        jTextField4hargaproduk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField4hargaproduk.setBorder(null);
        jTextField4hargaproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4hargaprodukActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4hargaproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 400, 40));

        jTextField5stokproduk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextField5stokproduk.setBorder(null);
        jTextField5stokproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5stokprodukActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5stokproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 400, 40));

        jButton7Tambahdataproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7TambahdataprodukActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7Tambahdataproduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 210, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/PRODUK.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new JFrameDashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new JFrameProduk().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new JFrameKaryawan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new JFrameLaporan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new JFrameSupplier().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new JFrameTransaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8hapusbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8hapusbarangActionPerformed
        // TODO add your handling code here:
        this.idSelected = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
          try {
            String sql = "DELETE FROM tbl_barang WHERE kd_barang = '"+ idSelected +"'";
            Connection konekni = (Connection) koneksi.configDB();
            Statement stat = konekni.createStatement();
            stat.executeUpdate(sql);
            this.updateTable();
            this.jTextField2kdproduk.setText("");
            this.jTextField3namaproduk.setText("");
             this.jTextField4hargaproduk.setText("");
            this.jTextField5stokproduk.setText("");
          
            System.out.println("ID SELECTED: "+idSelected);
            JOptionPane.showMessageDialog(this, "data berhasil di hapus aowkaowk");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
          createkd();
    }//GEN-LAST:event_jButton8hapusbarangActionPerformed

    private void jTextField1kolompencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1kolompencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1kolompencarianActionPerformed

    private void jButton7TambahdataprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7TambahdataprodukActionPerformed
          String kd_produk = this.createkd(),
                    nama_produk = this.jTextField3namaproduk.getText(),
                    harga = this.jTextField4hargaproduk.getText(),
                    stok = this.jTextField5stokproduk.getText();
                    
        try{
               String sql = "INSERT INTO tbl_barang VALUES (?, ?, ?, ?)";
               Connection conn = (Connection) koneksi.configDB();
               PreparedStatement pst = conn.prepareStatement(sql);
               
               pst.setString(1, kd_produk);
               pst.setString(2, nama_produk);
               pst.setInt(3, Integer.parseInt(harga));
               pst.setInt(4, Integer.parseInt(stok));
               
               
               pst.executeUpdate();
               
               conn.close();
               clearanceaddtextbarang();
               
               JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Input");
           }catch(SQLException ex){
               clearanceaddtextbarang();
               ex.printStackTrace();
               JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
           }
        this.updateTable();
//        createkd();
        this.jTextField2kdproduk.setText("");
        this.jTextField2kdproduk.setText(this.createkd());
        this.jTextField3namaproduk.setText("");
        this.jTextField4hargaproduk.setText("");
        this.jTextField5stokproduk.setText("");
//        
    }                                         

//    private void addincrementid(){
//        
//    }
    
    private void clearanceaddtextbarang(){
        this.jTextField2kdproduk.setText("");
        this.jTextField3namaproduk.setText("");
        this.jTextField4hargaproduk.setText("");
        this.jTextField5stokproduk.setText("");
       
        
    }//GEN-LAST:event_jButton7TambahdataprodukActionPerformed

    private void jTextField4hargaprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4hargaprodukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4hargaprodukActionPerformed

    private void jButton9ubahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ubahbarangActionPerformed
        // TODO add your handling code here:
          String kd_barang = this.jTextField2kdproduk.getText(),
                    nama_produk = this.jTextField3namaproduk.getText(),
                  harga = this.jTextField4hargaproduk.getText(),
                    stok = this.jTextField5stokproduk.getText();
                   
                    
        try {
            String sql = String.format("UPDATE tbl_barang SET nama_barang = '%s', harga_barang = '%s', stok_barang = '%s' WHERE kd_barang = '%s'", nama_produk, harga,
                    stok, kd_barang);
            Connection konekin = (Connection) koneksi.configDB();
            Statement stat = konekin.createStatement();
            stat.executeUpdate(sql);
            this.updateTable();
            this.jTextField2kdproduk.setText("");
            this.jTextField3namaproduk.setText("");
            this.jTextField4hargaproduk.setText("");
            this.jTextField5stokproduk.setText("");
           
            JOptionPane.showMessageDialog(this, "data berhasil terupdate");
            this.createkd();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton9ubahbarangActionPerformed

    private void jTextField5stokprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5stokprodukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5stokprodukActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.showData();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7pencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7pencarianActionPerformed
        // TODO add your handling code here:
         String[] columnNames = {"kd_produk", "nama_produk", "harga", "stok"};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        try {
            String findBarang = this.jTextField1kolompencarian.getText();
            String sql = ("SELECT kd_barang, nama_barang, harga_barang, stok_barang FROM tbl_barang WHERE nama_barang LIKE '%" + findBarang + "%'");
            Connection konekin = (Connection) koneksi.configDB();
            Statement stat = konekin.createStatement();
            ResultSet rs = stat.executeQuery(sql);
              while(rs.next()) {
                String kd_produk = rs.getString("kd_barang"),
                            nama_produk= rs.getString("nama_barang"),
                         harga = rs.getString("harga_barang"),
                            stok = rs.getString("stok_barang");
                            
                           
                
                // create a single array of one rows worth of data
                String[] data = {kd_produk, nama_produk, harga, stok,};
                tablemodel.addRow(data);
                
            } }
             catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
        this.jTable1.setModel(tablemodel);
    
    }//GEN-LAST:event_jButton7pencarianActionPerformed
 
    
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
            java.util.logging.Logger.getLogger(JFrameProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameProduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7Tambahdataproduk;
    private javax.swing.JButton jButton7pencarian;
    private javax.swing.JButton jButton8hapusbarang;
    private javax.swing.JButton jButton9ubahbarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1kolompencarian;
    private javax.swing.JTextField jTextField2kdproduk;
    private javax.swing.JTextField jTextField3namaproduk;
    private javax.swing.JTextField jTextField4hargaproduk;
    private javax.swing.JTextField jTextField5stokproduk;
    // End of variables declaration//GEN-END:variables
}
