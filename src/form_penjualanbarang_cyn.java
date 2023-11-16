import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.awt.event.ActionEvent; 
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author smki
 */
public class form_penjualanbarang_cyn extends javax.swing.JFrame {
    private DefaultTableModel model;
    String data[] = new String[6];
    /**
     * Creates new form form_penjualanbarang_cyn
     */
    public form_penjualanbarang_cyn() {
        initComponents();
        model = (DefaultTableModel) tb_dtbrg.getModel();
        DefaultTableModel tb_dtbrg = new DefaultTableModel();
        loadData();
        SetEditOff();
        tampilcombo();
        petugas();
        Tampil_Tanggal();
        nofaktur();
        Date date = new Date();
    }
   
    
    public void Tampil_Tanggal() {
        Date date = new Date();
        
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
        String tanggal = smpdtfmt.format(tglsekarang);
        txttgl.setText(tanggal);
    }
    
    public void SetEditOff(){
        txtnofak.setEnabled(false); 
        txttgl.setEnabled(false); 
        cmbptgs.setEnabled(false); 
        cmbkd.setEnabled(false); 
        txtjmlh.setEnabled(false); 
        jButton2.setEnabled(false); 
        //btncaridata.setEnabled(false); 
        btntambah.setEnabled(false);
        txtbrg.setEnabled(false);
        txthrg.setEnabled(false);
        txtstok.setEnabled(false);
        txtjmlh.setEnabled(false);
        btnsave.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        txtbayar.setEnabled(false);
        txtsisa.setEnabled(false);
    }
    
    public void SetEditOn(){
        txtnofak.setEnabled(true); 
        txttgl.setEnabled(true); 
        cmbptgs.setEnabled(true); 
        cmbkd.setEnabled(true); 
        txtjmlh.setEnabled(true); 
        jButton2.setEnabled(true); 
        //btncaridata.setEnabled(false); 
        btntambah.setEnabled(true);
        txtbrg.setEnabled(true);
        txthrg.setEnabled(true);
        txtstok.setEnabled(true);
        txtjmlh.setEnabled(true);
        btnsave.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        txtbayar.setEnabled(true);
        txtsisa.setEnabled(true);
    }
        
    public void nofaktur() {
    Date sk = new Date();
    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
    String time = format1.format(sk);
    try {
        String sql = "select right(nofaktur, 1) as LastDigit from tblpenjualan order by nofaktur desc";

        Connection c = koneksi.getKoneksi();
        PreparedStatement p = c.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            int lastDigit = Integer.parseInt(rs.getString("LastDigit")) + 1;
            txtnofak.setText(time + Integer.toString(lastDigit));
        } else {
            int kode = 1;
            txtnofak.setText(time + Integer.toString(kode));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public void tampilcombo(){
        try{
            String sql = "SELECT * FROM tblbarang";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                cmbkd.addItem(r.getString("KodeBarang"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void petugas(){
        try{
            String sql = "SELECT * FROM tblpetugas";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                cmbptgs.addItem(r.getString("IDPetugas"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
   
    private void totalbayar(){
        int a;
        int b = 0;
        double c;
        
        a = Integer.parseInt(txthrg.getText().toString());
        b = Integer.parseInt(txtjmlh.getText().toString());
        c = a * b;
        jTextField1.setText(String.valueOf(c));
    }
    private void loadData() {
    model = new DefaultTableModel();
    model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
    tb_dtbrg.setModel(model);

    model.addColumn("Kode Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga Jual");
    model.addColumn("Stok");
    model.addColumn("Jumlah");
    model.addColumn("Sub Total");

    try {
        String sql = "SELECT tbldetailpenjualan.NoFaktur, tbldetailpenjualan.KodeBarang, tbldetailpenjualan.Jumlah, tbldetailpenjualan.SubTotal, " +
            "tblbarang.NamaBarang, tblbarang.HargaJual, tblbarang.Stok " +
            "FROM tbldetailpenjualan " +
            "INNER JOIN tblbarang ON tbldetailpenjualan.KodeBarang = tblbarang.KodeBarang " +
            "WHERE tbldetailpenjualan.NoFaktur = '" + txtnofak.getText() + "'";

        Connection kon = koneksi.getKoneksi();
        Statement s = kon.createStatement();
       // preparedStatement.setString(1, txtnofak.getText());

        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            String nofak = rs.getString("NoFaktur");
            String kodeBarang = rs.getString("KodeBarang");
            String namaBarang = rs.getString("NamaBarang");
            String hargaJual = rs.getString("HargaJual");
            String stok = rs.getString("Stok");
            String jumlah = rs.getString("Jumlah");
            String subtotal = rs.getString("SubTotal");

            model.addRow(new Object[]{nofak, kodeBarang, namaBarang, hargaJual, stok, jumlah, subtotal});
        }

        rs.close();
        s.close();
       // kon.close();
    } catch (SQLException ex) {
        System.out.println("Terjadi Error: " + ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnofak = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbptgs = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtptgs = new javax.swing.JTextField();
        txttgl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbkd = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtbrg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txthrg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtjmlh = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_dtbrg = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtsisa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtbayar = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No Faktur");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 22, -1, -1));

        txtnofak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnofakActionPerformed(evt);
            }
        });
        jPanel1.add(txtnofak, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 19, 85, -1));

        jLabel2.setText("Id Petugas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 63, -1, -1));

        cmbptgs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- pilih id petugas --" }));
        cmbptgs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbptgsItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbptgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 60, 171, -1));

        jLabel3.setText("Nama Petugas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 63, -1, -1));

        txtptgs.setEnabled(false);
        jPanel1.add(txtptgs, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 60, 402, -1));

        txttgl.setEnabled(false);
        txttgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttglActionPerformed(evt);
            }
        });
        jPanel1.add(txttgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 19, 129, -1));

        jLabel4.setText("Tanggal Penjualan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 22, 106, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Kode Barang");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 38, 78, -1));

        cmbkd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- pilih kode barang --" }));
        cmbkd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbkdItemStateChanged(evt);
            }
        });
        cmbkd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkdActionPerformed(evt);
            }
        });
        jPanel2.add(cmbkd, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 160, -1));

        jLabel6.setText("Nama Barang");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 38, -1, -1));
        jPanel2.add(txtbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 35, 192, -1));

        jLabel7.setText("Harga Jual");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 78, 73, -1));
        jPanel2.add(txthrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 75, 137, -1));

        jLabel8.setText("Stok");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 122, 37, -1));
        jPanel2.add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 119, 89, -1));

        jLabel9.setText("Jumlah");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 161, -1, -1));
        jPanel2.add(txtjmlh, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 158, 90, -1));

        jButton2.setText("Hitung");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jLabel10.setText("Sub Total Rp");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, 20));

        txttotal.setText("0");
        txttotal.setEnabled(false);
        jPanel2.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 158, 160, -1));

        btntambah.setText("Add Item");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel2.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 780, 230));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Grid Data Barang"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_dtbrg.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_dtbrg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tb_dtbrg);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 740, 150));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 781, 200));

        jButton4.setText("Add New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        btnsave.setText("Save Transaction ");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 140, -1));

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, -1, -1));

        jButton7.setText("Close");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, -1, -1));

        jLabel11.setText("Bayar Rp");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, -1, -1));

        jLabel12.setText("Sisa Rp");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        txtsisa.setEnabled(false);
        jPanel1.add(txtsisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 610, 190, -1));

        jLabel14.setText("Total Rp");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, -1, -1));

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        jPanel1.add(txtbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, 190, -1));

        jTextField1.setEnabled(false);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        String NM=txtnofak.getText();
        String KB=cmbkd.getSelectedItem().toString();
        String JM=txtjmlh.getText();
        
        totalbayar();
        if ((NM.isEmpty()) | (KB.isEmpty()) |(JM.isEmpty())) {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
        }else {
            try{
                
                Connection kon = koneksi.getKoneksi();
                Statement stt = kon.createStatement();
                String SQL = "insert into tbldetailpenjualan values('"+txtnofak.getText()+"',"+
                "'"+cmbkd.getSelectedItem()+"',"+
                "'"+txtjmlh.getText()+"',"+
                "'"+txttotal.getText()+"')";
                stt.executeUpdate(SQL);
               
                Connection kon1 = koneksi.getKoneksi();
                Statement stt1 = kon.createStatement();
                String SQL1 = "Update tblbarang Set stok=stok - '"+txtjmlh.getText()+"'" +
                "Where kodebarang='"+cmbkd.getSelectedItem().toString()+"'";
                stt1.executeUpdate(SQL1);
               
                data[0] = cmbkd.getSelectedItem().toString();
                data[1] = txtbrg.getText();
                data[2] = txthrg.getText();
                data[3] = txtstok.getText();
                data[4] = txtjmlh.getText();
                data[5] = txttotal.getText();
                model.insertRow(0, data);
                
                totalbayar();
        
                cmbkd.requestFocus();
        
                stt.close();
                cmbkd.requestFocus();
                btntambah.setEnabled(false);
                btnsave.setEnabled(true);
                bersih();
                cmbkd.requestFocus();
                
            } catch(Exception ex){
                 System.out.println("Terjadi Error"+ex.getMessage());
            }
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void cmbkdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbkdItemStateChanged
        // TODO add your handling code here:
         try{
            String sql ="SELECT * FROM tblbarang WHERE KodeBarang='" + cmbkd.getSelectedItem().toString()+"'";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            r.absolute(1);
            txtbrg.setText(r.getString("NamaBarang"));
            txthrg.setText(r.getString("HargaJual"));
            txtstok.setText(r.getString("stok"));
        }catch(SQLException ex){
     
        }
    }//GEN-LAST:event_cmbkdItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int a, b, c;
        
        a = Integer.parseInt(txthrg.getText());
        b = Integer.parseInt(txtjmlh.getText());
        c = a*b;

        txttotal.setText(Integer.toString(c));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbptgsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbptgsItemStateChanged
        try{
        String sql ="SELECT * FROM tblpetugas WHERE IDPetugas='" + cmbptgs.getSelectedItem().toString()+"'";
            
        Connection c = koneksi.getKoneksi();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(sql);
            
        r.absolute(1);
        txtptgs.setText(r.getString("NamaPetugas"));
        }catch(SQLException ex){
     
        }
    }//GEN-LAST:event_cmbptgsItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        txtptgs.setText(null);
        txtbrg.setText(null);
        txthrg.setText(null);
        txtstok.setText(null);
        txtjmlh.setText(null);
        txttotal.setText(null);
        cmbptgs.setSelectedIndex(0);
        cmbkd.setSelectedIndex(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
        try {
        double totalAmount = Double.parseDouble(jTextField1.getText());
        double paymentAmount = Double.parseDouble(txtbayar.getText());

        if (paymentAmount < totalAmount) {
            // Handle insufficient payment
            JOptionPane.showMessageDialog(this, "Payment is less than the total amount", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double change = paymentAmount - totalAmount;

        // Display the change in a formatted way
        txtsisa.setText(String.format("%.2f", change));
    } catch (NumberFormatException e) {
        // Handle non-numeric input
        JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_txtbayarActionPerformed

    private void cmbkdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbkdActionPerformed

    private void txttglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttglActionPerformed

    private void txtnofakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnofakActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_txtnofakActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        java.util.Date tglsekarang = new java.util.Date();
        String nota = txtnofak.getText();
        //String namapetugas = cmbptgs.getSelectedItem().toString();
        String bayar = txtbayar.getText();
        String sisa = txtbayar.getText();
        String Total = jTextField1.getText();

        String KP = cmbptgs.getSelectedItem().toString();
        //String KD = cmbkd.getSelectedItem().toString();
        // ...
        if (tglsekarang == null || nota.isEmpty() || bayar.isEmpty() || sisa.isEmpty() || Total.isEmpty() || KP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO tblpenjualan ( NoFaktur, TglPenjualan, IDPetugas, Bayar, Sisa, Total) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);

                p.setString(1, nota);
                p.setDate(2, new java.sql.Date(tglsekarang.getTime()));
                p.setString(3, KP);
                p.setString(4, bayar);
                p.setString(5, sisa);
                p.setString(6, Total);

                p.executeUpdate();
                JOptionPane.showMessageDialog(null, "Berhasil ditambah");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } finally {
                 loadData(); // Anda perlu menentukan method ini
                 kosong(); // Anda perlu menentukan method ini
                 SetEditOff();
            }
        }   
    }//GEN-LAST:event_btnsaveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        SetEditOn();
        btntambah.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void kosong(){
        txtnofak.setText(null);
        txttgl.setText(null);
        txtptgs.setText(null);
        txtbrg.setText(null);
        txthrg.setText(null);
        txtstok.setText(null);
        txtjmlh.setText(null);
        txttotal.setText(null);
        cmbptgs.setSelectedIndex(0);
        cmbkd.setSelectedIndex(0);
        //tb_dtbrg.setRowCount(0);
    }
    
    private void bersih(){
        
        txtbrg.setText(null);
        txthrg.setText(null);
        txtstok.setText(null);
        txtjmlh.setText(null);
        txttotal.setText(null);
        cmbkd.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(form_penjualanbarang_cyn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_penjualanbarang_cyn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_penjualanbarang_cyn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_penjualanbarang_cyn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_penjualanbarang_cyn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cmbkd;
    private javax.swing.JComboBox<String> cmbptgs;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tb_dtbrg;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtbrg;
    private javax.swing.JTextField txthrg;
    private javax.swing.JTextField txtjmlh;
    private javax.swing.JTextField txtnofak;
    private javax.swing.JTextField txtptgs;
    private javax.swing.JTextField txtsisa;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttgl;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
