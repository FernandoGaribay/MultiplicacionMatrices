package main;

import componentes.PopupGenMatriz;
import interfaz.ServerInterface;
import interfaz.UserInterface;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.MatrixMultiplierServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ServerUI extends javax.swing.JFrame {

    private Registry registry;
    private PopupGenMatriz objPopup;

    private ServerInterface chatServer;

    private int filas = 0, columnas = 0;

    public ServerUI() {
        initComponents();
        objPopup = new PopupGenMatriz();
        try {
            String ipAddress = "192.168.1.87";
            System.setProperty("java.rmi.server.hostname", ipAddress);
            registry = LocateRegistry.createRegistry(1234);

            chatServer = new MatrixMultiplierServer();
            chatServer.setListUsers(jList1);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnlPreviewMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 690));

        pnlLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jList1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        pnlLateral.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 350));

        jPanel1.add(pnlLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 370, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        try {
            objPopup.showPopup();
            this.filas = objPopup.getFilas();
            this.columnas = objPopup.getColumnas();
            
            chatServer.resetResul();
            pnlPreviewMatriz.setMatrizVacia();
            panelMatrizA.setVacio(true);
            panelMatrizA.setText(filas + "x" + columnas);
            panelMatrizA.repaint();
            panelMatrizB.setVacio(true);
            panelMatrizB.setText(filas + "x" + columnas);
            panelMatrizB.repaint();
        } catch (RemoteException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            pnlPreviewMatriz.setMatriz(chatServer.getMatrizA(filas, columnas));
        } catch (RemoteException ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_panelMatrizAMousePressed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed

    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        try {
            int totalClients = chatServer.getConnectedUsers().size();
            int rowsPerClient = filas / totalClients;
            int remainingRows = filas % totalClients;

            int assignedRows = 0;

            // Lista para almacenar los resultados futuros
            List<Future<Void>> futures = new ArrayList<>();

            // Crear un ExecutorService para administrar los hilos
            ExecutorService executor = Executors.newFixedThreadPool(totalClients);

            for (int i = 0; i < totalClients; i++) {
                final int currentRows = rowsPerClient;  // Hacer final la variable local

                int updatedRows = currentRows;  // Utilizar una nueva variable no final para almacenar el valor actualizado

                if (remainingRows > 0) {
                    updatedRows++;
                    remainingRows--;
                }

                if ((assignedRows + updatedRows) > filas) {
                    updatedRows = filas - assignedRows;
                }

                final UserInterface usuario = chatServer.getConnectedUsers().get(i);  // Hacer final la variable local
                final int finalAssignedRows = assignedRows;  // Crear una variable final adicional
                final int finalUpdatedRows = updatedRows;

                // Utilizar Callable para ejecutar la lógica y devolver un resultado
                Callable<Void> task = () -> {
                    chatServer.mandarMatrices(finalAssignedRows, (finalAssignedRows + finalUpdatedRows - 1), filas, columnas, usuario);
                    return null;
                };

                // Enviar la tarea al ExecutorService y almacenar el Future en la lista
                futures.add(executor.submit(task));

                assignedRows += updatedRows;
            }

            // Esperar a que todas las tareas se completen
            for (Future<Void> future : futures) {
                future.get();
            }

            // Apagar el ExecutorService
            executor.shutdown();

            pnlPreviewMatriz.setMatriz(chatServer.getResul());
        } catch (Exception ex) {
            Logger.getLogger(ServerUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (registry != null) {
            try {
                // Desvincula el objeto del registro antes de cerrar el registro
                registry.unbind("ChatServer");
            } catch (Exception e) {
                // Maneja cualquier excepción que pueda ocurrir al desvincular
                e.printStackTrace();
            }

            try {
                // Cierra el registro
                UnicastRemoteObject.unexportObject(registry, true);
            } catch (Exception e) {
                // Maneja cualquier excepción que pueda ocurrir al cerrar el registro
                e.printStackTrace();
            }
        }

        Main vtnMain = new Main();
        vtnMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
    private javax.swing.JPanel pnlConfiguracion;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlMatrizA;
    private javax.swing.JPanel pnlMatrizB;
    private componentes.PreviewPanel pnlPreviewMatriz;
    // End of variables declaration//GEN-END:variables
}
