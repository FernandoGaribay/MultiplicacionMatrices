package main;

import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private int[][] matrizA;
    private int[][] matrizB;
    private MatrizSecuencial objSecuencial;
    private MatrizConcurrente objConcurrente;

    public Main() {
        initComponents();
        objSecuencial = new MatrizSecuencial();
        objConcurrente = new MatrizConcurrente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAlgoritmos = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        pnlPreviewMatriz = new main.PreviewPanel();
        pnlLateral = new javax.swing.JPanel();
        pnlAlgoritmos = new javax.swing.JPanel();
        radioSecuencial = new javax.swing.JRadioButton();
        radioCannon = new javax.swing.JRadioButton();
        radioFilas = new javax.swing.JRadioButton();
        pnlMonitor = new javax.swing.JPanel();
        lblNumHilos = new javax.swing.JLabel();
        sliderNumHilos = new javax.swing.JSlider();
        pnlContenedorHilos = new javax.swing.JPanel();
        pnlConfiguracion = new javax.swing.JPanel();
        btnDelMatrizB = new javax.swing.JButton();
        btnGenMatrizB = new javax.swing.JButton();
        btnDelMatrizA = new javax.swing.JButton();
        btnGenMatrizA = new javax.swing.JButton();
        pnlMatrizB = new javax.swing.JPanel();
        pnlMatrizA = new javax.swing.JPanel();
        btnAplicarCambios = new javax.swing.JButton();
        lblMatrizB = new javax.swing.JLabel();
        lblMatrizA = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(null);
        background.add(pnlPreviewMatriz);
        pnlPreviewMatriz.setBounds(10, 10, 800, 835);

        pnlLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAlgoritmos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algoritmos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlAlgoritmos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGroupAlgoritmos.add(radioSecuencial);
        radioSecuencial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioSecuencial.setSelected(true);
        radioSecuencial.setText("Procesamiento Secuencial");
        radioSecuencial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioSecuencial.setFocusPainted(false);
        radioSecuencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSecuencialActionPerformed(evt);
            }
        });
        pnlAlgoritmos.add(radioSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, -1));

        btnGroupAlgoritmos.add(radioCannon);
        radioCannon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioCannon.setText("Algoritmo de Cannon");
        radioCannon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioCannon.setFocusPainted(false);
        pnlAlgoritmos.add(radioCannon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 300, -1));

        btnGroupAlgoritmos.add(radioFilas);
        radioFilas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioFilas.setText("Concurrente Por Filas");
        radioFilas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioFilas.setFocusPainted(false);
        radioFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFilasActionPerformed(evt);
            }
        });
        pnlAlgoritmos.add(radioFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 300, -1));

        pnlLateral.add(pnlAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 160));

        pnlMonitor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlMonitor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumHilos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumHilos.setText("Numero de hilos: 1");
        pnlMonitor.add(lblNumHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 290, 30));

        sliderNumHilos.setMajorTickSpacing(2);
        sliderNumHilos.setMaximum(20);
        sliderNumHilos.setMinimum(1);
        sliderNumHilos.setPaintLabels(true);
        sliderNumHilos.setPaintTicks(true);
        sliderNumHilos.setValue(1);
        sliderNumHilos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderNumHilos.setEnabled(false);
        sliderNumHilos.setFocusable(false);
        sliderNumHilos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderNumHilosStateChanged(evt);
            }
        });
        sliderNumHilos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sliderNumHilosMouseReleased(evt);
            }
        });
        pnlMonitor.add(sliderNumHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, -1));

        pnlContenedorHilos.setBackground(new java.awt.Color(255, 255, 255));
        pnlMonitor.add(pnlContenedorHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 290, 100));

        pnlLateral.add(pnlMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 330, 250));

        pnlConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDelMatrizB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDelMatrizB.setText("Borrar");
        btnDelMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMatrizB.setFocusPainted(false);
        btnDelMatrizB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMatrizBActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnDelMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 60, 60, 20));

        btnGenMatrizB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnGenMatrizB.setText("Generar");
        btnGenMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizB.setFocusPainted(false);
        btnGenMatrizB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizBActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 70, 20));

        btnDelMatrizA.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDelMatrizA.setText("Borrar");
        btnDelMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMatrizA.setFocusPainted(false);
        btnDelMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMatrizAActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnDelMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 60, 60, 20));

        btnGenMatrizA.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnGenMatrizA.setText("Generar");
        btnGenMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizA.setFocusPainted(false);
        btnGenMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizAActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 70, 20));

        pnlMatrizB.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizB.setLayout(new java.awt.BorderLayout());
        pnlConfiguracion.add(pnlMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 135, 135));

        pnlMatrizA.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizA.setLayout(new java.awt.BorderLayout());
        pnlConfiguracion.add(pnlMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 135, 135));

        btnAplicarCambios.setText("Aplicar cambios");
        btnAplicarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAplicarCambios.setFocusPainted(false);
        pnlConfiguracion.add(btnAplicarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 295, 30));

        lblMatrizB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMatrizB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatrizB.setText("Matriz B");
        pnlConfiguracion.add(lblMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 32, 130, 20));

        lblMatrizA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMatrizA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatrizA.setText("Matriz A");
        pnlConfiguracion.add(lblMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 32, 130, 20));

        pnlLateral.add(pnlConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 330, 290));

        btnComenzar.setText("Comenzar");
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.setFocusPainted(false);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        pnlLateral.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 773, 350, 50));

        background.add(pnlLateral);
        pnlLateral.setBounds(820, 10, 370, 835);

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenMatrizBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenMatrizBActionPerformed
        int filas = 0;
        int columnas = 0;
        try {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de filas: "));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de columnas: "));
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Favor de insertar un numero valido.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (filas == 0 || columnas == 0) {
            JOptionPane.showMessageDialog(this, "Las matrices no pueden ser con filas/columnas 0.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        matrizB = generarMatriz(filas, columnas);
        pnlMatrizB.add(new panelMatriz(filas + "x" + columnas));
        pnlMatrizB.repaint();
        pnlMatrizB.revalidate();
    }//GEN-LAST:event_btnGenMatrizBActionPerformed

    private void btnGenMatrizAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenMatrizAActionPerformed
        int filas = 0;
        int columnas = 0;
        try {
            filas = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de filas: "));
            columnas = Integer.parseInt(JOptionPane.showInputDialog("Dijite el numero de columnas: "));
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Favor de insertar un numero valido.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (filas == 0 || columnas == 0) {
            JOptionPane.showMessageDialog(this, "Las matrices no pueden ser con filas/columnas 0.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        matrizA = generarMatriz(filas, columnas);
        pnlMatrizA.add(new panelMatriz(filas + "x" + columnas));
        pnlMatrizA.repaint();
        pnlMatrizA.revalidate();
    }//GEN-LAST:event_btnGenMatrizAActionPerformed

    private void sliderNumHilosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderNumHilosStateChanged
        this.lblNumHilos.setText("Numero de hilos: " + sliderNumHilos.getValue());
    }//GEN-LAST:event_sliderNumHilosStateChanged

    private void sliderNumHilosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderNumHilosMouseReleased
        System.out.println("Numero de hilos establecido a: " + sliderNumHilos.getValue());
    }//GEN-LAST:event_sliderNumHilosMouseReleased

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        if (matrizA == null || matrizB == null) {
            JOptionPane.showMessageDialog(this, "Una de las matrices esta vacia.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int[][] matrizResultante;
        if (radioSecuencial.isSelected()) {
            matrizResultante = objSecuencial.multiplicar(matrizA, matrizB);

            pnlPreviewMatriz.setMatriz(matrizResultante);
        } else if (radioFilas.isSelected()) {
            objConcurrente.setNumHilos(sliderNumHilos.getValue());
            matrizResultante = objConcurrente.multiplicar(matrizA, matrizB);

            pnlPreviewMatriz.setMatriz(matrizResultante);
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void btnDelMatrizBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMatrizBActionPerformed
        matrizB = null;
        pnlMatrizB.removeAll();
        pnlMatrizB.repaint();
        pnlMatrizB.revalidate();
    }//GEN-LAST:event_btnDelMatrizBActionPerformed

    private void btnDelMatrizAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMatrizAActionPerformed
        matrizA = null;
        pnlMatrizA.removeAll();
        pnlMatrizA.repaint();
        pnlMatrizA.revalidate();
    }//GEN-LAST:event_btnDelMatrizAActionPerformed

    private void radioSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSecuencialActionPerformed
        deshabilitarMonitor();
    }//GEN-LAST:event_radioSecuencialActionPerformed

    private void radioFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFilasActionPerformed
        habilitarMonitor();
    }//GEN-LAST:event_radioFilasActionPerformed

    public void habilitarMonitor(){
        this.sliderNumHilos.setEnabled(true);
    }
    
    public void deshabilitarMonitor(){
        this.sliderNumHilos.setEnabled(false);
    }
    
    public int[][] generarMatriz(int filas, int columnas) {
        int[][] matrizTemp = new int[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizTemp[i][j] = random.nextInt(10);
            }
        }
        return matrizTemp;
    }

    public void imprimirMatriz(int[][] matrizResultante) {
        for (int i = 0; i < matrizResultante.length; i++) {
            for (int j = 0; j < matrizResultante[0].length; j++) {
                System.out.print(matrizResultante[i][j] + " ");
            }
            System.out.println("");
        }
    }

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
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAplicarCambios;
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnDelMatrizA;
    private javax.swing.JButton btnDelMatrizB;
    private javax.swing.JButton btnGenMatrizA;
    private javax.swing.JButton btnGenMatrizB;
    private javax.swing.ButtonGroup btnGroupAlgoritmos;
    private javax.swing.JLabel lblMatrizA;
    private javax.swing.JLabel lblMatrizB;
    private javax.swing.JLabel lblNumHilos;
    private javax.swing.JPanel pnlAlgoritmos;
    private javax.swing.JPanel pnlConfiguracion;
    private javax.swing.JPanel pnlContenedorHilos;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlMatrizA;
    private javax.swing.JPanel pnlMatrizB;
    private javax.swing.JPanel pnlMonitor;
    private main.PreviewPanel pnlPreviewMatriz;
    private javax.swing.JRadioButton radioCannon;
    private javax.swing.JRadioButton radioFilas;
    private javax.swing.JRadioButton radioSecuencial;
    private javax.swing.JSlider sliderNumHilos;
    // End of variables declaration//GEN-END:variables
}
