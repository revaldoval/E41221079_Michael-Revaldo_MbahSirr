/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package desaingui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class JFrameDashboard extends javax.swing.JFrame {

    /**
     * Creates new form JFrameDashboard
     */
    public JFrameDashboard() {
        initComponents();
        this.jButton1.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton2.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton3.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton4.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton5.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton6.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.pendapatanharian.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pendapatanminggu.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pendapatanbulan.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pendapatantahun.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pengeluaranmingguan.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pengeluaranbulan.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pengeluarantahun.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.pengeluaranperhari.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        tampildata();
                  pendapatanhari();
                   pendapatanminggu();
                   pendapatanBULAN();
                   pendapatanTAHUN();
                   pengeluaranminggu();
                   pengeluaranbulan();
                   pengeluarantahun();
                   pengeluaranhari();
                   this.butonlogout.setBackground(new java.awt.Color(0, 0, 0, 0));
                   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butonlogout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        pengeluaran = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendapatanminggu = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pendapatanbulan = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        pendapatantahun = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pengeluaranmingguan = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        pengeluaranbulan = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        pengeluarantahun = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        pendapatanharian = new javax.swing.JTable();
        labelpendapatan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pendapatanmingguan = new javax.swing.JLabel();
        fieldpendapatanbulan = new javax.swing.JLabel();
        fieldpendapatantahun = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        pengeluaranperhari = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butonlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(butonlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 20, 140, 60));

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
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 320, 50));

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 320, 50));

        pengeluaran.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pengeluaran.setText(" ");
        getContentPane().add(pengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 270, 140, 40));

        pendapatanminggu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pendapatanminggu.setModel(new javax.swing.table.DefaultTableModel(
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
        pendapatanminggu.setRowHeight(25);
        jScrollPane1.setViewportView(pendapatanminggu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 570, 140));

        pendapatanbulan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pendapatanbulan.setModel(new javax.swing.table.DefaultTableModel(
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
        pendapatanbulan.setRowHeight(25);
        jScrollPane2.setViewportView(pendapatanbulan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 670, 570, 140));

        pendapatantahun.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pendapatantahun.setModel(new javax.swing.table.DefaultTableModel(
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
        pendapatantahun.setRowHeight(25);
        jScrollPane3.setViewportView(pendapatantahun);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 850, 570, 140));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Pendapatan Per Minggu ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));

        pengeluaranmingguan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pengeluaranmingguan.setModel(new javax.swing.table.DefaultTableModel(
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
        pengeluaranmingguan.setPreferredSize(new java.awt.Dimension(300, 100));
        pengeluaranmingguan.setRowHeight(25);
        jScrollPane4.setViewportView(pengeluaranmingguan);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 490, 570, 140));

        pengeluaranbulan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pengeluaranbulan.setModel(new javax.swing.table.DefaultTableModel(
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
        pengeluaranbulan.setPreferredSize(new java.awt.Dimension(300, 100));
        pengeluaranbulan.setRowHeight(25);
        jScrollPane5.setViewportView(pengeluaranbulan);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 670, 570, 140));

        pengeluarantahun.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pengeluarantahun.setModel(new javax.swing.table.DefaultTableModel(
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
        pengeluarantahun.setGridColor(new java.awt.Color(102, 102, 255));
        pengeluarantahun.setPreferredSize(new java.awt.Dimension(300, 100));
        pengeluarantahun.setRowHeight(25);
        jScrollPane6.setViewportView(pengeluarantahun);

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 850, 570, 140));

        pendapatanharian.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pendapatanharian.setModel(new javax.swing.table.DefaultTableModel(
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
        pendapatanharian.setRowHeight(25);
        jScrollPane7.setViewportView(pendapatanharian);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 570, 140));

        labelpendapatan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        labelpendapatan.setText(" ");
        getContentPane().add(labelpendapatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 160, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Pendapatan Per Bulan ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 640, -1, -1));

        pendapatanmingguan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pendapatanmingguan.setText(" ");
        getContentPane().add(pendapatanmingguan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 210, -1));

        fieldpendapatanbulan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fieldpendapatanbulan.setText(" ");
        getContentPane().add(fieldpendapatanbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 640, 210, -1));

        fieldpendapatantahun.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fieldpendapatantahun.setText(" ");
        getContentPane().add(fieldpendapatantahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 820, 230, -1));

        pengeluaranperhari.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pengeluaranperhari.setModel(new javax.swing.table.DefaultTableModel(
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
        pengeluaranperhari.setRowHeight(25);
        jScrollPane8.setViewportView(pengeluaranperhari);

        getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 310, 570, 140));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Pendapatan Per Tahun");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 820, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Pendapatan Hari Ini =");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Pengeluaran Hari ini =");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 280, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Pengeluaran Per Minggu");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 460, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Pengeluaran Per Bulan");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 640, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Pengeluaran Per Tahun");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 820, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/DASBOARD.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void tampildata() {
    try{
            String sql = "SELECT SUM(total_harga) AS pendapatanharini FROM tbl_penjualan WHERE waktu_penjualan >= DATE(NOW()) GROUP BY waktu_penjualan;";
             Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            if(r.next()) {
                String pendapatan = r.getString("pendapatanharini");
                this.labelpendapatan.setText(pendapatan);
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
    try{
            String sql = "SELECT SUM(total_hargabarangbelii) AS pengeluaranharini FROM tbl_pembelian WHERE waktu_beli >= DATE(NOW()) GROUP BY waktu_beli;";
             Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            if(r.next()) {
                String pengeluaran = r.getString("pengeluaranharini");
                this.pengeluaran.setText(pengeluaran);
                
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
//    try{
//            String sql = "SELECT SUM(total_harga) AS MINGGU FROM tbl_penjualan WHERE waktu_penjualan >= WEEK(NOW()) GROUP BY WEEK(NOW());";
//             Connection c = (Connection) koneksi.configDB();
//            Statement s = c.createStatement();
//            ResultSet r = s.executeQuery(sql);
//            
//            if(r.next()) {
//                String pengeluaran = r.getString("MINGGU");
//                this.pendapatanmingguan.setText(pengeluaran);
//                
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
//        }
//     try{
//            String sql = "SELECT SUM(total_harga) AS BULAN FROM tbl_penjualan WHERE waktu_penjualan >= MONTH(NOW()) GROUP BY MONTH(NOW());";
//             Connection c = (Connection) koneksi.configDB();
//            Statement s = c.createStatement();
//            ResultSet r = s.executeQuery(sql);
//            
//            if(r.next()) {
//                String pengeluaran = r.getString("BULAN");
//                this.fieldpendapatanbulan.setText(pengeluaran);
//                
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
//        }
//      try{
//            String sql = "SELECT SUM(total_harga) AS pendapatantahun FROM tbl_penjualan WHERE waktu_penjualan >= YEAR(NOW()) GROUP BY YEAR(NOW());";
//             Connection c = (Connection) koneksi.configDB();
//            Statement s = c.createStatement();
//            ResultSet r = s.executeQuery(sql);
//            
//            if(r.next()) {
//                String pengeluaran = r.getString("pendapatantahun");
//                this.fieldpendapatantahun.setText(pengeluaran);
//                
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
//        }
   
}
   
    private void pendapatanhari() {
        String[] columnNames = {"Total Pengeluaran", "Tanggal "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_harga), CONCAT(DATE(waktu_penjualan)) AS HARIAN FROM tbl_penjualan GROUP BY CONCAT(DATE(waktu_penjualan));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_harga)"),
                        mingguke = rs.getString("HARIAN");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pendapatanharian.setModel(tablemodel);
    }
    private void pendapatanminggu() {
        String[] columnNames = {"Total Pendapatan", "Minggu Ke "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_harga), CONCAT(WEEK(waktu_penjualan)) AS MINGGU FROM tbl_penjualan GROUP BY CONCAT(WEEK(waktu_penjualan));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_harga)"),
                        mingguke = rs.getString("MINGGU");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pendapatanminggu.setModel(tablemodel);
    }
    private void pendapatanBULAN() {
        String[] columnNames = {"Total Pendapatan", "Bulan Ke "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_harga), CONCAT(MONTH(waktu_penjualan)) AS BULAN FROM tbl_penjualan GROUP BY CONCAT(MONTH(waktu_penjualan));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_harga)"),
                        mingguke = rs.getString("BULAN");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pendapatanbulan.setModel(tablemodel);
    }
     private void pendapatanTAHUN() {
        String[] columnNames = {"Total Pendapatan", "Tahun "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_harga), CONCAT(YEAR(waktu_penjualan)) AS TAHUN FROM tbl_penjualan GROUP BY CONCAT(YEAR(waktu_penjualan));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_harga)"),
                        mingguke = rs.getString("TAHUN");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pendapatantahun.setModel(tablemodel);
    }
     private void pengeluaranhari() {
        String[] columnNames = {"Total Pengeluaran", "Tanggal "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_hargabarangbelii), CONCAT(DATE(waktu_beli)) AS HARIAN FROM tbl_pembelian GROUP BY CONCAT(DATE(waktu_beli));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_hargabarangbelii)"),
                        mingguke = rs.getString("HARIAN");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pengeluaranperhari.setModel(tablemodel);
    }
     private void pengeluaranminggu() {
        String[] columnNames = {"Total Pengeluaran", "Minggu ke "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_hargabarangbelii), CONCAT(WEEK(waktu_beli)) AS MINGGU FROM tbl_pembelian GROUP BY CONCAT(WEEK(waktu_beli));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_hargabarangbelii)"),
                        mingguke = rs.getString("MINGGU");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pengeluaranmingguan.setModel(tablemodel);
    }
     private void pengeluaranbulan() {
        String[] columnNames = {"Total Pengeluaran", "Bulan Ke "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_hargabarangbelii), CONCAT(MONTH(waktu_beli)) AS BULAN FROM tbl_pembelian GROUP BY CONCAT(MONTH(waktu_beli));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_hargabarangbelii)"),
                        mingguke = rs.getString("BULAN");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pengeluaranbulan.setModel(tablemodel);
    }
      private void pengeluarantahun() {
        String[] columnNames = {"Total Pengeluaran", "Tahun "};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT SUM(total_hargabarangbelii), CONCAT(YEAR(waktu_beli)) AS TAHUN FROM tbl_pembelian GROUP BY CONCAT(YEAR(waktu_beli));");

            while (rs.next()) {
                String totalpen = rs.getString("SUM(total_hargabarangbelii)"),
                        mingguke = rs.getString("TAHUN");
                        

                // create a single array of one rows worth of data
                String[] data = {totalpen, mingguke};
                tablemodel.addRow(data);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage());
        }
        this.pengeluarantahun.setModel(tablemodel);
    }
     
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

    private void butonlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonlogoutActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin logout?", "confirm", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(res == JOptionPane.YES_OPTION){
            JFramelogin l = new JFramelogin();
            l.setVisible(true);
        }
    }//GEN-LAST:event_butonlogoutActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonlogout;
    private javax.swing.JLabel fieldpendapatanbulan;
    private javax.swing.JLabel fieldpendapatantahun;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel labelpendapatan;
    private javax.swing.JTable pendapatanbulan;
    private javax.swing.JTable pendapatanharian;
    private javax.swing.JTable pendapatanminggu;
    private javax.swing.JLabel pendapatanmingguan;
    private javax.swing.JTable pendapatantahun;
    private javax.swing.JLabel pengeluaran;
    private javax.swing.JTable pengeluaranbulan;
    private javax.swing.JTable pengeluaranmingguan;
    private javax.swing.JTable pengeluaranperhari;
    private javax.swing.JTable pengeluarantahun;
    // End of variables declaration//GEN-END:variables
}
