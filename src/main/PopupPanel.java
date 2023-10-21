package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PopupPanel extends javax.swing.JPanel {

    private JDialog popup;

    public PopupPanel() {
        initComponents();
        initPopup();
    }

    public void initPopup() {
        popup = new JDialog();
        popup.setTitle("Popup");
        popup.setModal(true);
        popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                popup.dispose();
            }
        });
    }

    public void showPopup(String mensaje) {
        
        int popupWidth = 900;
        int popupHeight = 900;
        
        popup.setSize(new Dimension(popupWidth, popupHeight+40));
        popup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        int pnlMensajeHeight = (int) (popupHeight * 0.80);
        int pnlControlesHeight = (int) (popupHeight * 0.20);

        setPreferredSize(new Dimension(popupWidth, popupHeight));
        pnlControles.setPreferredSize(new Dimension(popupWidth, pnlControlesHeight));
        pnlMensaje.setPreferredSize(new Dimension(popupWidth, pnlMensajeHeight));
                
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
        pnlSeparacion1 = new javax.swing.JPanel();
        lblVelocidad = new javax.swing.JLabel();
        pnlSeparacion2 = new javax.swing.JPanel();
        sliderVelocidad = new javax.swing.JSlider();
        pnlControles = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0);
        flowLayout2.setAlignOnBaseline(true);
        setLayout(flowLayout2);

        pnlMensaje.setBackground(new java.awt.Color(255, 255, 255));
        pnlMensaje.setPreferredSize(new java.awt.Dimension(400, 250));
        pnlMensaje.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 0));

        pnlSeparacion1.setBackground(new java.awt.Color(255, 255, 255));
        pnlSeparacion1.setPreferredSize(new java.awt.Dimension(1000, 20));
        pnlMensaje.add(pnlSeparacion1);

        lblVelocidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblVelocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVelocidad.setText("Velocidad de Zoom");
        pnlMensaje.add(lblVelocidad);

        pnlSeparacion2.setBackground(new java.awt.Color(255, 255, 255));
        pnlSeparacion2.setPreferredSize(new java.awt.Dimension(1000, 20));
        pnlMensaje.add(pnlSeparacion2);

        sliderVelocidad.setBackground(new java.awt.Color(255, 255, 255));
        sliderVelocidad.setMajorTickSpacing(100);
        sliderVelocidad.setMaximum(500);
        sliderVelocidad.setMinimum(100);
        sliderVelocidad.setPaintTicks(true);
        sliderVelocidad.setSnapToTicks(true);
        sliderVelocidad.setValue(100);
        sliderVelocidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderVelocidad.setFocusable(false);
        pnlMensaje.add(sliderVelocidad);

        add(pnlMensaje);

        pnlControles.setPreferredSize(new java.awt.Dimension(400, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 120, 15);
        flowLayout1.setAlignOnBaseline(true);
        pnlControles.setLayout(flowLayout1);

        btnAceptar.setText("Aceptar");
        pnlControles.add(btnAceptar);

        btnCancelar.setText("Cancelar");
        pnlControles.add(btnCancelar);

        add(pnlControles);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        PopupPanel popupPanel = new PopupPanel();
        popupPanel.showPopup("Test Popup");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblVelocidad;
    private javax.swing.JPanel pnlControles;
    private javax.swing.JPanel pnlMensaje;
    private javax.swing.JPanel pnlSeparacion1;
    private javax.swing.JPanel pnlSeparacion2;
    private javax.swing.JSlider sliderVelocidad;
    // End of variables declaration//GEN-END:variables
}
