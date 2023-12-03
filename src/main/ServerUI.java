package main;

import componentes.PopupGenMatriz;
import interfaz.ServerInterface;
import interfaz.UserInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.MatrixMultiplierServer;

public class ServerUI extends javax.swing.JFrame {

    private int[][] matrizA = null;
    private int[][] matrizB = null;
    private PopupGenMatriz objPopup;

    private ServerInterface chatServer;

    private int filas = 0, columnas = 0;

    public ServerUI() {
        initComponents();
        objPopup = new PopupGenMatriz();
        try {
            String ipAddress = "192.168.1.87";
            System.setProperty("java.rmi.server.hostname", ipAddress);
            Registry registry = LocateRegistry.createRegistry(1234);

            chatServer = new MatrixMultiplierServer();
            registry.rebind("ChatServer", chatServer);
            System.out.println("ChatServer ready at " + ipAddress + "\n");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlPreviewMatriz = new componentes.PreviewPanel();
        pnlLateral = new javax.swing.JPanel();
        pnlAlgoritmos = new javax.swing.JPanel();
        radioSecuencial = new javax.swing.JRadioButton();
        radioBloques = new javax.swing.JRadioButton();
        radioFilas = new javax.swing.JRadioButton();
        pnlConfiguracion = new javax.swing.JPanel();
        btnDelMatrizB = new javax.swing.JButton();
        btnDelMatrizA = new javax.swing.JButton();
        btnGenMatrizDimensiones = new javax.swing.JButton();
        pnlMatrizB = new javax.swing.JPanel();
        panelMatrizB = new componentes.panelMatriz();
        pnlMatrizA = new javax.swing.JPanel();
        panelMatrizA = new componentes.panelMatriz();
        btnHistorial = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnlPreviewMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 690));

        pnlLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAlgoritmos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algoritmos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlAlgoritmos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pnlLateral.add(pnlAlgoritmos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 120));

        pnlConfiguracion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDelMatrizB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDelMatrizB.setText("Generar Matriz B");
        btnDelMatrizB.setToolTipText("Borrar Matriz B");
        btnDelMatrizB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMatrizB.setFocusPainted(false);
        btnDelMatrizB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMatrizBActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnDelMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 125, 20));

        btnDelMatrizA.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDelMatrizA.setText("Generar Matriz A");
        btnDelMatrizA.setToolTipText("Borrar Matriz A");
        btnDelMatrizA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMatrizA.setFocusPainted(false);
        btnDelMatrizA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMatrizAActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnDelMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 125, 20));

        btnGenMatrizDimensiones.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnGenMatrizDimensiones.setText("Configurar dimensiones");
        btnGenMatrizDimensiones.setToolTipText("Generar Matriz A");
        btnGenMatrizDimensiones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenMatrizDimensiones.setFocusPainted(false);
        btnGenMatrizDimensiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenMatrizDimensionesActionPerformed(evt);
            }
        });
        pnlConfiguracion.add(btnGenMatrizDimensiones, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 135, 30));

        pnlMatrizB.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizB.setLayout(new java.awt.BorderLayout());

        panelMatrizB.setText("");
        panelMatrizB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMatrizBMousePressed(evt);
            }
        });
        pnlMatrizB.add(panelMatrizB, java.awt.BorderLayout.CENTER);

        pnlConfiguracion.add(pnlMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, 125, 125));

        pnlMatrizA.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizA.setLayout(new java.awt.BorderLayout());

        panelMatrizA.setText("");
        panelMatrizA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMatrizAMousePressed(evt);
            }
        });
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
        pnlConfiguracion.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 190, 135, 30));

        pnlLateral.add(pnlConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 330, 230));

        btnComenzar.setText("Comenzar");
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.setFocusPainted(false);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        pnlLateral.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 350, 50));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuarios Conectados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jList1.setBackground(new java.awt.Color(242, 242, 242));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        pnlLateral.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 330, 210));

        jPanel1.add(pnlLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 370, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioSecuencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSecuencialActionPerformed

    }//GEN-LAST:event_radioSecuencialActionPerformed

    private void radioBloquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBloquesActionPerformed

    }//GEN-LAST:event_radioBloquesActionPerformed

    private void radioFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFilasActionPerformed

    }//GEN-LAST:event_radioFilasActionPerformed

    private void btnDelMatrizBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMatrizBActionPerformed
        if (filas != 0 && columnas != 0) {
            try {
                long seedB = ThreadLocalRandom.current().nextLong(10000L, 100000L);

                panelMatrizB.setVacio(false);
                panelMatrizB.setText(filas + "x" + columnas);
                panelMatrizB.repaint();

                chatServer.broadcastSeedB(seedB);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDelMatrizBActionPerformed

    private void btnDelMatrizAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMatrizAActionPerformed
        if (filas != 0 && columnas != 0) {
            try {
                long seedA = ThreadLocalRandom.current().nextLong(10000L, 100000L);

                panelMatrizA.setVacio(false);
                panelMatrizA.setText(filas + "x" + columnas);
                panelMatrizA.repaint();

                chatServer.broadcastSeedA(seedA);
            } catch (RemoteException ex) {
                Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDelMatrizAActionPerformed

    private void btnGenMatrizDimensionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenMatrizDimensionesActionPerformed
        objPopup.showPopup();
        this.filas = objPopup.getFilas();
        this.columnas = objPopup.getColumnas();

        panelMatrizA.setText(filas + "x" + columnas);
        panelMatrizA.repaint();
        panelMatrizB.setText(filas + "x" + columnas);
        panelMatrizB.repaint();
    }//GEN-LAST:event_btnGenMatrizDimensionesActionPerformed

    private void panelMatrizBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMatrizBMousePressed
        try {
            pnlPreviewMatriz.setMatriz(chatServer.getMatrizB(filas, columnas));
        } catch (RemoteException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_panelMatrizBMousePressed

    private void panelMatrizAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMatrizAMousePressed
        try {
            int[][] matriz = chatServer.getMatrizA(filas, columnas);
            pnlPreviewMatriz.setMatriz(matriz);

            int filas = matriz.length;
            int columnas = matriz[0].length;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_panelMatrizAMousePressed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed

    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        try {
            // Repartir matriz
            try {
                int totalClients = chatServer.getConnectedUsers().size();
                int rowsPerClient = filas / totalClients;
                int remainingRows = filas % totalClients;

                int assignedRows = 0;
                for (int i = 0; i < totalClients; i++) {
                    int currentRows = rowsPerClient;

                    if (remainingRows > 0) {
                        currentRows++;
                        remainingRows--;
                    }

                    if ((assignedRows + currentRows) > filas) {
                        currentRows = filas - assignedRows;
                    }

                    UserInterface usuario = chatServer.getConnectedUsers().get(i);
                    chatServer.mandarMatrices(assignedRows, (assignedRows + currentRows - 1), filas, columnas, usuario);

                    assignedRows += currentRows;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            pnlPreviewMatriz.setMatriz(chatServer.getResul());
        } catch (RemoteException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

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
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnDelMatrizA;
    private javax.swing.JButton btnDelMatrizB;
    private javax.swing.JButton btnGenMatrizDimensiones;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private componentes.panelMatriz panelMatrizA;
    private componentes.panelMatriz panelMatrizB;
    private javax.swing.JPanel pnlAlgoritmos;
    private javax.swing.JPanel pnlConfiguracion;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlMatrizA;
    private javax.swing.JPanel pnlMatrizB;
    private componentes.PreviewPanel pnlPreviewMatriz;
    private javax.swing.JRadioButton radioBloques;
    private javax.swing.JRadioButton radioFilas;
    private javax.swing.JRadioButton radioSecuencial;
    // End of variables declaration//GEN-END:variables
}
