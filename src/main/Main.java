package main;

import componentes.panelMatriz;
import algoritmos.MatrizPorBloques;
import algoritmos.MatrizSecuencial;
import algoritmos.MatrizPorFilas;
import componentes.PopupPanel;
import componentes.HiloUI;
import interfaz.ProgresoListener;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class Main extends javax.swing.JFrame implements ProgresoListener {

    private int[][] matrizA = null;
    private int[][] matrizB = null;
    private PopupPanel objPopup;
    private ArrayList<String[]> tiemposEjecucion;
    private ArrayList<HiloUI> hilosUI;
    private MatrizSecuencial objSecuencial;
    private MatrizPorFilas objConcurrente;
    private MatrizPorBloques objPorBloques;

    public Main() {
        initComponents();
        objPopup = new PopupPanel();
        tiemposEjecucion = new ArrayList<String[]>();
        hilosUI = new ArrayList<>();
        objSecuencial = new MatrizSecuencial();
        objConcurrente = new MatrizPorFilas(this);
        objPorBloques = new MatrizPorBloques();

        HiloUI objHiloUI = new HiloUI("" + 1);
        pnlContenedorHilos.add(objHiloUI);
        hilosUI.add(objHiloUI);
    }

    @Override
    public void progresoActualizado(int hilo, double porcentaje) {
        hilosUI.get(hilo).actualizarPorcentaje(porcentaje);
        pnlContenedorHilos.repaint();
        pnlContenedorHilos.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAlgoritmos = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        pnlPreviewMatriz = new componentes.PreviewPanel();
        pnlLateral = new javax.swing.JPanel();
        pnlAlgoritmos = new javax.swing.JPanel();
        radioSecuencial = new javax.swing.JRadioButton();
        radioBloques = new javax.swing.JRadioButton();
        radioFilas = new javax.swing.JRadioButton();
        pnlMonitor = new javax.swing.JPanel();
        lblNumHilos = new javax.swing.JLabel();
        sliderNumHilos = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlContenedorHilos = new javax.swing.JPanel();
        pnlConfiguracion = new javax.swing.JPanel();
        btnDelMatrizB = new javax.swing.JButton();
        btnGenMatrizB = new javax.swing.JButton();
        btnDelMatrizA = new javax.swing.JButton();
        btnGenMatrizA = new javax.swing.JButton();
        pnlMatrizB = new javax.swing.JPanel();
        panelMatrizB = new componentes.panelMatriz();
        pnlMatrizA = new javax.swing.JPanel();
        panelMatrizA = new componentes.panelMatriz();
        btnHistorial = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(null);
        background.add(pnlPreviewMatriz);
        pnlPreviewMatriz.setBounds(10, 10, 800, 690);

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
        pnlAlgoritmos.add(radioSecuencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, -1));

        btnGroupAlgoritmos.add(radioBloques);
        radioBloques.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        radioBloques.setText("Algoritmo por Bloques");
        radioBloques.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioBloques.setFocusPainted(false);
        radioBloques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBloquesActionPerformed(evt);
            }
        });
        pnlAlgoritmos.add(radioBloques, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 300, -1));

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
        pnlAlgoritmos.add(radioFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 300, -1));

        pnlLateral.add(pnlAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 340, 120));

        pnlMonitor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlMonitor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumHilos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNumHilos.setText("Numero de hilos: 1");
        pnlMonitor.add(lblNumHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 290, 20));

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
        pnlMonitor.add(sliderNumHilos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 290, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedorHilos.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedorHilos.setLayout(new javax.swing.BoxLayout(pnlContenedorHilos, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlContenedorHilos);

        pnlMonitor.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, 100));

        pnlLateral.add(pnlMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 330, 230));

        pnlConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDelMatrizB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDelMatrizB.setText("*");
        btnDelMatrizB.setToolTipText("Borrar Matriz B");
        btnDelMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMatrizB.setFocusPainted(false);
        btnDelMatrizB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMatrizBActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnDelMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 30, 40, 20));

        btnGenMatrizB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnGenMatrizB.setText("Generar");
        btnGenMatrizB.setToolTipText("Generar Matriz B");
        btnGenMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizB.setFocusPainted(false);
        btnGenMatrizB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizBActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, 20));

        btnDelMatrizA.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDelMatrizA.setText("*");
        btnDelMatrizA.setToolTipText("Borrar Matriz A");
        btnDelMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMatrizA.setFocusPainted(false);
        btnDelMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMatrizAActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnDelMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 30, 40, 20));

        btnGenMatrizA.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnGenMatrizA.setText("Generar");
        btnGenMatrizA.setToolTipText("Generar Matriz A");
        btnGenMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizA.setFocusPainted(false);
        btnGenMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizAActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 80, 20));

        pnlMatrizB.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMatrizBMousePressed(evt);
            }
        });
        pnlMatrizB.setLayout(new java.awt.BorderLayout());
        pnlMatrizB.add(panelMatrizB, java.awt.BorderLayout.CENTER);

        pnlConfiguracion.add(pnlMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, 125, 125));

        pnlMatrizA.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMatrizAMousePressed(evt);
            }
        });
        pnlMatrizA.setLayout(new java.awt.BorderLayout());
        pnlMatrizA.add(panelMatrizA, java.awt.BorderLayout.CENTER);

        pnlConfiguracion.add(pnlMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, 125, 125));

        btnHistorial.setText("Historial");
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.setFocusPainted(false);
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 285, 30));

        pnlLateral.add(pnlConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 390, 330, 230));

        btnComenzar.setText("Comenzar");
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.setFocusPainted(false);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        pnlLateral.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 350, 50));

        background.add(pnlLateral);
        pnlLateral.setBounds(820, 10, 370, 690);

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenMatrizBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenMatrizBActionPerformed
        int filas;
        int columnas;

        if (matrizB != null) {
            JOptionPane.showMessageDialog(this, "Ya existe una Matriz B en memoria.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
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
        panelMatrizB.setVacio(false);
        panelMatrizB.setText(filas + "x" + columnas);
        panelMatrizB.repaint();
    }//GEN-LAST:event_btnGenMatrizBActionPerformed

    private void btnGenMatrizAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenMatrizAActionPerformed
        int filas;
        int columnas;

        if (matrizA != null) {
            JOptionPane.showMessageDialog(this, "Ya existe una Matriz A en memoria.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
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
        panelMatrizA.setVacio(false);
        panelMatrizA.setText(filas + "x" + columnas);
        panelMatrizA.repaint();
    }//GEN-LAST:event_btnGenMatrizAActionPerformed

    private void sliderNumHilosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderNumHilosStateChanged
        this.lblNumHilos.setText("Numero de hilos: " + sliderNumHilos.getValue());
    }//GEN-LAST:event_sliderNumHilosStateChanged

    private void sliderNumHilosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderNumHilosMouseReleased
        System.out.println("Numero de hilos establecido a: " + sliderNumHilos.getValue());
        hilosUI.removeAll(hilosUI);
        pnlContenedorHilos.removeAll();
        for (int i = 0; i < sliderNumHilos.getValue(); i++) {
            HiloUI objHiloUI = new HiloUI("" + (i + 1));
            pnlContenedorHilos.add(objHiloUI);
            hilosUI.add(objHiloUI);
        }
        pnlContenedorHilos.repaint();
        pnlContenedorHilos.revalidate();
    }//GEN-LAST:event_sliderNumHilosMouseReleased

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        if (matrizA[0].length != matrizB.length) {
            JOptionPane.showMessageDialog(this, "Las matrices no pueden multiplicadas.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        btnComenzar.setEnabled(false);

        // Event Dispatch Thread (EDT)
        // Se especifica que trabajara con una matriz y con un metodo void para actualizar la interfaz        
        SwingWorker<Integer, Void> worker = new SwingWorker<Integer, Void>() {
            int tiempoEjecucion = 0;
            String algoritmo = "";
            int[][] matrizResultante = null;

            @Override
            protected Integer doInBackground() {
                if (radioSecuencial.isSelected()) {
                    matrizResultante = objSecuencial.multiplicar(matrizA, matrizB);
                    algoritmo = "Metodo Secuencial";
                    tiempoEjecucion = objSecuencial.getTiempoEjecucion();
                } else if (radioFilas.isSelected()) {
                    objConcurrente.setNumHilos(sliderNumHilos.getValue());
                    matrizResultante = objConcurrente.multiplicar(matrizA, matrizB);
                    algoritmo = "Metodo Por Filas";
                    tiempoEjecucion = objConcurrente.getTiempoEjecucion();
                } else if (radioBloques.isSelected()) {
                    objPorBloques.setNumBloques(sliderNumHilos.getValue());
                    matrizResultante = objPorBloques.multiplicar(matrizA, matrizB);
                    algoritmo = "Metodo Por Bloques";
                    tiempoEjecucion = objPorBloques.getTiempoEjecucion();
                }
                return 0;
            }

            @Override
            protected void done() {
                try {
                    get(); // Obtiene la señar de que el proceso de doInBackground finalizo
                    String[] nuevoTiempo = {algoritmo, convertirTiempo(tiempoEjecucion), String.valueOf(tiempoEjecucion)};
                    btnComenzar.setEnabled(true);
                    pnlPreviewMatriz.setMatriz(matrizResultante);
                    tiemposEjecucion.add(nuevoTiempo);
                    JOptionPane.showMessageDialog(null, "Tiempo de ejecucion: " + convertirTiempo(tiempoEjecucion));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        worker.execute(); // Inicia el SwingWorker en un hilo separado
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void btnDelMatrizBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMatrizBActionPerformed
//        JOptionPane.showMessageDialog(this, "Matriz B Eliminada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        matrizB = null;
        tiemposEjecucion.removeAll(tiemposEjecucion);
        panelMatrizB.setVacio(true);
        panelMatrizB.repaint();
    }//GEN-LAST:event_btnDelMatrizBActionPerformed

    private void btnDelMatrizAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMatrizAActionPerformed
//        JOptionPane.showMessageDialog(this, "Matriz A Eliminada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        matrizA = null;
        tiemposEjecucion.removeAll(tiemposEjecucion);
        panelMatrizA.setVacio(true);
        panelMatrizA.repaint();
    }//GEN-LAST:event_btnDelMatrizAActionPerformed

    private void radioSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSecuencialActionPerformed
        deshabilitarMonitor();
    }//GEN-LAST:event_radioSecuencialActionPerformed

    private void radioFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFilasActionPerformed
        habilitarMonitor();
    }//GEN-LAST:event_radioFilasActionPerformed

    private void radioBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBloquesActionPerformed
        habilitarMonitor();
    }//GEN-LAST:event_radioBloquesActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (!tiemposEjecucion.isEmpty()) {
            StringBuilder mensaje = new StringBuilder();
            for (String[] tiempo : tiemposEjecucion) {
                mensaje.append(tiempo[0]); // Agrega el nombre del algoritmo
                mensaje.append(" -> ");
                mensaje.append(tiempo[1]); // Agrega el tiempo
                mensaje.append(" (");
                mensaje.append(tiempo[2]); // Agrega tiempo de ejecucion en milis.
                mensaje.append(" milisegundos");
                mensaje.append(")   ");
                mensaje.append("\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No hay registros.", "Informacion", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void pnlMatrizAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMatrizAMousePressed
        if (matrizA != null) {
            pnlPreviewMatriz.setMatriz(matrizA);
        } else {
            pnlPreviewMatriz.setMatrizVacia();
        }
    }//GEN-LAST:event_pnlMatrizAMousePressed

    private void pnlMatrizBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMatrizBMousePressed
        if (matrizB != null) {
            pnlPreviewMatriz.setMatriz(matrizB);
        } else {
            pnlPreviewMatriz.setMatrizVacia();
        }
    }//GEN-LAST:event_pnlMatrizBMousePressed

    public void habilitarMonitor() {
        this.sliderNumHilos.setEnabled(true);
    }

    public void deshabilitarMonitor() {
        this.sliderNumHilos.setEnabled(false);
    }

    public String convertirTiempo(long tiempoEnMilisegundos) {
        long segundosTotales = tiempoEnMilisegundos / 1000;
        long minutos = segundosTotales / 60;
        long segundos = segundosTotales % 60;
        long decimasSegundos = (tiempoEnMilisegundos % 1000) / 100;

        // Formatea la cadena en el formato minutos:segundos:decimas con 2 dijitos
        String tiempoFormateado = String.format("%02d:%02d:%02d", minutos, segundos, decimasSegundos);

        return tiempoFormateado;
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
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnDelMatrizA;
    private javax.swing.JButton btnDelMatrizB;
    private javax.swing.JButton btnGenMatrizA;
    private javax.swing.JButton btnGenMatrizB;
    private javax.swing.ButtonGroup btnGroupAlgoritmos;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumHilos;
    private componentes.panelMatriz panelMatrizA;
    private componentes.panelMatriz panelMatrizB;
    private javax.swing.JPanel pnlAlgoritmos;
    private javax.swing.JPanel pnlConfiguracion;
    private javax.swing.JPanel pnlContenedorHilos;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlMatrizA;
    private javax.swing.JPanel pnlMatrizB;
    private javax.swing.JPanel pnlMonitor;
    private componentes.PreviewPanel pnlPreviewMatriz;
    private javax.swing.JRadioButton radioBloques;
    private javax.swing.JRadioButton radioFilas;
    private javax.swing.JRadioButton radioSecuencial;
    private javax.swing.JSlider sliderNumHilos;
    // End of variables declaration//GEN-END:variables
}
