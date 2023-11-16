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
 * @author lab4
 */
public class from_jenisbarang extends javax.swing.JFrame {
    private DefaultTableModel model;

    /**
     * Creates new form from_jenisbarang
     */
    public from_jenisbarang() {
        initComponents();
        loadData();
        setEnablefalse();
        
    }
    public void setEnablefalse(){
       txtkodejenis.setEnabled(false);
       txtjenisbarang.setEnabled(false);
       btnsave.setEnabled(false);
       btnupdate.setEnabled(false);
       btndelete.setEnabled(false);
       btncancel.setEnabled(false);
       btnclose.setEnabled(false);
    }
    public void setEnabletrue(){
        txtkodejenis.setEnabled(true);
        txtjenisbarang.setEnabled(true);
        btnsave.setEnabled(true);
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        btncancel.setEnabled(true);
        btnclose.setEnabled(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     private void loadData (){
        
        model = new DefaultTableModel();
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        tabeljenis.setModel(model);
        model.addColumn("Kode Jenis");
        model.addColumn("Jenis");
        
        try{
            String sql = "SELECT * FROM tbljenis";
           
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
           
            while(r.next()){
                model.addRow(new Object[]{
                    r.getString(1),
                    r.getString(2),
                });
            }
           tabeljenis.setModel(model);
        } catch(SQLException e){
            System.out.println("terjadi eror");
        }
    }
    
    private void kosong(){
        txtkodejenis.setText(null);
        txtjenisbarang.setText(null);
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtjenisbarang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabeljenis = new javax.swing.JTable();
        btnaddnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        txtkodejenis = new javax.swing.JTextField();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Jenis Barang");

        jLabel2.setText("Jenis Barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Entri  Data Jenis Barang");

        txtjenisbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjenisbarangActionPerformed(evt);
            }
        });

        tabeljenis.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeljenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeljenisMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabeljenis);

        btnaddnew.setText("Add New");
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });

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

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        txtkodejenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtkodejenisMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnaddnew)
                        .addGap(18, 18, 18)
                        .addComponent(btnsave)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnclose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjenisbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtkodejenis, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtkodejenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtjenisbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddnew, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btncancel)
                    .addComponent(btnclose))
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
           int i = tabeljenis.getSelectedRow();
        
        if(i == -1){
            JOptionPane.showMessageDialog(this, "Harap Pilih Data Terlebih Dahulu", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String kode_jenis = (String) model.getValueAt(i, 0);
        
        try{
            Connection c = koneksi.getKoneksi();
            
           String sql = "DELETE FROM tbljenis WHERE KodeJenis=?";
                     
                     PreparedStatement p = c.prepareStatement(sql);
                     p.setString(1, kode_jenis);
                     p.executeUpdate();
                     p.close();
                     
                     JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Terjadi Error"+e.getMessage());
        } finally{
            loadData();
            kosong();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtjenisbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjenisbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjenisbarangActionPerformed

    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed
        // TODO add your handling code here:
        setEnabletrue();
        btnaddnew.setEnabled(false);
    
    }//GEN-LAST:event_btnaddnewActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String kode_jenis = txtkodejenis.getText();
        String jenis_barang = txtjenisbarang.getText();
        
         if ("".equals(kode_jenis) || "".equals(jenis_barang))
                 {
                     JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
                 }else {
             try{
                Connection c = koneksi.getKoneksi();
                String sql = "INSERT INTO tbljenis VALUES (?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
               
                p.setString(1, kode_jenis);
                p.setString(2, jenis_barang);

                
                p.executeUpdate();
                p.close();
                
                JOptionPane.showMessageDialog(null, "Berhasil ditambah");
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }finally {
                loadData();
                kosong();
                setEnablefalse();
                btnaddnew.setEnabled(true);
            }
         }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
         int i = tabeljenis.getSelectedRow();

if (i == -1) {
    JOptionPane.showMessageDialog(this, "Harap Pilih Data Terlebih Dahulu", "Error", JOptionPane.WARNING_MESSAGE);
    return;
}

String kode_jenis = (String) model.getValueAt(i, 0);
String jenis_barang = txtjenisbarang.getText();

try {
    Connection c = koneksi.getKoneksi();
    String sql = "UPDATE tbljenis SET Jenis = ? WHERE KodeJenis = ?";

    PreparedStatement p = c.prepareStatement(sql);

    p.setString(1, jenis_barang);
    p.setString(2, kode_jenis);

    p.executeUpdate();
    p.close();

    JOptionPane.showMessageDialog(null, "Ubah Data Berhasil");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Terjadi error: " + e.getMessage());
} finally {
    loadData();
    kosong();
}

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        txtkodejenis.setText("");
        txtjenisbarang.setText("");
        
    }//GEN-LAST:event_btncancelActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void txtkodejenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtkodejenisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodejenisMouseClicked

    private void tabeljenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeljenisMouseClicked
        // TODO add your handling code here:
        int baris = tabeljenis.getSelectedRow();
        if(baris == -1) {
            return ;
        }
        
        String kode_jenis = tabeljenis.getValueAt(baris, 0).toString();
        txtkodejenis.setText(kode_jenis);
        String  jenis_barang= tabeljenis.getValueAt(baris, 1).toString();
        txtjenisbarang.setText(jenis_barang);
    }//GEN-LAST:event_tabeljenisMouseClicked

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
            java.util.logging.Logger.getLogger(from_jenisbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(from_jenisbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(from_jenisbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(from_jenisbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new from_jenisbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddnew;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabeljenis;
    private javax.swing.JTextField txtjenisbarang;
    private javax.swing.JTextField txtkodejenis;
    // End of variables declaration//GEN-END:variables
}
