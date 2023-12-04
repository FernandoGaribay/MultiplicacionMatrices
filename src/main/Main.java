package main;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnConcurrencia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnClienteRMI = new javax.swing.JLabel();
        btnServidorRMI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione como gusta ingresar al programa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 700, 30));

        btnConcurrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/concurrencia.png"))); // NOI18N
        btnConcurrencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConcurrencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConcurrenciaMousePressed(evt);
            }
        });
        jPanel1.add(btnConcurrencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 200, 200));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cliente RMI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 200, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Con concurrencia");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 200, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Servidor RMI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 200, 30));

        btnClienteRMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente RMI.png"))); // NOI18N
        btnClienteRMI.setText("jLabel5");
        btnClienteRMI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClienteRMI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClienteRMIMousePressed(evt);
            }
        });
        jPanel1.add(btnClienteRMI, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 200, 200));

        btnServidorRMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/servidor RMI.png"))); // NOI18N
        btnServidorRMI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServidorRMI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnServidorRMIMousePressed(evt);
            }
        });
        jPanel1.add(btnServidorRMI, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 200, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcurrenciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConcurrenciaMousePressed
        Concurrente vtnConcurrente = new Concurrente();
        vtnConcurrente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnConcurrenciaMousePressed

    private void btnServidorRMIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServidorRMIMousePressed
        ServerUI vtnSeverRMI = new ServerUI();
        vtnSeverRMI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnServidorRMIMousePressed

    private void btnClienteRMIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteRMIMousePressed
        ClienteUI vtnClienteRMI = new ClienteUI();
        vtnClienteRMI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClienteRMIMousePressed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClienteRMI;
    private javax.swing.JLabel btnConcurrencia;
    private javax.swing.JLabel btnServidorRMI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
