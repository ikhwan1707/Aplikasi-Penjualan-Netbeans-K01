/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author smki
 */
public class menu_utama extends javax.swing.JFrame {

    /**
     * Creates new form menu_utama
     */
    public menu_utama() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        dtjenisbarang = new javax.swing.JMenuItem();
        dtbarang = new javax.swing.JMenuItem();
        dtdistributor = new javax.swing.JMenuItem();
        dtpetugas = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        dtbarangmasuk = new javax.swing.JMenuItem();
        dtpenjualanbrg = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        dtjenisbarang.setText("Data Jenis Barang");
        dtjenisbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtjenisbarangActionPerformed(evt);
            }
        });
        jMenu1.add(dtjenisbarang);

        dtbarang.setText("Data Barang");
        dtbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtbarangActionPerformed(evt);
            }
        });
        jMenu1.add(dtbarang);

        dtdistributor.setText("Data Distributor");
        dtdistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtdistributorActionPerformed(evt);
            }
        });
        jMenu1.add(dtdistributor);

        dtpetugas.setText("Data Petugas");
        dtpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpetugasActionPerformed(evt);
            }
        });
        jMenu1.add(dtpetugas);

        jMenuItem5.setText("Exit");
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Transaksi");

        dtbarangmasuk.setText("Data Barang Masuk");
        dtbarangmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtbarangmasukActionPerformed(evt);
            }
        });
        jMenu3.add(dtbarangmasuk);

        dtpenjualanbrg.setText("Data Penjualan Barang");
        dtpenjualanbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpenjualanbrgActionPerformed(evt);
            }
        });
        jMenu3.add(dtpenjualanbrg);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Report");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dtjenisbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtjenisbarangActionPerformed
        // TODO add your handling code here:
        new from_jenisbarang().setVisible(true);
    }//GEN-LAST:event_dtjenisbarangActionPerformed

    private void dtbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtbarangActionPerformed
        // TODO add your handling code here:
        new from_barang().setVisible(true);
    }//GEN-LAST:event_dtbarangActionPerformed

    private void dtpenjualanbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpenjualanbrgActionPerformed
        // TODO add your handling code here:
        new form_penjualanbarang_cyn().setVisible(true);
    }//GEN-LAST:event_dtpenjualanbrgActionPerformed

    private void dtbarangmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtbarangmasukActionPerformed
        // TODO add your handling code here:
        new form_barangmasuk_sis().setVisible(true);
    }//GEN-LAST:event_dtbarangmasukActionPerformed

    private void dtdistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtdistributorActionPerformed
        // TODO add your handling code here:
        //new form_distributorbarang_eca().setVisible(true);
    }//GEN-LAST:event_dtdistributorActionPerformed

    private void dtpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpetugasActionPerformed
        // TODO add your handling code here:
        new form_petugas_eca().setVisible(true);
    }//GEN-LAST:event_dtpetugasActionPerformed

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
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dtbarang;
    private javax.swing.JMenuItem dtbarangmasuk;
    private javax.swing.JMenuItem dtdistributor;
    private javax.swing.JMenuItem dtjenisbarang;
    private javax.swing.JMenuItem dtpenjualanbrg;
    private javax.swing.JMenuItem dtpetugas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}