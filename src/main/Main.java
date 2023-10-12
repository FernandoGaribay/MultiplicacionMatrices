package main;

import java.util.Random;

public class Main extends javax.swing.JFrame {

    private int[][] matriz;

    public Main() {
        initComponents();
        iniciar();

    }

    public void iniciar() {
        this.matriz = new int[1000][1000];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = new Random().nextInt(10);
            }
        }
        this.pnlPreviewMatriz.setMatriz(matriz);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlPreviewMatriz = new main.PreviewPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        jPanel1.add(pnlPreviewMatriz);
        pnlPreviewMatriz.setBounds(10, 10, 800, 835);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algoritmos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton2.setText("Procesamiento Secuencial");
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 300, -1));

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton1.setText("Algoritmo de Cannon");
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 300, -1));

        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jRadioButton3.setText("Por bloques (Strassen)");
        jPanel3.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 300, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 160));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Numero de hilos: 2");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 290, 30));

        jSlider1.setMajorTickSpacing(2);
        jSlider1.setMaximum(20);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(2);
        jSlider1.setFocusable(false);
        jPanel4.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 100));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 330, 250));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Generar Matriz B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 135, 30));

        jButton3.setText("Generar Matriz A");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 135, 30));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 135, 135));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 135, 135));

        jButton1.setText("Aplicar cambios");
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 295, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 330, 290));

        jButton4.setText("Comenzar");
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 773, 350, 50));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(820, 10, 370, 835);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JSlider jSlider1;
    private main.PreviewPanel pnlPreviewMatriz;
    // End of variables declaration//GEN-END:variables
}
