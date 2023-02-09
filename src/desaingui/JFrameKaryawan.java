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
public class JFrameKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form JFrameKaryawan
     */
    public JFrameKaryawan() {
        initComponents();
        this.jButton1.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton2.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton3.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton4.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton5.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton6.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldkd_karyawan.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldnama_karyawan.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldno_telp.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldalamat.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldemail.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtonhapuskar.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtonubahkar.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtontambahdatakar.setBackground(new java.awt.Color(0, 0, 0, 0));
        
        this.jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        
        this.tekscari.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butoncccari.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butonlogout.setBackground(new java.awt.Color(0, 0, 0, 0));
        updateTable();
        createkd();

        this.jTextFieldkd_karyawan.setText(this.createkd());
    }
    
     public String createkd(){
        try{
            // menyiapkan query untuk mendapatkan id terakhir
            String query = "SELECT * FROM tbl_karyawan ORDER BY kd_karyawan DESC LIMIT 0,1", lastID, kd_karyawan;
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            // cek apakah query berhasil dieksekusi
            if(res.next()){
                // mendapatkan id terakhir
                lastID =  res.getString("kd_karyawan");
                if(lastID != null){
                    // mendapatkan nomor id
                    kd_karyawan = lastID.substring(2);
                }else{
                    kd_karyawan= "KR000";
                }
                // jika id barang belum exist maka id akan dibuat
                return String.format("KR%04d", Integer.parseInt(kd_karyawan)+1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
private void updateTable() {
        String[] columnNames = {"kd_karyawan", "Nama_Karyawan", "No_Telp", "Alamat","Email"};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        
        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT kd_karyawan,nama_karyawan, notelp_karyawan, alamat_karyawan, email_karyawan FROM tbl_karyawan");
            
            while(rs.next()) {
                String kd_karyawan = rs.getString("kd_karyawan"),
                            Nama_Karyawan = rs.getString("nama_karyawan"),
                            No_Telp = rs.getString("notelp_karyawan"),
                            Alamat = rs.getString("alamat_karyawan"),
                            Email = rs.getString("email_karyawan");
                            
                
                // create a single array of one rows worth of data
                String[] data = {kd_karyawan, Nama_Karyawan, No_Telp, Alamat, Email};
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
            String sql = "SELECT * FROM tbl_karyawan WHERE kd_karyawan= '" + this.idSelected + "'";
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            // get data
            if (r.next()) {
                String kd_karyawan = r.getString("kd_karyawan"),
                            Nama_Karyawan = r.getString("nama_karyawan"),
                            No_Telp = r.getString("notelp_karyawan"),
                            Alamat = r.getString("alamat_karyawan"),
                            Email = r.getString("email_karyawan");
                            
                
                // menampilkan data
                this.jTextFieldkd_karyawan.setText(this.idSelected);
                this.jTextFieldnama_karyawan.setText(Nama_Karyawan);
                this.jTextFieldno_telp.setText(No_Telp);
                this.jTextFieldalamat.setText(Alamat);
                this.jTextFieldemail.setText(Email);
               
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextFieldkd_karyawan = new javax.swing.JTextField();
        jTextFieldnama_karyawan = new javax.swing.JTextField();
        jTextFieldno_telp = new javax.swing.JTextField();
        jTextFieldalamat = new javax.swing.JTextField();
        jTextFieldemail = new javax.swing.JTextField();
        jButtonhapuskar = new javax.swing.JButton();
        jButtonubahkar = new javax.swing.JButton();
        jButtontambahdatakar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        butonlogout = new javax.swing.JButton();
        tekscari = new javax.swing.JTextField();
        butoncccari = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 320, 50));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 320, 50));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 320, 50));

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

        jTextFieldkd_karyawan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldkd_karyawan.setBorder(null);
        getContentPane().add(jTextFieldkd_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 460, 70));

        jTextFieldnama_karyawan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldnama_karyawan.setBorder(null);
        jTextFieldnama_karyawan.setPreferredSize(new java.awt.Dimension(84, 84));
        getContentPane().add(jTextFieldnama_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 460, 70));

        jTextFieldno_telp.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldno_telp.setBorder(null);
        jTextFieldno_telp.setPreferredSize(new java.awt.Dimension(84, 84));
        getContentPane().add(jTextFieldno_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 460, 70));

        jTextFieldalamat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldalamat.setBorder(null);
        jTextFieldalamat.setPreferredSize(new java.awt.Dimension(84, 84));
        getContentPane().add(jTextFieldalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, 460, 70));

        jTextFieldemail.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldemail.setBorder(null);
        jTextFieldemail.setPreferredSize(new java.awt.Dimension(84, 84));
        jTextFieldemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldemailActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 770, 460, 70));

        jButtonhapuskar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapuskarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonhapuskar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 110, 210, 60));

        jButtonubahkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonubahkarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonubahkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 110, 210, 60));

        jButtontambahdatakar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontambahdatakarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtontambahdatakar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 210, 60));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 280, 770, 560));

        butonlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(butonlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 30, 140, 40));

        tekscari.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tekscari.setBorder(null);
        getContentPane().add(tekscari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 200, 510, 50));

        butoncccari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butoncccariActionPerformed(evt);
            }
        });
        getContentPane().add(butoncccari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1780, 200, 60, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/KARYAWAN.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane2.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1830, 20, -1, -1));

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

    private void jTextFieldemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldemailActionPerformed

    private void jButtontambahdatakarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontambahdatakarActionPerformed
        // TODO add your handling code here:
          String kd_karyawan = this.jTextFieldkd_karyawan.getText(),
                    Nama_Karyawan = this.jTextFieldnama_karyawan.getText(),
                    No_Telp = this.jTextFieldno_telp.getText(),
                   Alamat = this.jTextFieldalamat.getText(),
                  Email = this.jTextFieldemail.getText();
          
          try{
               String sql = "INSERT INTO tbl_karyawan VALUES (?, ?, ?, ?,?)";
               Connection conn = (Connection) koneksi.configDB();
               PreparedStatement pst = conn.prepareStatement(sql);
               
               pst.setString(1, kd_karyawan);
               pst.setString(2, Nama_Karyawan);
               pst.setString(3, No_Telp);
               pst.setString(4, Alamat);
               pst.setString(5, Email);
               
               
               pst.executeUpdate();
               
               conn.close();
//               clearanceaddtextkaryawan();
               JOptionPane.showMessageDialog(rootPane, "Data Berhasil di Input");
               this.jTextFieldkd_karyawan.setText("");
               this.jTextFieldkd_karyawan.setText(this.createkd());
        this.jTextFieldnama_karyawan.setText("");
        this.jTextFieldno_telp.setText("");
        this.jTextFieldalamat.setText("");
        this.jTextFieldemail.setText("");
           }catch(SQLException ex){
               clearanceaddtextkaryawan();
               ex.printStackTrace();
               JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
           }
           this.updateTable();
    }//GEN-LAST:event_jButtontambahdatakarActionPerformed

    private void jButtonhapuskarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapuskarActionPerformed
        // TODO add your handling code here:
          this.idSelected = this.jTable1.getValueAt(this.jTable1.getSelectedRow(),0).toString();
          try {
            String sql = "DELETE FROM tbl_karyawan WHERE kd_karyawan = '"+ idSelected +"'";
            Connection konekni = (Connection) koneksi.configDB();
            Statement stat = konekni.createStatement();
            stat.executeUpdate(sql);
            this.updateTable();
            this.jTextFieldkd_karyawan.setText("");
            this.jTextFieldnama_karyawan.setText("");
             this.jTextFieldno_telp.setText("");
            this.jTextFieldalamat.setText("");
            this.jTextFieldemail.setText("");
          
            System.out.println("ID SELECTED: "+idSelected);
            JOptionPane.showMessageDialog(this, "data berhasil di hapus ");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonhapuskarActionPerformed

    private void jButtonubahkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonubahkarActionPerformed
        // TODO add your handling code here:
         String kd_karyawan = this.jTextFieldkd_karyawan.getText(),
                    Nama_Karyawan = this.jTextFieldnama_karyawan.getText(),
                  No_Telp = this.jTextFieldno_telp.getText(),
                    Alamat = this.jTextFieldalamat.getText(),
                 Email = this.jTextFieldemail.getText();
                   
                    
        try {
            String sql = String.format("UPDATE tbl_karyawan SET nama_karyawan = '%s', notelp_karyawan = '%s', alamat_karyawan = '%s', email_karyawan = '%s' WHERE kd_karyawan = '%s'", Nama_Karyawan, No_Telp,
                    Alamat, Email, kd_karyawan);
            Connection konekin = (Connection) koneksi.configDB();
            Statement stat = konekin.createStatement();
            stat.executeUpdate(sql);
            this.updateTable();
            this.jTextFieldkd_karyawan.setText("");
            this.jTextFieldnama_karyawan.setText("");
            this.jTextFieldno_telp.setText("");
            this.jTextFieldalamat.setText("");
            this.jTextFieldemail.setText("");
           
            JOptionPane.showMessageDialog(this, "data berhasil terupdate");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonubahkarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.showData();
    }//GEN-LAST:event_jTable1MouseClicked

    private void butoncccariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butoncccariActionPerformed
        // TODO add your handling code here:
         String[] columnNames = {"kd_karyawan", "Nama_Karyawan", "No_Telp", "Alamat","Email"};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        try {
            String findBarang = this.tekscari.getText();
            String sql = ("SELECT kd_karyawan, nama_karyawan, notelp_karyawan, alamat_karyawan, email_karyawan FROM tbl_karyawan WHERE nama_karyawan LIKE '%" + findBarang + "%'");
            Connection konekin = (Connection) koneksi.configDB();
            Statement stat = konekin.createStatement();
            ResultSet rs = stat.executeQuery(sql);
              while(rs.next()) {
                String kd_karyawan = rs.getString("kd_karyawan"),
                            Nama_Karyawan = rs.getString("nama_karyawan"),
                            No_Telp = rs.getString("notelp_karyawan"),
                            Alamat = rs.getString("alamat_karyawan"),
                            Email = rs.getString("email_karyawan");
                            
                
                // create a single array of one rows worth of data
                String[] data = {kd_karyawan, Nama_Karyawan, No_Telp, Alamat, Email};
                tablemodel.addRow(data);
                
            } }
             catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
        this.jTable1.setModel(tablemodel);
    }//GEN-LAST:event_butoncccariActionPerformed

    private void butonlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonlogoutActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin logout?", "confirm", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(res == JOptionPane.YES_OPTION){
            JFramelogin l = new JFramelogin();
            l.setVisible(true);
        }
    }//GEN-LAST:event_butonlogoutActionPerformed
private void clearanceaddtextkaryawan(){
        this.jTextFieldkd_karyawan.setText("");
        this.jTextFieldnama_karyawan.setText("");
        this.jTextFieldno_telp.setText("");
        this.jTextFieldalamat.setText("");
        this.jTextFieldemail.setText("");
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
            java.util.logging.Logger.getLogger(JFrameKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butoncccari;
    private javax.swing.JButton butonlogout;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonhapuskar;
    private javax.swing.JButton jButtontambahdatakar;
    private javax.swing.JButton jButtonubahkar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldalamat;
    private javax.swing.JTextField jTextFieldemail;
    private javax.swing.JTextField jTextFieldkd_karyawan;
    private javax.swing.JTextField jTextFieldnama_karyawan;
    private javax.swing.JTextField jTextFieldno_telp;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField tekscari;
    // End of variables declaration//GEN-END:variables
}
