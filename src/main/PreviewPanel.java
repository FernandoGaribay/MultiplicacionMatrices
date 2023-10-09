package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PreviewPanel extends javax.swing.JPanel {

    private double zoom = 1.0;
    private drawPreview drawPreview;
    private Celda[][] matriz;

    private JButton zoomInButton;
    private JButton zoomOutButton;
    private JPanel pnlBotones;

    private Point puntoInicio; // Almacena la posición de inicio del arrastre
    private Point puntoFin;   // Almacena la posición de fin del arrastre
    private int offsetX = 0;
    private int offsetY = 0;

    // <editor-fold defaultstate="collapsed" desc="Constructor e inicializadores"> 
    public PreviewPanel() {
        initComponents();
        initControles();
        initEventos();

        this.add(drawPreview, BorderLayout.CENTER);
    }

    private void initEventos() {
        this.drawPreview = new drawPreview();

        // CLICK MOSTRAR COORDENADAS -------------------------------------------
        drawPreview.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                System.out.println("Click en: " + x + ", " + y);
            }
        });

        // BOTON AUMENTAR ZOOM -------------------------------------------------
        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoom *= 1.2; // Incrementa el zoom en un 20%
                drawPreview.repaint();
            }
        });

        // BOTON DISMINUIR ZOOM ------------------------------------------------
        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zoom /= 1.2; // Reduce el zoom en un 20%
                drawPreview.repaint();
            }
        });

        // PRESIONAR/LIBERAR CLICK PARA EL PUNTO INICIO/FIN --------------------
        drawPreview.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                puntoInicio = e.getPoint();
                puntoFin = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                puntoInicio = null;
                puntoFin = null;
            }
        });

        // ARRASTRAR MOUSE PARA ACTUALIZAR COORDENADAS -------------------------
        drawPreview.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (puntoInicio != null) {
                    puntoFin = e.getPoint();
                    int deltaX = (int) ((puntoFin.getX() - puntoInicio.getX()));
                    int deltaY = (int) ((puntoFin.getY() - puntoInicio.getY()));
                    offsetX -= deltaX;
                    offsetY -= deltaY;

                    System.out.println("Cord X: " + offsetX + ", Cord Y: " + offsetY);
                    drawPreview.repaint();
                    puntoInicio = e.getPoint();
                }
            }
        });

        // EVENTO RUEDA DEL RATON PARA AUMENTAR/DISMINUIR ZOOM -----------------
        drawPreview.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (zoom >= 1.0f) {
                    if (e.getWheelRotation() < 0) {
                        zoom *= 1.2;
                    } else {
                        zoom /= 1.2;
                    }
                    if (zoom < 1.0f) {
                        zoom = 1.0;
                    }
                    System.out.println("ZOOM: " + zoom);
                    drawPreview.repaint();
                }
            }
        });
    }

    private void initControles() {
        this.zoomInButton = new JButton("Zoom In");
        this.zoomOutButton = new JButton("Zoom Out");
        this.pnlBotones = new JPanel();
        pnlBotones.add(zoomInButton);
        pnlBotones.add(zoomOutButton);
        add(pnlBotones, BorderLayout.SOUTH);
    }
    //</editor-fold>

    public void setMatriz(int[][] matriz) {
        this.matriz = new Celda[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                this.matriz[i][j] = new Celda(matriz[i][j]);
                this.matriz[i][j].setRandomColorCelda(); // Colores al azar a la matriz
            }
        }
        this.drawPreview.repaint();
    }

    private class drawPreview extends JPanel {

        private int columnas;
        private int filas;
        private int tamañoCelda = 5;
        private int separacionCeldas = 1;

        @Override
        protected void paintComponent(Graphics g) {
            if (matriz != null) {
                super.paintComponent(g);
                Rectangle areaVisible = drawPreview.getVisibleRect();
                this.setBackground(new Color(244, 244, 244));
                this.filas = matriz.length;
                this.columnas = matriz[0].length;

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        int x = (int) (i * (tamañoCelda + separacionCeldas) * zoom) - offsetX;
                        int y = (int) (j * (tamañoCelda + separacionCeldas) * zoom) - offsetY;

                        if (areaVisible.intersects(x, y, (tamañoCelda * zoom), (tamañoCelda * zoom))) {
                            g.setColor(matriz[i][j].getColor());
                            g.fillRect(x, y, (int) (tamañoCelda * zoom), (int) (tamañoCelda * zoom));
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
