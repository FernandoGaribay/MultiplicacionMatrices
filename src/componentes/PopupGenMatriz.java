package componentes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.Timer;

public class PopupGenMatriz extends javax.swing.JPanel {

    private JDialog popup;
    private int[][] matriz;

    public PopupGenMatriz() {
        initComponents();
        initPopup();

    }

    public void initPopup() {
        lblError.setVisible(false);
        popup = new JDialog();
        popup.setTitle("Generar Matriz");
        popup.setModal(true);
        popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void showPopup() {
        int popupWidth = 600;
        int popupHeight = 340;

        popup.setSize(new Dimension(popupWidth, popupHeight + 40));
        centrarPopup();
        popup.add(this);
        popup.setVisible(true);
    }

    public void centrarPopup() {
        Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((pantallaSize.getWidth() - popup.getWidth()) / 2);
        int centerY = (int) ((pantallaSize.getHeight() - popup.getHeight()) / 2);
        popup.setLocation(centerX, centerY);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMensaje = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnl2000 = new componentes.panelMatriz();
        pnl500 = new componentes.panelMatriz();
        pn1000 = new componentes.panelMatriz();
        pnl1500 = new componentes.panelMatriz();
        lblColumnas = new javax.swing.JLabel();
        textColumnas = new javax.swing.JTextField();
        textFilas = new javax.swing.JTextField();
        lblFilas = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        pnlMensaje.setBackground(new java.awt.Color(255, 255, 255));
        pnlMensaje.setPreferredSize(new java.awt.Dimension(400, 250));
        pnlMensaje.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Generar Matriz Aleatoria");
        pnlMensaje.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 540, 30));

        pnl2000.setText("2000x2000");
        pnl2000.setVacio(false);
        pnl2000.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl2000MousePressed(evt);
            }
        });
        pnlMensaje.add(pnl2000, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 125, 125));

        pnl500.setText("500x500");
        pnl500.setVacio(false);
        pnl500.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl500MousePressed(evt);
            }
        });
        pnlMensaje.add(pnl500, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 125, 125));

        pn1000.setText("1000x1000");
        pn1000.setVacio(false);
        pn1000.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pn1000MousePressed(evt);
            }
        });
        pnlMensaje.add(pn1000, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 125, 125));

        pnl1500.setText("1500x1500");
        pnl1500.setVacio(false);
        pnl1500.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl1500MousePressed(evt);
            }
        });
        pnlMensaje.add(pnl1500, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 125, 125));

        lblColumnas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblColumnas.setText("Columnas: ");
        pnlMensaje.add(lblColumnas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 260, 20));

        textColumnas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textColumnas.setToolTipText("Columnas");
        pnlMensaje.add(textColumnas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 260, 30));

        textFilas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnlMensaje.add(textFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 235, 260, 30));

        lblFilas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFilas.setText("Filas:");
        pnlMensaje.add(lblFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 215, 260, 20));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlMensaje.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 260, 40));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlMensaje.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 235, 260, 40));

        lblError.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Uno de los campos estan vacios.");
        pnlMensaje.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 280, 20));

        add(pnlMensaje, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        matriz = null;
        popup.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void pnl500MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl500MousePressed
        this.matriz = generarMatriz(500, 500);
        this.popup.dispose();
    }//GEN-LAST:event_pnl500MousePressed

    private void pn1000MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pn1000MousePressed
        this.matriz = generarMatriz(1000, 1000);
        this.popup.dispose();
    }//GEN-LAST:event_pn1000MousePressed

    private void pnl1500MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl1500MousePressed
        this.matriz = generarMatriz(1500, 1500);
        this.popup.dispose();
    }//GEN-LAST:event_pnl1500MousePressed

    private void pnl2000MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl2000MousePressed
        this.matriz = generarMatriz(2000, 2000);
        this.popup.dispose();
    }//GEN-LAST:event_pnl2000MousePressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int filas = 0, columnas = 0;

        if (textFilas.getText().isEmpty() || textColumnas.getText().isEmpty()) {
            mostrarError();
            return;
        }

        filas = Integer.parseInt(textFilas.getText());
        columnas = Integer.parseInt(textColumnas.getText());
        this.matriz = generarMatriz(filas, columnas);
        this.popup.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public void mostrarError() {
        lblError.setVisible(true);
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblError.setVisible(false);
            }
        });
        timer.start();
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

    public int[][] getMatriz() {
        return matriz;
    }

    public static void main(String[] args) {
        PopupGenMatriz popupPanel = new PopupGenMatriz();
        popupPanel.showPopup();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblColumnas;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFilas;
    private javax.swing.JLabel lblTitulo;
    private componentes.panelMatriz pn1000;
    private componentes.panelMatriz pnl1500;
    private componentes.panelMatriz pnl2000;
    private componentes.panelMatriz pnl500;
    private javax.swing.JPanel pnlMensaje;
    private javax.swing.JTextField textColumnas;
    private javax.swing.JTextField textFilas;
    // End of variables declaration//GEN-END:variables
}
