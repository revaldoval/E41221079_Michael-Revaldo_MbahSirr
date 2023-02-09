/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desaingui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class JFrameSupplier extends javax.swing.JFrame {
     public String createkd(){
        try{
            // menyiapkan query untuk mendapatkan id terakhir
            String query = "SELECT * FROM tbl_supplier ORDER BY kd_supplier DESC LIMIT 0,1", lastID, kd_supplier;
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            // cek apakah query berhasil dieksekusi
            if(res.next()){
                // mendapatkan id terakhir
                lastID =  res.getString("kd_supplier");
                if(lastID != null){
                    // mendapatkan nomor id
                    kd_supplier= lastID.substring(2);
                }else{
                    kd_supplier= "SP000";
                }
                // jika id barang belum exist maka id akan dibuat
                return String.format("SP%04d", Integer.parseInt(kd_supplier)+1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     private void updateTable() {
        String[] columnNames = {"kd_supplier", "nama_supplier", "   Alamat", "No_Telp",};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        
        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT kd_supplier, nama_supplier, notelp_supplier, alamat_supplier FROM tbl_supplier");
            
            while(rs.next()) {
                String kd_supplier = rs.getString("kd_supplier"),
                            nama_supplier = rs.getString("nama_supplier"),
                            Alamat = rs.getString("alamat_supplier"),
                            No_Telp = rs.getString("notelp_supplier");
                            
                
                // create a single array of one rows worth of data
                String[] data = {kd_supplier, nama_supplier, Alamat, No_Telp};
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
            String sql = "SELECT * FROM tbl_supplier WHERE kd_supplier = '" + this.idSelected + "'";
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            // get data
            if (r.next()) {
                String nama_supplier = r.getString("nama_supplier"),
                            Alamat = r.getString("alamat_supplier"),
                            No_Telp = r.getString("notelp_supplier");
                            
                
                // menampilkan data
                this.jTextFieldkd_supplier.setText(this.idSelected);
                this.jTextFieldnama_supplier.setText(nama_supplier);
                this.jTextFieldalamat_supplier.setText(Alamat);
                this.jTextFieldnotelp_supplier.setText(No_Telp);
               
                
                
            } 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
    }

    /**
     * Creates new form JFrameSupplier
     */
    public JFrameSupplier() {
        initComponents();
         this.jButton1.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton2.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton3.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton4.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton5.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton6.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtontambahdatasup.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtonhapussup.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtonubahsup.setBackground(new java.awt.Color(0, 0, 0, 0));

        this.jTextFieldkd_supplier.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldnama_supplier.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldalamat_supplier.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldnotelp_supplier.setBackground(new java.awt.Color(0, 0, 0, 0));

        this.tekscari.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butoncari.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butonlogout.setBackground(new java.awt.Color(0, 0, 0, 0));
        
         this.jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        updateTable();
        createkd();

        this.jTextFieldkd_supplier.setText(this.createkd());
                  
                  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextFieldkd_supplier = new javax.swing.JTextField();
        jTextFieldnama_supplier = new javax.swing.JTextField();
        jTextFieldalamat_supplier = new javax.swing.JTextField();
        jTextFieldnotelp_supplier = new javax.swing.JTextField();
        jButtontambahdatasup = new javax.swing.JButton();
        jButtonubahsup = new javax.swing.JButton();
        jButtonhapussup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        butonlogout = new javax.swing.JButton();
        butoncari = new javax.swing.JButton();
        tekscari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 320, 50));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 320, 50));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 320, 50));

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 320, 50));

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 320, 50));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 320, 50));

        jTextFieldkd_supplier.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldkd_supplier.setBorder(null);
        jTextFieldkd_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldkd_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldkd_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 470, 80));

        jTextFieldnama_supplier.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldnama_supplier.setBorder(null);
        getContentPane().add(jTextFieldnama_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 470, 80));

        jTextFieldalamat_supplier.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldalamat_supplier.setBorder(null);
        getContentPane().add(jTextFieldalamat_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 630, 470, 80));

        jTextFieldnotelp_supplier.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldnotelp_supplier.setBorder(null);
        getContentPane().add(jTextFieldnotelp_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 810, 470, 80));

        jButtontambahdatasup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontambahdatasupActionPerformed(evt);
            }
        });
        getContentPane().add(jButtontambahdatasup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 210, 60));

        jButtonubahsup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonubahsupActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonubahsup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 110, 210, 60));

        jButtonhapussup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapussupActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonhapussup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 110, 210, 60));

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
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 290, 760, 600));

        butonlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(butonlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, 140, 40));

        butoncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butoncariActionPerformed(evt);
            }
        });
        getContentPane().add(butoncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1770, 220, 70, 50));

        tekscari.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tekscari.setBorder(null);
        getContentPane().add(tekscari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 220, 500, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/SUPPLIER.png"))); // NOI18N
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

    private void jTextFieldkd_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldkd_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldkd_supplierActionPerformed

    private void jButtontambahdatasupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontambahdatasupActionPerformed
        // TODO add your handling code here:
        String kd_supplier = this.jTextFieldkd_supplier.getText(),
                    nama_supplier = this.jTextFieldnama_supplier.getText(),
                    Alamat = this.jTextFieldalamat_supplier.getText(),
                    No_Telp= this.jTextFieldnotelp_supplier.getText();
                    
        try{
               String sql = "INSERT INTO tbl_supplier VALUES (?, ?, ?, ?)";
               Connection conn = (Connection) koneksi.configDB();
               PreparedStatement pst = conn.prepareStatement(sql);
               
               pst.setString(1, kd_supplier);
               pst.setString(2, nama_supplier);
                pst.setString(3, No_Telp);
                 pst.setString(4,Alamat);

               pst.executeUpdate();
               
               conn.close();
//               clearanceaddtextsupplier();
               JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Input");
               this.jTextFieldkd_supplier.setText("");
               this.jTextFieldkd_supplier.setText(this.createkd());
               this.jTextFieldnama_supplier.setText("");
               this.jTextFieldalamat_supplier.setText("");
                this.jTextFieldnotelp_supplier.setText("");
           }catch(SQLException ex){
               clearanceaddtextsupplier();
               ex.printStackTrace();
               JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
           }
        this.updateTable();
    }//GEN-LAST:event_jButtontambahdatasupActionPerformed

    private void jButtonhapussupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapussupActionPerformed
        // TODO add your handling code here:
         this.idSelected = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
          try {
            String sql = "DELETE FROM tbl_supplier WHERE kd_supplier = '"+ idSelected +"'";
            Connection konekni = (Connection) koneksi.configDB();
            Statement stat = konekni.createStatement();
            stat.executeUpdate(sql);
            this.updateTable();
            this.jTextFieldkd_supplier.setText("");
            this.jTextFieldnama_supplier.setText("");
             this.jTextFieldalamat_supplier.setText("");
            this.jTextFieldnotelp_supplier.setText("");
          
            System.out.println("ID SELECTED: "+idSelected);
            JOptionPane.showMessageDialog(this, "data berhasil di hapus ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        
    }//GEN-LAST:event_jButtonhapussupActionPerformed

    private void jButtonubahsupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonubahsupActionPerformed
        // TODO add your handling code here:
         String kd_supplier = this.jTextFieldkd_supplier.getText(),
                    nama_supplier = this.jTextFieldnama_supplier.getText(),
                  Alamat= this.jTextFieldalamat_supplier.getText(),
                    No_Telp = this.jTextFieldnotelp_supplier.getText();
                   
                    
        try {
            String sql = String.format("UPDATE tbl_supplier SET nama_supplier = '%s', alamat_supplier = '%s', notelp_supplier = '%s' WHERE kd_supplier = '%s'", nama_supplier, Alamat,
                   No_Telp, kd_supplier);
            Connection konekin = (Connection) koneksi.configDB();
            Statement stat = konekin.createStatement();
            stat.executeUpdate(sql);
            this.updateTable();
            this.jTextFieldkd_supplier.setText("");
            this.jTextFieldnama_supplier.setText("");
            this.jTextFieldalamat_supplier.setText("");
            this.jTextFieldnotelp_supplier.setText("");
           
            JOptionPane.showMessageDialog(this, "data berhasil terupdate");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonubahsupActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         showData();
    }//GEN-LAST:event_jTable1MouseClicked

    private void butoncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butoncariActionPerformed
        // TODO add your handling code here:
         String[] columnNames = {"kd_supplier", "nama_supplier", "   Alamat", "No_Telp"};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        try {
            String findBarang = this.tekscari.getText();
            String sql = ("SELECT kd_supplier, nama_supplier, notelp_supplier, alamat_supplier FROM tbl_supplier WHERE nama_supplier LIKE '%" + findBarang + "%'");
            Connection konekin = (Connection) koneksi.configDB();
            Statement stat = konekin.createStatement();
            ResultSet rs = stat.executeQuery(sql);
              while(rs.next()) {
                String kd_supplier = rs.getString("kd_supplier"),
                            nama_supplier = rs.getString("nama_supplier"),
                            Alamat = rs.getString("alamat_supplier"),
                            No_Telp = rs.getString("notelp_supplier");
                            
                
                // create a single array of one rows worth of data
                String[] data = {kd_supplier, nama_supplier, Alamat, No_Telp};
                tablemodel.addRow(data);
                
            } }
             catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
        this.jTable1.setModel(tablemodel);
    }//GEN-LAST:event_butoncariActionPerformed

    private void butonlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonlogoutActionPerformed
        // TODO add your handling code here:
         int res = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin logout?", "confirm", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(res == JOptionPane.YES_OPTION){
            JFramelogin l = new JFramelogin();
            l.setVisible(true);
        }
    }//GEN-LAST:event_butonlogoutActionPerformed

     private void clearanceaddtextsupplier(){
        this.jTextFieldkd_supplier.setText("");
        this.jTextFieldnama_supplier.setText("");
        this.jTextFieldalamat_supplier.setText("");
        this.jTextFieldnotelp_supplier.setText("");
       
        
    } 
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
            java.util.logging.Logger.getLogger(JFrameSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butoncari;
    private javax.swing.JButton butonlogout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonhapussup;
    private javax.swing.JButton jButtontambahdatasup;
    private javax.swing.JButton jButtonubahsup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldalamat_supplier;
    private javax.swing.JTextField jTextFieldkd_supplier;
    private javax.swing.JTextField jTextFieldnama_supplier;
    private javax.swing.JTextField jTextFieldnotelp_supplier;
    private javax.swing.JTextField tekscari;
    // End of variables declaration//GEN-END:variables
}
