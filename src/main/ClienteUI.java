package main;

import interfaz.ServerInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.MatrixMultiplierClient;

public class ClienteUI extends javax.swing.JFrame {

    private String usuario;
    private String servidorIP;

    private ServerInterface chatServer;
    private MatrixMultiplierClient client;

    public ClienteUI() {
        initComponents();
        this.usuario = "";
        this.servidorIP = "";

        try {
            String name = "fer";
            String serverIP = "192.168.1.87";
            Registry registry = LocateRegistry.getRegistry(serverIP, 1234);

            chatServer = (ServerInterface) registry.lookup("ChatServer");
            client = new MatrixMultiplierClient(name, chatServer);
            client.setPanelsListeners(pnlPreviewMatriz, panelMatrizA, panelMatrizB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlPreviewMatriz = new componentes.PreviewPanel();
        pnlLateral = new javax.swing.JPanel();
        pnlMatrices = new javax.swing.JPanel();
        pnlMatrizB = new javax.swing.JPanel();
        panelMatrizB = new componentes.panelMatriz();
        pnlMatrizA = new javax.swing.JPanel();
        panelMatrizA = new componentes.panelMatriz();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JButton();
        pnlMonitor = new javax.swing.JPanel();
        lblNumHilos = new javax.swing.JLabel();
        sliderNumHilos = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlContenedorHilos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        textIPServidor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pnlPreviewMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 690));

        pnlLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMatrices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrices", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlMatrices.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMatrizB.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMatrizB.setText("");
        panelMatrizB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMatrizBMousePressed(evt);
            }
        });
        pnlMatrizB.add(panelMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 125, 125));

        pnlMatrices.add(pnlMatrizB, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 55, 125, 125));

        pnlMatrizA.setBackground(new java.awt.Color(255, 255, 255));
        pnlMatrizA.setLayout(new java.awt.BorderLayout());

        panelMatrizA.setText("");
        panelMatrizA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMatrizAMousePressed(evt);
            }
        });
        pnlMatrizA.add(panelMatrizA, java.awt.BorderLayout.CENTER);

        pnlMatrices.add(pnlMatrizA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, 125, 125));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Matriz A");
        pnlMatrices.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 30, 125, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Matriz A");
        pnlMatrices.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 125, -1));

        pnlLateral.add(pnlMatrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 330, 200));

        btnComenzar.setText("Comenzar");
        btnComenzar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComenzar.setFocusPainted(false);
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        pnlLateral.add(btnComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 350, 50));

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

        pnlLateral.add(pnlMonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 330, 230));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Credenciales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Usuario");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, -1));
        jPanel2.add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, 30));
        jPanel2.add(textIPServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 290, 30));

        jLabel4.setText("IP del Servidor");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, -1));

        pnlLateral.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 320, 140));

        jPanel1.add(pnlLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 370, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelMatrizBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMatrizBMousePressed
        client.getMatrizB();
    }//GEN-LAST:event_panelMatrizBMousePressed

    private void panelMatrizAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMatrizAMousePressed
        client.getMatrizA();
    }//GEN-LAST:event_panelMatrizAMousePressed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        if (!textUsuario.getText().isEmpty() && !textIPServidor.getText().isEmpty()) {
            this.usuario = textUsuario.getText();
            this.servidorIP = textIPServidor.getText();

            System.out.println("conectar a servidor");
        }
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void sliderNumHilosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderNumHilosStateChanged
        this.lblNumHilos.setText("Numero de hilos: " + sliderNumHilos.getValue());
    }//GEN-LAST:event_sliderNumHilosStateChanged

    private void sliderNumHilosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderNumHilosMouseReleased

    }//GEN-LAST:event_sliderNumHilosMouseReleased

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
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumHilos;
    private componentes.panelMatriz panelMatrizA;
    private componentes.panelMatriz panelMatrizB;
    private javax.swing.JPanel pnlContenedorHilos;
    private javax.swing.JPanel pnlLateral;
    private javax.swing.JPanel pnlMatrices;
    private javax.swing.JPanel pnlMatrizA;
    private javax.swing.JPanel pnlMatrizB;
    private javax.swing.JPanel pnlMonitor;
    private componentes.PreviewPanel pnlPreviewMatriz;
    private javax.swing.JSlider sliderNumHilos;
    private javax.swing.JTextField textIPServidor;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
