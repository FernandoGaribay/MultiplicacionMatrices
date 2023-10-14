package main;

import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    private int[][] matrizA;
    private int[][] matrizB;
    private MatrizSecuencial objSecuencial;

    public Main() {
        initComponents();
        objSecuencial = new MatrizSecuencial();
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
        radioStrassen = new javax.swing.JRadioButton();
        pnlMonitor = new javax.swing.JPanel();
        lblNumHilos = new javax.swing.JLabel();
        sliderNumHilos = new javax.swing.JSlider();
        pnlContenedorHilos = new javax.swing.JPanel();
        pnlConfiguracion = new javax.swing.JPanel();
        btnGenMatrizB = new javax.swing.JButton();
        btnGenMatrizA = new javax.swing.JButton();
        pnlMatrizB = new javax.swing.JPanel();
        pnlMatrizA = new javax.swing.JPanel();
        btnAplicarCambios = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        pnlAlgoritmos.add(radioSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, -1));

        btnGroupAlgoritmos.add(radioCannon);
        radioCannon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioCannon.setText("Algoritmo de Cannon");
        radioCannon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioCannon.setFocusPainted(false);
        pnlAlgoritmos.add(radioCannon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 300, -1));

        btnGroupAlgoritmos.add(radioStrassen);
        radioStrassen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioStrassen.setText("Por bloques (Strassen)");
        radioStrassen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioStrassen.setFocusPainted(false);
        pnlAlgoritmos.add(radioStrassen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 300, -1));

        pnlLateral.add(pnlAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 160));

        pnlMonitor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlMonitor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumHilos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumHilos.setText("Numero de hilos: 2");
        pnlMonitor.add(lblNumHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 290, 30));

        sliderNumHilos.setMajorTickSpacing(2);
        sliderNumHilos.setMaximum(20);
        sliderNumHilos.setMinimum(1);
        sliderNumHilos.setPaintLabels(true);
        sliderNumHilos.setPaintTicks(true);
        sliderNumHilos.setValue(2);
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

        btnGenMatrizB.setText("Generar Matriz B");
        btnGenMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizB.setFocusPainted(false);
        btnGenMatrizB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizBActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 135, 30));

        btnGenMatrizA.setText("Generar Matriz A");
        btnGenMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizA.setFocusPainted(false);
        btnGenMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizAActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 135, 30));

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

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 900));

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
        if (matrizA == null && matrizB == null) {
            JOptionPane.showMessageDialog(this, "Una de las matrices esta vacia.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int[][] matrizResultante;
        if (radioSecuencial.isSelected()) {
            matrizResultante = objSecuencial.multiplicar(matrizA, matrizB);

            for (int i = 0; i < matrizResultante.length; i++) {
                for (int j = 0; j < matrizResultante[0].length; j++) {
                    System.out.print(matrizResultante[i][j] + " ");
                }
                System.out.println("");
            }
            pnlPreviewMatriz.setMatriz(matrizResultante);
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

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

    public void secuencial() {

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
    private javax.swing.JButton btnGenMatrizA;
    private javax.swing.JButton btnGenMatrizB;
    private javax.swing.ButtonGroup btnGroupAlgoritmos;
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
    private javax.swing.JRadioButton radioSecuencial;
    private javax.swing.JRadioButton radioStrassen;
    private javax.swing.JSlider sliderNumHilos;
    // End of variables declaration//GEN-END:variables
}
