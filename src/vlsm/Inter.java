/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlsm;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Inter extends javax.swing.JFrame {

    VLSM calcu;

    public Inter() {
        initComponents();
        this.calcu = new VLSM();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtFldIPInicial = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtFldMascara = new javax.swing.JTextField();
        BtnIpMask = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TxtFldNombreRed = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtFldHosts = new javax.swing.JTextField();
        BtnAddNet = new javax.swing.JButton();
        BtnRemNet = new javax.swing.JButton();
        BtnCalcVLSM = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CALCULADORA VLSM");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        jLabel5.getAccessibleContext().setAccessibleName("jLabelTitulo");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("IP Inicial");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));
        jPanel1.add(TxtFldIPInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Mascara Inicial");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));
        jPanel1.add(TxtFldMascara, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 200, -1));

        BtnIpMask.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnIpMask.setText("Establecer IP y Mask");
        BtnIpMask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIpMaskActionPerformed(evt);
            }
        });
        jPanel1.add(BtnIpMask, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Nombre de Red");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        jPanel1.add(TxtFldNombreRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 100, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Numero de Hosts");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));
        jPanel1.add(TxtFldHosts, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 100, -1));

        BtnAddNet.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnAddNet.setText("Agregar Red");
        BtnAddNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddNetActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAddNet, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));

        BtnRemNet.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnRemNet.setText("Eliminar Red");
        BtnRemNet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemNetActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRemNet, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, -1, -1));

        BtnCalcVLSM.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCalcVLSM.setText("Aplicar VLSM");
        jPanel1.add(BtnCalcVLSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vlsm/dark_material_design_wallpaper__3_in_4k_by_tgs266-d9j9h5i-1024x576.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnIpMaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIpMaskActionPerformed
        // TODO add your handling code here:
        if (calcu.verificarMascara(TxtFldMascara.getText()).equals("Mascara Invalida")) {
            JOptionPane.showMessageDialog(this, "La mascara ingresada no es valida");
        }
        if (calcu.calcularTipo(TxtFldIPInicial.getText()).equals("Invalida")) {
            JOptionPane.showMessageDialog(this, "La IP ingresada no es valida");
        }
        System.out.println(calcu.calcularTipo(TxtFldIPInicial.getText()));
        System.out.println(calcu.verificarMascara(TxtFldMascara.getText()));
        String txtIP=calcu.calcularTipo(TxtFldIPInicial.getText());
        String txtMas=calcu.verificarMascara(TxtFldMascara.getText());
        if (!txtIP.equals(txtMas)) {
            JOptionPane.showMessageDialog(this, "La mascara ingresada no corresponde al tipo de IP ingresada");
        } else {
            TxtFldIPInicial.setEditable(false);
            TxtFldMascara.setEditable(false);
        }
    }//GEN-LAST:event_BtnIpMaskActionPerformed

    private void BtnRemNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemNetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRemNetActionPerformed

    private void BtnAddNetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddNetActionPerformed
        // TODO add your handling code here:
        calcu.redes.add(new Red(Integer.parseInt(TxtFldHosts.getText()),TxtFldNombreRed.getText()));
    }//GEN-LAST:event_BtnAddNetActionPerformed

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
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAddNet;
    private javax.swing.JButton BtnCalcVLSM;
    private javax.swing.JButton BtnIpMask;
    private javax.swing.JButton BtnRemNet;
    private javax.swing.JTextField TxtFldHosts;
    private javax.swing.JTextField TxtFldIPInicial;
    private javax.swing.JTextField TxtFldMascara;
    private javax.swing.JTextField TxtFldNombreRed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
