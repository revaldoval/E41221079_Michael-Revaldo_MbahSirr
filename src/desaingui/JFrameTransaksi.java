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
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class JFrameTransaksi extends javax.swing.JFrame {
    private int total_harga = 0;
    private void listgay() {
        try {
            String sql = "SELECT * From tbl_karyawan ";
            Connection conn = (Connection) koneksi.configDB();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet res = pst.executeQuery(sql);

            while (res.next()) {
                pillihkaryawan.addItem( res.getString("kd_karyawan") +" " +  res.getString("nama_karyawan"));

            }

        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }

    private String idMenuSelected = "", namaMenu, hargaMenu, jenisMenu;

    private int jumlah // jumlah menu yg dipilih
            , ttlHrgMenu // total harga dari menu (harga menu * jumlah menu)
            , ttlHargaBayar = 0; // total keseluruhan harga dari menu

    private DefaultTableModel tblModel;
    private Object[][] dataPenjualan = new Object[1][6];
    String harga;

    /**
     * Creates new form JFrameTransaksi
     */
    public JFrameTransaksi() {
        initComponents();
        txtTotalHarga.setText(Integer.toString(total_harga));
        txtJumlah.setText("0");
        this.jButton1.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton2.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton3.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton4.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton5.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButton6.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.btnTambahdata.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.btnHapus_penjualan.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.btnUbah.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.btnKonfirmasi.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butontranbeli.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butontranjual.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.txtPenjualan.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.txtProduk.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.txtNama_produk.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.txtJumlah.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.pillihkaryawan.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.butonkembali.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jTextFieldcari.setBackground(new java.awt.Color(0, 0, 0, 0));
        this.jButtoncari.setBackground(new java.awt.Color(0, 0, 0, 0));
        
        this.jTablebarang.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        this.jTablepenjualan.getTableHeader().setFont(new java.awt.Font("Tahoma",0,16));
        listgay();

// setting tabel model
        tblModel = new DefaultTableModel(
                new String[][]{}, // default valuenya kosong
                new String[]{
                    "kd penjualan","kd karyawan", "kd produk", "nama produk", "harga", "jumlah", "total"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        this.updateTableBarang();
        this.txtPenjualan.setText(this.createkd());
        
    }

     public String createkd(){
        try{
            // menyiapkan query untuk mendapatkan id terakhir
            String query = "SELECT * FROM tbl_penjualan ORDER BY kd_penjualan DESC LIMIT 0,1", lastID, kd_penjualan;
            Connection conn = (Connection) koneksi.configDB();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            // cek apakah query berhasil dieksekusi
            if(res.next()){
                // mendapatkan id terakhir
                lastID =  res.getString("kd_penjualan");
                if(lastID != null){
                    // mendapatkan nomor id
                    kd_penjualan = lastID.substring(2);
                }else{
                    kd_penjualan= "KP000";
                }
                // jika id barang belum exist maka id akan dibuat
                return String.format("KP%04d", Integer.parseInt(kd_penjualan)+1);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    private void updateTableBarang() {
        String[] columnNames = {"KD Produk", "Nama Produk", "Harga", "Stok",};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);

        try {
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT kd_barang, nama_barang, harga_barang, stok_barang FROM tbl_barang");

            while (rs.next()) {
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
        this.jTablebarang.setModel(tablemodel);
    }



    private String idSelected;

    private void showData() {
        try {
            this.idSelected = this.jTablebarang.getValueAt(this.jTablebarang.getSelectedRow(), 0).toString();
            System.out.println(idSelected);
            String sql = "SELECT * FROM tbl_barang WHERE kd_barang = '" + this.idSelected + "'";
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            // get data
            if (r.next()) {
                String nama_produk = r.getString("nama_barang"),
                        harga = r.getString("harga_barang"),
                        stok = r.getString("stok_barang");
                this.harga = harga;
                // menampilkan data
//                this.jTextField2kdproduk.setText(this.idSelected);
//                this.jTextFieldnamaproduk.setText(nama_produk);
//                this.jTextFieldhargaproduk.setText(harga);
//                this.jTextField5stokproduk.setText(stok);
                this.txtProduk.setText(this.idSelected);
                this.txtNama_produk.setText(nama_produk);
//                this.txtJumlah.setText(harga);
//                this.txtPenjualan.setText(this.idSelected);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
    }
    private void showData1() {
        try {
            this.idSelected = this.jTablepenjualan.getValueAt(this.jTablepenjualan.getSelectedRow(), 0).toString();
            System.out.println(idSelected);
            String sql = "SELECT * FROM tbl_barang WHERE kd_barang = '" + this.idSelected + "'";
            Connection c = (Connection) koneksi.configDB();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            // get data
            if (r.next()) {
                String nama_produk = r.getString("nama_barang"),
                        harga = r.getString("harga_barang"),
                        stok = r.getString("stok_barang");
                this.harga = harga;
                // menampilkan data
//                this.jTextField2kdproduk.setText(this.idSelected);
//                this.jTextFieldnamaproduk.setText(nama_produk);
//                this.jTextFieldhargaproduk.setText(harga);
//                this.jTextField5stokproduk.setText(stok);
                this.txtProduk.setText(this.idSelected);
                this.txtNama_produk.setText(nama_produk);
//                this.txtJumlah.setText(harga);
//                this.txtPenjualan.setText(this.idSelected);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
    }

    private void updateTabel() {

        // cek apakah data sudah ada didalam tabel atau tidak
        for (int i = 0; i < this.tblModel.getRowCount(); i++) {
            if (this.txtProduk.getText().equals(String.valueOf(this.jTablepenjualan.getValueAt(i, 1)))) {
                // nanti dulu
                this.jumlah += Integer.parseInt(String.valueOf(this.jTablepenjualan.getValueAt(i, 5)));
            }
        }

        DefaultTableModel model = (DefaultTableModel) jTablepenjualan.getModel();

        boolean noMerge = true;
        int jmlLama, jmlBaru;
        /**
         * Mengecek apakah data nama menu yang dipilih sudah ada atau belum
         * didalam tabel transaksi yang ada di window Jika sudah ada maka data
         * jumlah pada tabel transaksi akan diupdate dan tidak membuat baris
         * baru pada tabel Jika belum maka data nama menu akan ditambahkan pada
         * baris baru pada tabel
         */
        if (jTablepenjualan.getRowCount() >= 1) {
//             membaca isi tabel transaksi
            for (int i = 0; i < model.getRowCount(); i++) {
                // mendapatkan data nama menu dari tabel
                String name = model.getValueAt(i, 0).toString();
                System.out.println("name " +name);
                System.out.println("name " +name);
                // jika nama menu sudah ada didalam tabel, maka akan mengupdate data jumlah yang ada didalam tabel transaksi
                if (name.equalsIgnoreCase(this.namaMenu)) {
                    noMerge = false;
                    // mendapatkan data jumlah menu yang dipesan
                    jmlLama = Integer.parseInt((String) model.getValueAt(i, 5));
                    // mengupdate data jumlah menu yang dipesan
                    jmlBaru = jmlLama + Integer.parseInt(this.txtJumlah.getText());

                    // update data jumlah yang ada didalam tabel
                    model.setValueAt(Integer.toString(jmlBaru), i, 5);
                    String total = Integer.toString(jmlBaru * Integer.parseInt(hargaMenu));
                    model.setValueAt(total, i, 6);
                }

            }
        }
        
        this.ttlHrgMenu  = Integer.parseInt(this.txtJumlah.getText()) * Integer.parseInt(this.jTablebarang.getValueAt(this.jTablebarang.getSelectedRow(), 2).toString());
        this.total_harga += ttlHrgMenu;
        // jika nama menu belum ada didalam tabel maka nama menu akan ditambahkan pada baris baru
        String karyawan = (String) this.pillihkaryawan.getSelectedItem();
        String karyawan1[] = karyawan.split(" ");
        String data1 = karyawan1[0],data2 = karyawan1[1];
        int jumlah = Integer.parseInt(txtJumlah.getText());
        if(jumlah<1){
            JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            return;
        }
        if (noMerge) {
            //update table
            model.addRow(new Object[]{
//                this.txtPenjualan.getText(),
                this.txtPenjualan.getText(),
                data2,
//                this.idMenuSelected,
                this.txtProduk.getText(),
//                this.namaMenu,
                this.txtNama_produk.getText(),
//                this.jenisMenu,
                this.jTablebarang.getValueAt(this.jTablebarang.getSelectedRow(), 2),
//                this.txtJumlah.getText(),
                jumlah,
                this.ttlHrgMenu
            });
        }
        jTablepenjualan.setModel(model);
        txtTotalHarga.setText(Integer.toString(total_harga));
    }
    
    private void updateHarga(){
        int harga = 0;
        for(int i = 0; i < this.jTablepenjualan.getRowCount(); i++){
            harga = Integer.parseInt(this.jTablepenjualan.getValueAt(i, 6).toString());
        }
        this.txtTotalHarga.setText(""+harga);
    }
    
    private void editTabel() {

        // cek apakah data sudah ada didalam tabel atau tidak
        for (int i = 0; i < this.tblModel.getRowCount(); i++) {
            if (this.txtProduk.getText().equals(String.valueOf(this.jTablepenjualan.getValueAt(i, 1)))) {
                // nanti dulu
                this.jumlah += Integer.parseInt(String.valueOf(this.jTablepenjualan.getValueAt(i, 5)));
            }
        }

        DefaultTableModel model = (DefaultTableModel) jTablepenjualan.getModel();

        boolean noMerge = true;
        int jmlLama, jmlBaru;
        /**
         * Mengecek apakah data nama menu yang dipilih sudah ada atau belum
         * didalam tabel transaksi yang ada di window Jika sudah ada maka data
         * jumlah pada tabel transaksi akan diupdate dan tidak membuat baris
         * baru pada tabel Jika belum maka data nama menu akan ditambahkan pada
         * baris baru pada tabel
         */
        if (jTablepenjualan.getRowCount() >= 1) {
//             membaca isi tabel transaksi
            for (int i = 0; i < model.getRowCount(); i++) {
                // mendapatkan data nama menu dari tabel
                String name = model.getValueAt(i, 0).toString();
                System.out.println("name " +name);
                System.out.println("name " +name);
                // jika nama menu sudah ada didalam tabel, maka akan mengupdate data jumlah yang ada didalam tabel transaksi
                if (name.equalsIgnoreCase(this.namaMenu)) {
                    noMerge = false;
                    // mendapatkan data jumlah menu yang dipesan
                    jmlLama = Integer.parseInt((String) model.getValueAt(i, 5));
                    // mengupdate data jumlah menu yang dipesan
                    jmlBaru = jmlLama + Integer.parseInt(this.txtJumlah.getText());

                    // update data jumlah yang ada didalam tabel
                    model.setValueAt(Integer.toString(jmlBaru), i, 5);
                    String total = Integer.toString(jmlBaru * Integer.parseInt(hargaMenu));
                    model.setValueAt(total, i, 6);
                }

            }
        }
        
        this.ttlHrgMenu  = Integer.parseInt(this.txtJumlah.getText()) * Integer.parseInt(this.jTablebarang.getValueAt(this.jTablebarang.getSelectedRow(), 2).toString());
        this.total_harga += ttlHrgMenu;
        // jika nama menu belum ada didalam tabel maka nama menu akan ditambahkan pada baris baru
        String karyawan = (String) this.pillihkaryawan.getSelectedItem();
        String karyawan1[] = karyawan.split(" ");
        String data1 = karyawan1[0],data2 = karyawan1[1];
        int jumlah = Integer.parseInt(txtJumlah.getText());
        if(jumlah<1){
            JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong");
            return;
        }
        if (noMerge) {

//            model.addRow(new Object[]{
////                this.txtPenjualan.getText(),
//                this.txtPenjualan.getText(),
//                data2,
////                this.idMenuSelected,
//                this.txtProduk.getText(),
////                this.namaMenu,
//                this.txtNama_produk.getText(),
////                this.jenisMenu,
//                this.jTablebarang.getValueAt(this.jTablebarang.getSelectedRow(), 2),
////                this.txtJumlah.getText(),
//                jumlah,
//                this.ttlHrgMenu
//            });
        }
        jTablepenjualan.setModel(model);
        txtTotalHarga.setText(Integer.toString(total_harga));
    }

    private void tambahDataMenu() {
        // update data total harga
        this.jumlah = Integer.parseInt(this.txtJumlah.getText());
        this.ttlHrgMenu = Integer.parseInt(this.hargaMenu) * jumlah;
        this.ttlHargaBayar += this.ttlHrgMenu;
        this.txtTotalHarga.setText(""+ttlHargaBayar);
        // reset tabel dan textfield
        this.updateTabel();
//        this.resetTambah();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtPenjualan = new javax.swing.JTextField();
        txtProduk = new javax.swing.JTextField();
        txtNama_produk = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        btnTambahdata = new javax.swing.JButton();
        btnHapus_penjualan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        butontranbeli = new javax.swing.JButton();
        jButtoncari = new javax.swing.JButton();
        btnKonfirmasi = new javax.swing.JButton();
        jTextFieldcari = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablebarang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablepenjualan = new javax.swing.JTable();
        pillihkaryawan = new javax.swing.JComboBox();
        butonkembali = new javax.swing.JButton();
        butontranjual = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtPenjualan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtPenjualan.setBorder(null);
        txtPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(txtPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 400, 50));

        txtProduk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtProduk.setBorder(null);
        txtProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdukActionPerformed(evt);
            }
        });
        getContentPane().add(txtProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 400, 50));

        txtNama_produk.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtNama_produk.setBorder(null);
        getContentPane().add(txtNama_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 400, 50));

        txtJumlah.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtJumlah.setBorder(null);
        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        getContentPane().add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 400, 50));

        btnTambahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahdataActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambahdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 210, 50));

        btnHapus_penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapus_penjualanActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus_penjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, 210, 50));

        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        getContentPane().add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 210, 50));

        butontranbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butontranbeliActionPerformed(evt);
            }
        });
        getContentPane().add(butontranbeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 110, 320, 60));

        jButtoncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncariActionPerformed(evt);
            }
        });
        getContentPane().add(jButtoncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1800, 229, 50, 30));

        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });
        getContentPane().add(btnKonfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 960, 570, 90));

        jTextFieldcari.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextFieldcari.setBorder(null);
        jTextFieldcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldcariActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 226, 430, 30));

        txtTotalHarga.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        getContentPane().add(txtTotalHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 940, 340, 80));

        jTablebarang.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTablebarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablebarang.setRowHeight(25);
        jTablebarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablebarangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTablebarangMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTablebarang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 280, 660, 380));

        jTablepenjualan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTablepenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "kd penjualan", "kd karyawan", "kd produk", "nama produk", "harga", "jumlah", "total"
            }
        ));
        jTablepenjualan.setRowHeight(25);
        jTablepenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablepenjualanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablepenjualan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 670, 1360, 260));

        pillihkaryawan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pillihkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pillihkaryawanActionPerformed(evt);
            }
        });
        getContentPane().add(pillihkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 400, 50));

        butonkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(butonkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1813, 20, 70, 70));

        butontranjual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butontranjualActionPerformed(evt);
            }
        });
        getContentPane().add(butontranjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 110, 320, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/TRANSAKSI.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new JFrameKaryawan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void jTablebarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablebarangMouseClicked
        this.showData();
        
//                this.txtPenjualan.getText(),
//                this.idMenuSelected,
//                this.namaMenu,
//                this.jenisMenu,
//                this.hargaMenu,
//                this.txtJumlah.getText(),
//                this.ttlHrgMenu
    }//GEN-LAST:event_jTablebarangMouseClicked

    private void btnTambahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahdataActionPerformed
//        // TODO add your handling code here:
//        String kd_penjualan = txtPenjualan.getText();
//        String kd_produk = txtProduk.getText();
//        String nama_produk = txtNama_produk.getText();
//        int jumlah = Integer.parseInt(txtJumlah.getText());
//        int total = Integer.parseInt(harga) + jumlah;
////        System.out.println(dataPenjualan);
//        int panjang = dataPenjualan.length;
//        System.out.println(kd_penjualan);
//        dataPenjualan[panjang][0] = kd_penjualan;
//        dataPenjualan[panjang][1] = kd_produk;
//        dataPenjualan[panjang][2] = nama_produk;
//        dataPenjualan[panjang][3] = harga;
//        dataPenjualan[panjang][4] = jumlah;
//        dataPenjualan[panjang][5] = total;
//        ArrayList t = new ArrayList(Arrays.asList(dataPenjualan));
//        t.add(panjang++);
//        dataPenjualan = (Object[][]) t.toArray(dataPenjualan);
////        System.out.println("panjang data "+panjang);
//        updateTable1();
        
//        this.tambahDataMenu();
        this.updateTabel();
    }//GEN-LAST:event_btnTambahdataActionPerformed

    private void txtProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdukActionPerformed

    private int getJumlahBarang(){
        int index = 0;
        for(int i = 0; i < this.jTablepenjualan.getRowCount(); i++){
            index += Integer.parseInt(this.jTablepenjualan.getValueAt(i, 5).toString());
        }
        return index;
    }
    
    private int getTotalHarga(){
        int index = 0;
        for(int i = 0; i < this.jTablepenjualan.getRowCount(); i++){
            index += Integer.parseInt(this.jTablepenjualan.getValueAt(i, 6).toString());
        }
        return index;
    }
    
    private boolean tfPenjualan(){
        try {
            Connection c = (Connection) koneksi.configDB();
            PreparedStatement p = c.prepareStatement("INSERT INTO tbl_penjualan (kd_penjualan, kd_karyawan, total_barang, total_harga)VALUES (?, ?, ?, ?)");
            p.setString(1, this.txtPenjualan.getText());
            p.setString(2, this.pillihkaryawan.getSelectedItem().toString().substring(0, 6));
            p.setInt(3, this.getJumlahBarang());
            p.setInt(4, this.getTotalHarga());
           
            
            return p.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
        }
        return false;
    }
    
    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        if(this.tfPenjualan()){
            try {
                for(int i = 0; i < this.jTablepenjualan.getRowCount(); i++){
                    Connection c = (Connection) koneksi.configDB();
                    PreparedStatement p = c.prepareStatement("INSERT INTO detail_jualbarang VALUES (?, ?, ?, ?)");
                    p.setString(1, this.txtPenjualan.getText());
                    p.setString(2, this.jTablepenjualan.getValueAt(i, 2).toString());
                    p.setString(3, this.jTablepenjualan.getValueAt(i, 5).toString());
                    p.setString(4, this.jTablepenjualan.getValueAt(i, 6).toString());
                    p.executeUpdate();
                }
                JOptionPane.showMessageDialog(this, "Transaksi Berhasil!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "error : " + ex.getMessage());
            }
        }
        this.updateTableBarang();
    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    
    private void jTablebarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablebarangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablebarangMouseEntered

    private void jTablepenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablepenjualanMouseClicked
        this.showData1();
    }//GEN-LAST:event_jTablepenjualanMouseClicked

    private void btnHapus_penjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapus_penjualanActionPerformed
        // TODO add your handling code here:
         if(this.jTablepenjualan.getSelectedRow() > -1){
            
            
           
            DefaultTableModel model = (DefaultTableModel) jTablepenjualan.getModel();
            int row = jTablepenjualan.getSelectedRow();
            model.removeRow(row);            
            this.updateHarga();
        }else{
           
        }
    }//GEN-LAST:event_btnHapus_penjualanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
//        this.editTabel();
        new JFrameTransaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUbahActionPerformed

    private void pillihkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pillihkaryawanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pillihkaryawanActionPerformed

    private void jButtoncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncariActionPerformed
        // TODO add your handling code here:
         String[] columnNames = {"kd_produk", "nama_produk", "harga", "stok"};
        DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
        try {
            String findBarang = this.jTextFieldcari.getText();
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
        this.jTablebarang.setModel(tablemodel);
    }//GEN-LAST:event_jButtoncariActionPerformed

    private void txtPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenjualanActionPerformed

    private void butontranbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butontranbeliActionPerformed
        // TODO add your handling code here:
        new JFramepembelian().setVisible(true);
        dispose();
    }//GEN-LAST:event_butontranbeliActionPerformed

    private void jTextFieldcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcariActionPerformed

    private void butonkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonkembaliActionPerformed
        // TODO add your handling code here:
        new JFrameDashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_butonkembaliActionPerformed

    private void butontranjualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butontranjualActionPerformed
        // TODO add your handling code here:
        new JFrameTransaksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_butontranjualActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus_penjualan;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JButton btnTambahdata;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton butonkembali;
    private javax.swing.JButton butontranbeli;
    private javax.swing.JButton butontranjual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtoncari;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablebarang;
    private javax.swing.JTable jTablepenjualan;
    private javax.swing.JTextField jTextFieldcari;
    private javax.swing.JComboBox pillihkaryawan;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNama_produk;
    private javax.swing.JTextField txtPenjualan;
    private javax.swing.JTextField txtProduk;
    private javax.swing.JLabel txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
