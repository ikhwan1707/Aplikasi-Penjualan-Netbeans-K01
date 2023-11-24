import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author SMKIU
 */
public class form_barangmasuk_sis extends javax.swing.JFrame {

     private DefaultTableModel model;
    /**
     * Creates new form form_barangmasuk_sis
     */
    public form_barangmasuk_sis() {
        initComponents();
        loadData();
        kosong();
        TampilComboBarang();
        TampilComboPetugas();
        TampilComboDistributor();
        setEnablefalse();
    }
    
    String data[] = new String[6];
     private void kosong() {
        txttglmasuk.setText(null);
        txtnota.setText(null);
        txtnamapetugas.setText(null);
        txtnamadistributor.setText(null);
        txtkota.setText(null);
        txtnamabarang.setText(null);
        txthargajual.setText(null);
        txtstok.setText(null);
        txtjumlah.setText(null);
        txtsubtotal.setText(null);
        txttotal.setText(null);
        combopetugas.setSelectedIndex(0);
        combodistributor.setSelectedIndex(0);
        combobarang.setSelectedIndex(0);
    }
    
    public void TampilComboBarang(){
        try{
            String sql = "SELECT * FROM tblbarang";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                combobarang.addItem(r.getString("KodeBarang"));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void TampilComboPetugas(){
        try{
            String sql = "SELECT * FROM tblpetugas";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                combopetugas.addItem(r.getString("IDPetugas"));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void TampilComboDistributor(){
        try{
            String sql = "SELECT * FROM tbldistributor";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                combodistributor.addItem(r.getString("IDDistributor"));
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     
     public void setEnablefalse(){
        txttglmasuk.setEnabled(false);
        txtnota.setEnabled(false);
        txtnamadistributor.setEnabled(false);
        txtkota.setEnabled(false);
        combopetugas.setEnabled(false);
        txtnamapetugas.setEnabled(false);
        combodistributor.setEnabled(false);
        combobarang.setEnabled(false);
        txtnamabarang.setEnabled(false);
        txthargajual.setEnabled(false);
        txtstok.setEnabled(false);
        txtjumlah.setEnabled(false);
        txtsubtotal.setEnabled(false);
        txttotal.setEnabled(false);
        additem.setEnabled(false);
        btnsave.setEnabled(false);
        btnclose.setEnabled(false);
    }
    
    public void setEnabletrue(){
        txttglmasuk.setEnabled(true);
        txtnota.setEnabled(true);
        txtnamadistributor.setEnabled(true);
        txtkota.setEnabled(true);
        txtnamapetugas.setEnabled(true);
        txtnamabarang.setEnabled(true);
        txthargajual.setEnabled(true);
        txtstok.setEnabled(true);
        txtjumlah.setEnabled(true);
        txtsubtotal.setEnabled(true);
        txttotal.setEnabled(true);
        combopetugas.setEnabled(true);
        combodistributor.setEnabled(true);
        combobarang.setEnabled(true);
        additem.setEnabled(true);
        btnsave.setEnabled(true);
        btnclose.setEnabled(true);
  
    }

    private void loadData(){
        model = new DefaultTableModel();
        
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        tabelbrgmasuk.setModel(model);
        model.addColumn("Kode barang");
        model.addColumn("Nama barang");
        model.addColumn("Harga jual");
        model.addColumn("Stok");
        model.addColumn("Jumlah");
        model.addColumn("Subtotal");
        
        try{
            String sql = "SELECT * FROM tblbrgmasuk";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while(r.next()){
                model.addRow(new Object[]{
                    r.getString(1),
                    r.getString(2),
                    r.getDate(3),
                    r.getString(4),
                    r.getString(5),
                });
            }
            tabelbrgmasuk.setModel(model);
        } catch(SQLException e){
            System.out.println("terjadi eror");
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnamabarang = new javax.swing.JTextField();
        txthargajual = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        txtjumlah = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        additem = new javax.swing.JButton();
        combobarang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbrgmasuk = new javax.swing.JTable();
        addnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        txttglmasuk = new javax.swing.JFormattedTextField();
        txtnota = new javax.swing.JTextField();
        combopetugas = new javax.swing.JComboBox<>();
        txtnamapetugas = new javax.swing.JTextField();
        combodistributor = new javax.swing.JComboBox<>();
        txtnamadistributor = new javax.swing.JTextField();
        txtkota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(75, 82, 126));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(229, 195, 166));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail Barang Masuk", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Kode Barang");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Nama Barang");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Harga Jual");

        txtnamabarang.setEnabled(false);
        txtnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarangActionPerformed(evt);
            }
        });

        txthargajual.setEnabled(false);
        txthargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargajualActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Rp");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Stok");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("Jumlah");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Sub Total");

        txtstok.setEnabled(false);

        txtsubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtsubtotal.setText("0");
        txtsubtotal.setEnabled(false);
        txtsubtotal.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtsubtotalCaretUpdate(evt);
            }
        });
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });

        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        additem.setText("Add Item");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });

        combobarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih" }));
        combobarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combobarangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txthargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(combobarang, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                        .addComponent(txtnamabarang, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtjumlah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhitung, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(additem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsubtotal)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhitung))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txthargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel14)
                        .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(additem)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        tabelbrgmasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelbrgmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbrgmasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbrgmasuk);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 568, 250));

        addnew.setText("Add New");
        addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnewActionPerformed(evt);
            }
        });
        jPanel1.add(addnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 870, -1, -1));

        btnsave.setText("Save Transaction");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 870, 180, -1));

        btnclose.setBackground(new java.awt.Color(255, 0, 51));
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 870, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total : Rp");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 870, -1, -1));

        txttotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txttotal.setText("0");
        txttotal.setEnabled(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 870, 105, -1));

        txttglmasuk.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));
        jPanel1.add(txttglmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 298, -1));
        jPanel1.add(txtnota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 300, -1));

        combopetugas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        combopetugas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combopetugasItemStateChanged(evt);
            }
        });
        jPanel1.add(combopetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 300, -1));

        txtnamapetugas.setEnabled(false);
        jPanel1.add(txtnamapetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 300, -1));

        combodistributor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih", " " }));
        combodistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combodistributorItemStateChanged(evt);
            }
        });
        jPanel1.add(combodistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 300, -1));

        txtnamadistributor.setEnabled(false);
        jPanel1.add(txtnamadistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 300, -1));

        txtkota.setEnabled(false);
        jPanel1.add(txtkota, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 300, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Nama Distributor");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nama Petugas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Id Petugas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("No.Nota");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Tanggal Masuk");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Entri Barang Masuk");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 200, -1));

        jPanel2.setBackground(new java.awt.Color(229, 195, 166));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Id Distributor");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 169, 94, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Kota Asal");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 255, 100, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 570, 290));

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combodistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combodistributorItemStateChanged
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM tbldistributor WHERE IDDistributor='"+ combodistributor.getSelectedItem().toString()+"'";

            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            r.absolute(1);
            txtnamadistributor.setText(r.getString("NamaDistributor"));
            txtkota.setText(r.getString("KotaAsal"));
        }catch (SQLException ex){
        }
    }//GEN-LAST:event_combodistributorItemStateChanged

    private void combopetugasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combopetugasItemStateChanged
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM tblpetugas WHERE IDPetugas='"+ combopetugas.getSelectedItem().toString()+"'";

            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            r.absolute(1);
            txtnamapetugas.setText(r.getString("NamaPetugas"));
        }catch (SQLException ex){

        }
    }//GEN-LAST:event_combopetugasItemStateChanged

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(null,"Aplikasi ini akan ditutup \\n jika Anda menekan tombol OK",
            "Information",JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION)
    this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        java.util.Date tanggalMasuk = (java.util.Date) txttglmasuk.getValue();
        String nota = txtnota.getText();
        String namapetugas = txtnamapetugas.getText();
        String namadistributor = txtnamadistributor.getText();
        String Total = txttotal.getText();

        String KP = combopetugas.getSelectedItem().toString();
        String KD = combodistributor.getSelectedItem().toString();
        // ...
        if (tanggalMasuk == null || nota.isEmpty() || namapetugas.isEmpty() || namadistributor.isEmpty() || Total.isEmpty() || KP.isEmpty() || KD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO tblbrgmasuk ( NoNota, TglMasuk, IDDistributor, IDPetugas, Total) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);

                p.setString(1, nota);
                p.setDate(2, new java.sql.Date(tanggalMasuk.getTime()));
                p.setString(3, KD);
                p.setString(4, KP);
                p.setString(5, Total);

                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Berhasil ditambah");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            } finally {
                loadData(); // Anda perlu menentukan method ini
                kosong(); // Anda perlu menentukan method ini
                setEnabletrue();
                addnew.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnewActionPerformed
        // TODO add your handling code here:
        setEnabletrue();
        addnew.setEnabled(true);
    }//GEN-LAST:event_addnewActionPerformed

    private void tabelbrgmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbrgmasukMouseClicked
        // TODO add your handling code here:
        int baris = tabelbrgmasuk.getSelectedRow();
        if(baris == -1) {
            return;
        }

        combobarang.setSelectedItem(tabelbrgmasuk.getValueAt(baris, 0).toString());
        String nama_barang = tabelbrgmasuk.getValueAt(baris, 1).toString();
        txtnamabarang.setText(nama_barang);
        String harga_jual = tabelbrgmasuk.getValueAt(baris, 2).toString();
        txthargajual.setText(harga_jual);
        String stok = tabelbrgmasuk.getValueAt(baris, 3).toString();
        txtstok.setText(stok);
        String jumlah = tabelbrgmasuk.getValueAt(baris, 4).toString();
        txtjumlah.setText(jumlah);
        String subtotal = tabelbrgmasuk.getValueAt(baris, 5).toString();
        txtsubtotal.setText(subtotal);
    }//GEN-LAST:event_tabelbrgmasukMouseClicked

    private void combobarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combobarangItemStateChanged
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM tblbarang WHERE KodeBarang='"+ combobarang.getSelectedItem().toString()+"'";

            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);

            r.absolute(1);
            txtnamabarang.setText(r.getString("NamaBarang"));
            txthargajual.setText(r.getString("HargaJual"));
            txtstok.setText(r.getString("Stok"));
        }catch (SQLException ex){

        }
    }//GEN-LAST:event_combobarangItemStateChanged

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
        // TODO add your handling code here:
        String NT=txtnota.getText();
        String KB=combobarang.getSelectedItem().toString();
        String JM=txtjumlah.getText();

        int a, b, c;
        a = Integer.parseInt(txthargajual.getText());
        b = Integer.parseInt(txtjumlah.getText());
        c = a*b;

        txttotal.setText(Integer.toString(c));

        if ((NT.isEmpty()) | (KB.isEmpty()) |(JM.isEmpty())) {
            JOptionPane.showMessageDialog(null,"data tidak boleh kosong, silahkan dilengkapi");
            combobarang.requestFocus();
        }else {
            try{
                Connection kon = koneksi.getKoneksi();
                Statement stt = kon.createStatement();
                String SQL = "insert into tbldetailbrgmasuk values('"+txtnota.getText()+"',"+
                "'"+combobarang.getSelectedItem()+"',"+
                "'"+txtjumlah.getText()+"',"+
                "'"+txtsubtotal.getText()+"')";
                stt.executeUpdate(SQL);

                Connection kon1 = koneksi.getKoneksi();
                Statement stt1 = kon1.createStatement();
                String SQL1 = "Update tblbarang Set stok=stok - '"+txtjumlah.getText()+"'" +
                "Where KodeBarang='"+combobarang.getSelectedItem().toString()+"'";
                stt1.executeUpdate(SQL1);

                data[0] = combobarang.getSelectedItem().toString();
                data[1] = txtnamabarang.getText();
                data[2] = txthargajual.getText();
                data[3] = txtstok.getText();
                data[4] = txtjumlah.getText();
                data[5] = txtsubtotal.getText();
                model.insertRow(0, data);
                //                stt.close();
                //                kon.close();
                combobarang.requestFocus();
                additem.setEnabled(false);
                btnsave.setEnabled(true);
                //                BersihDetail();
                combobarang.requestFocus();
            } catch(Exception ex){
                System.out.println("Terjadi Error"+ex.getMessage());
            }
        }
    }//GEN-LAST:event_additemActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        int a, b, c;

        a = Integer.parseInt(txthargajual.getText());
        b = Integer.parseInt(txtjumlah.getText());
        c = a*b;

        txtsubtotal.setText(Integer.toString(c));
    }//GEN-LAST:event_btnhitungActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void txtsubtotalCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsubtotalCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalCaretUpdate

    private void txthargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargajualActionPerformed

    private void txtnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarangActionPerformed

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
            java.util.logging.Logger.getLogger(form_barangmasuk_sis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_barangmasuk_sis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_barangmasuk_sis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_barangmasuk_sis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_barangmasuk_sis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additem;
    private javax.swing.JButton addnew;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> combobarang;
    private javax.swing.JComboBox<String> combodistributor;
    private javax.swing.JComboBox<String> combopetugas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelbrgmasuk;
    private javax.swing.JTextField txthargajual;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkota;
    private javax.swing.JTextField txtnamabarang;
    private javax.swing.JTextField txtnamadistributor;
    private javax.swing.JTextField txtnamapetugas;
    private javax.swing.JTextField txtnota;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JFormattedTextField txttglmasuk;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
