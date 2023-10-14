package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
    private JButton centerButton;
    private JButton zoomOutButton;
    private JButton configButton;

    private Point puntoInicio; // Punto de inicio del arrastre
    private Point puntoFin;   // Punto de del fin del arrastre
    private int offsetX = 0;
    private int offsetY = 0;

    private int tamañoCelda = 5;
    private int separacionCeldas = 2;

    // <editor-fold defaultstate="collapsed" desc="Constructor e inicializadores"> 
    public PreviewPanel() {
        initComponents();
        initGraficos();
        initControles();
        initEventos();

        this.add(drawPreview, BorderLayout.CENTER);
    }

    private void initGraficos() {
        this.drawPreview = new drawPreview();
        this.matriz = new Celda[150][150];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                this.matriz[i][j] = new Celda(new Color(240, 240, 240));
            }
        }
        this.drawPreview.repaint();
    }

    private void initControles() {
        Controles pnlControles = new Controles();
        add(pnlControles, BorderLayout.SOUTH);
    }

    private void initEventos() {

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
                if (zoom > 1.0f) {
                    zoom /= 1.2; // Reduce el zoom en un 20%
                    drawPreview.repaint();
                } else {
                    zoom = 1.0;
                }
            }
        });

        // BOTON CENTRAR MATRIZ ------------------------------------------------
        centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offsetX = 0;
                offsetY = 0;
                zoom = 1.0;
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

        @Override
        protected void paintComponent(Graphics g) {
            if (matriz != null) {
                super.paintComponent(g);
                Rectangle areaVisible = drawPreview.getVisibleRect();
                this.setBackground(new Color(255, 255, 255));
                this.filas = matriz.length;
                this.columnas = matriz[0].length;

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        int x = (int) (i * (tamañoCelda + separacionCeldas) * zoom) - offsetX;
                        int y = (int) (j * (tamañoCelda + separacionCeldas) * zoom) - offsetY;

                        if (areaVisible.intersects(x, y, (tamañoCelda * zoom), (tamañoCelda * zoom))) {
                            g.setColor(matriz[i][j].getColor());
                            g.fillRect(x, y, (int) (tamañoCelda * zoom), (int) (tamañoCelda * zoom));

                            if (zoom >= 8.0) {
                                Graphics2D g2d = (Graphics2D) g;

                                String texto = String.valueOf(matriz[i][j].getValor());
                                Font font = new Font("TimesRoman", Font.BOLD, (int) (1.5 * zoom));
                                FontMetrics fm = g2d.getFontMetrics(font);

                                int xTexto = (int) ((x + (tamañoCelda * zoom) / 2) - fm.stringWidth(texto) / 2);
                                int yTexto = (int) (y + ((tamañoCelda * zoom) / 2) + (fm.getAscent() - fm.getDescent()) / 2);

                                g2d.setColor(Color.BLACK);
                                g2d.setFont(font);
                                g2d.drawString(texto, xTexto, yTexto);
//                                g2d.fillOval(xTexto, yTexto, 10, 10);
                            }
                        }
                    }
                }
            }
        }
    }

    class Controles extends JPanel {

        private int alturaBotones;
        private int hGap;

        private JPanel izquierda;
        private JPanel centrar;
        private JPanel derecha;

        public Controles() {
            initComponentes();

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int panelWidth = (int) (getWidth());
                    int panelHeigh = (int) (getHeight());
                    int panelLateralWidth = (int) (panelWidth * 0.20);
                    int panelCentralwidth = (int) (panelWidth * 0.60);
                    hGap = (int) ((getPreferredSize().getHeight() / 2) - centerButton.getPreferredSize().getHeight() / 2);

//                    System.out.println("width; " + panelWidth);
                    izquierda.setLayout(new FlowLayout(FlowLayout.CENTER, 10, hGap));
                    izquierda.setPreferredSize(new Dimension(panelLateralWidth, panelHeigh));
//                    System.out.println("Width izquierda; " + (int) (panelWidth * 0.20));

                    centrar.setPreferredSize(new Dimension(panelCentralwidth, panelHeigh));
                    centrar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, hGap));
//                    System.out.println("Width centrar; " + (int) (panelWidth * 0.60));

                    derecha.setPreferredSize(new Dimension(panelLateralWidth, panelHeigh));
//                    System.out.println("Width derecha; " + (int) (panelWidth * 0.20));

                    revalidate();
                }
            });
        }

        public void initComponentes() {
            setPreferredSize(new Dimension((int) (this.getPreferredSize().getWidth()), 30));
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

            this.alturaBotones = (int) (getPreferredSize().getHeight() * 0.8); // Margen Vertical con relacion a 80%

            pnlIzquierda();
            pnlCentral();
            pnlDerecha();

            add(izquierda);
            add(centrar);
            add(derecha);
        }

        public void pnlIzquierda() {
            izquierda = new JPanel();

            configButton = new JButton("Configuracion");

            configButton.setPreferredSize(new Dimension(100, alturaBotones));

            configButton.setFocusPainted(false);

            configButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            izquierda.setBackground(new Color(153, 219, 254));
            izquierda.add(configButton);
        }

        public void pnlCentral() {
            centrar = new JPanel();

            zoomInButton = new JButton("Zoom In");
            centerButton = new JButton("[]");
            zoomOutButton = new JButton("Zoom Out");

            zoomInButton.setPreferredSize(new Dimension(100, alturaBotones));
            centerButton.setPreferredSize(new Dimension(50, alturaBotones));
            zoomOutButton.setPreferredSize(new Dimension(100, alturaBotones));

            zoomInButton.setFocusPainted(false);
            centerButton.setFocusPainted(false);
            zoomOutButton.setFocusPainted(false);

            zoomInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            centerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            zoomOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            centrar.setBackground(new Color(153, 219, 254));
            centrar.add(zoomInButton);
            centrar.add(centerButton);
            centrar.add(zoomOutButton);
        }

        public void pnlDerecha() {
            derecha = new JPanel();
            derecha.setBackground(new Color(153, 219, 254));
        }
    }

    public int getTamañoCelda() {
        return tamañoCelda;
    }

    public void setTamañoCelda(int tamañoCelda) {
        this.tamañoCelda = tamañoCelda;
    }

    public int getSeparacionCeldas() {
        return separacionCeldas;
    }

    public void setSeparacionCeldas(int separacionCeldas) {
        this.separacionCeldas = separacionCeldas;
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
