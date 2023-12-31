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
 * @author user
 */
public class form_distributorbarang_eca extends javax.swing.JFrame {

    private DefaultTableModel model;
    
    /**
     * Creates new form form_distributorbarang_eca
     */
    public form_distributorbarang_eca() {
        initComponents();
        loaddata();
        kosong();
        setEnablefalse();
    }
    
        public void kosong(){
        txtid.setText("");
        txtnamadistributor.setText("");
        txtalamat.setText("");
        txtkota.setText("");
        txtemail.setText("");
        txttelp.setText("");
    }
        
        public void setEnablefalse(){
        txtalamat.setEnabled(false);
        txtid.setEnabled(false);
        txtnamadistributor.setEnabled(false);
        txtkota.setEnabled(false);
        txtemail.setEnabled(false);
        txttelp.setEnabled(false);
        btnsave.setEnabled(false);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btncancel.setEnabled(false);
    }
    
    public void setEnabletrue(){
        txtalamat.setEnabled(true);
        txtid.setEnabled(true);
        txtnamadistributor.setEnabled(true);
        txtkota.setEnabled(true);
        txtemail.setEnabled(true);
        txttelp.setEnabled(true);
        btnsave.setEnabled(true);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        btncancel.setEnabled(true);
    }
    
       // Pada method loaddata():
        private void loaddata() {
        model = new DefaultTableModel();
        
        //menghapus seluruh data
        model.getDataVector().removeAllElements();
        
        //memberitahu bahwa data telah kosong
        model.fireTableDataChanged();
        
        TableDistributor.setModel(model);
        model.addColumn("IDDistributor");
        model.addColumn("NamaDistributor");
        model.addColumn("Alamat");
        model.addColumn("KotaAsal");
        model.addColumn("Email");
        model.addColumn("Telpon");
        
         try{
            String sql = "SELECT * FROM tbldistributor";
            
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()){
            //lakukan penelusuran baris
            model.addRow(new Object[]{
                r.getString(1),
                r.getString(2),
                r.getString(3),
                r.getString(4),
                r.getString(5),
                r.getString(6)
            });
            }
             TableDistributor.setModel(model);
        }catch(SQLException e){
            System.out.println("Terjadi Error: " + e.getMessage());
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
        btnadd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnamadistributor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtkota = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txttelp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDistributor = new javax.swing.JTable();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btncancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(75, 82, 126));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));

        btnadd.setText("Add New");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(229, 195, 166));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 20, 82, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID Distributor");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 26, -1, -1));
        jPanel4.add(txtnamadistributor, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 54, 169, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nama Distributor");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Alamat Distributor");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 100, 110, -1));
        jPanel4.add(txtkota, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, -1));
        jPanel4.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 170, -1));
        jPanel4.add(txttelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Kota Asal");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 188, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("E-mail");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 229, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Telepon");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 269, -1, -1));

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane2.setViewportView(txtalamat);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 94, 170, 70));

        TableDistributor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDistributorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDistributor);

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(255, 0, 51));
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(225, 199, 143));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Entri Data Distributor Barang");

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnupdate)
                            .addComponent(btnsave)
                            .addComponent(btndelete)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnadd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncancel)
                            .addGap(26, 26, 26)
                            .addComponent(btnclose))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnsave)
                        .addGap(12, 12, 12)
                        .addComponent(btnupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndelete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnclose)
                    .addComponent(btncancel)
                    .addComponent(btnadd))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        kosong();
    }//GEN-LAST:event_btncancelActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int i = TableDistributor.getSelectedRow();

        if(i == -1){
            //tidak ada baris tewrseleksi
            JOptionPane.showMessageDialog(this, "Harap Pilih Data Terlebih Dahulu", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = (String) model.getValueAt(i, 0);

        try{
            Connection c = koneksi.getKoneksi();

            String sql = "DELETE FROM tbldistributor WHERE IDDistributor = ?";

            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.executeUpdate();
            p.close();

            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Terjadi ERROR");
        }finally {
            loaddata();
            kosong();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        int i = TableDistributor.getSelectedRow();

        if(i == -1){
            //tidak ada baris tewrseleksi
            JOptionPane.showMessageDialog(this, "harap pilih data terlebih dahulu", "error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = (String) model.getValueAt(i, 0);
        String nama = txtnamadistributor.getText();
        String alamat = txtalamat.getText();
        String kota = txtkota.getText();
        String email = txtemail.getText();
        String telpon = txttelp.getText();

        try {
            Connection c = koneksi.getKoneksi();

            String sql = "UPDATE tbldistributor SET NamaDistributor = ?, Alamat = ?, KotaAsal = ?, Email = ?, Telpon = ? WHERE IDDistributor = ?"; // Pastikan nama tabel dan kolom yang benar

            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, nama);
            p.setString(2, alamat);
            p.setString(3, kota);
            p.setString(4, email);
            p.setString(5, telpon);
            p.setString(6, id);

            p.executeUpdate();
            p.close();

            JOptionPane.showMessageDialog(null, "Ubah Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi ERROR: " + e.getMessage());
        } finally {
            loaddata();
            kosong();
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        String id = txtid.getText();
        String nama = txtnamadistributor.getText();
        String alamat = txtalamat.getText();
        String kota = txtkota.getText();
        String email = txtemail.getText();
        String telpon = txttelp.getText();

        // Memeriksa apakah ada field yang kosong
        if (id.isEmpty() || nama.isEmpty() || alamat.isEmpty() || kota.isEmpty() || email.isEmpty() || telpon.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "error", JOptionPane.WARNING_MESSAGE);
        } else {
            Connection c = null;
            PreparedStatement p = null;
            try {
                c = koneksi.getKoneksi();
                String sql = "INSERT INTO tbldistributor (IDDistributor, NamaDistributor, Alamat, KotaAsal, Email, Telpon) VALUES (?, ?, ?, ?, ?, ?)";
                p = c.prepareStatement(sql);

                p.setString(1, id);
                p.setString(2, nama);
                p.setString(3, alamat);
                p.setString(4, kota);
                p.setString(5, email);
                p.setString(6, telpon);

                // Menjalankan query untuk menyimpan data
                int rowsAffected = p.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Penyimpanan data berhasil");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menyimpan data");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            } finally {
                loaddata();
                kosong();
                setEnabletrue();
                btnadd.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void TableDistributorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDistributorMouseClicked
        int baris = TableDistributor.getSelectedRow();

        if (baris == -1){
            //tak ada baris terseleksi
            return;
        }

        String id = TableDistributor.getValueAt(baris, 0).toString();
        txtid.setText(id);
        String nama = TableDistributor.getValueAt(baris, 1).toString();
        txtnamadistributor.setText(nama);
        String alamat = TableDistributor.getValueAt(baris, 2).toString();
        txtalamat.setText(alamat);
        String kota = TableDistributor.getValueAt(baris, 3).toString();
        txtkota.setText(kota);
        String email = TableDistributor.getValueAt(baris, 4).toString();
        txtemail.setText(email);
        String telepon = TableDistributor.getValueAt(baris, 5).toString();
        txttelp.setText(telepon);

    }//GEN-LAST:event_TableDistributorMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        setEnabletrue();
        btnadd.setEnabled(true);
    }//GEN-LAST:event_btnaddActionPerformed

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
            java.util.logging.Logger.getLogger(form_distributorbarang_eca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_distributorbarang_eca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_distributorbarang_eca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_distributorbarang_eca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_distributorbarang_eca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDistributor;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtkota;
    private javax.swing.JTextField txtnamadistributor;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables
}
