package componentes;

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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

public class PreviewPanel extends javax.swing.JPanel {

    private double zoom = 1.0;
    private double velocidad = 1.0;
    private drawPreview drawPreview = new drawPreview();
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
        setMatrizVacia();
        initControles();
        initEventos();

        this.add(drawPreview, BorderLayout.CENTER);
    }

    public void setMatrizVacia() {
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

        // BOTON DE CONFIGURACION ----------------------------------------------
        configButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Popup objPopup = new Popup();
                objPopup.showPopup();
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
                    int deltaX = (int) ((puntoFin.getX() - puntoInicio.getX()) * velocidad);
                    int deltaY = (int) ((puntoFin.getY() - puntoInicio.getY()) * velocidad);
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
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
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
                        int x = (int) (j * (tamañoCelda + separacionCeldas) * zoom) - offsetX;
                        int y = (int) (i * (tamañoCelda + separacionCeldas) * zoom) - offsetY;

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

    class Popup extends JPanel {

        private JDialog popup;

        public Popup() {
            initComponents();
            initPopup();
        }

        public void initPopup() {
            popup = new JDialog();
            popup.setTitle("Configuracion");
            popup.setModal(true);
            popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            sliderVelocidad.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    lblVelocidad.setText("Velocidad de desplazamiento: x" + sliderVelocidad.getValue() / 100 + ".0");
                }
            });

            btnAceptar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    velocidad = sliderVelocidad.getValue() / 100;
                    popup.dispose();
                }
            });

            btnCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    popup.dispose();
                }
            });
        }

        public void showPopup() {
            int popupWidth = 400;
            int popupHeight = 150;

            popup.setSize(new Dimension(popupWidth, popupHeight + 40));
            popup.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

            int pnlMensajeHeight = (int) (popupHeight * 0.80);
            int pnlControlesHeight = (int) (popupHeight * 0.20);

            setPreferredSize(new Dimension(popupWidth, popupHeight));
            pnlControles.setPreferredSize(new Dimension(popupWidth, pnlControlesHeight));
            pnlMensaje.setPreferredSize(new Dimension(popupWidth, pnlMensajeHeight));
            lblVelocidad.setText("Velocidad de desplazamiento: x" + sliderVelocidad.getValue() / 100 + ".0");

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

        public void initComponents() {

            pnlMensaje = new JPanel();
            pnlSeparacion1 = new JPanel();
            lblVelocidad = new JLabel();
            pnlSeparacion2 = new JPanel();
            sliderVelocidad = new JSlider();
            pnlControles = new JPanel();
            btnAceptar = new JButton();
            btnCancelar = new JButton();

            FlowLayout flowLayout2 = new FlowLayout(FlowLayout.CENTER, 0, 0);
            flowLayout2.setAlignOnBaseline(true);
            setLayout(flowLayout2);

            pnlMensaje.setBackground(new Color(255, 255, 255));
            pnlMensaje.setPreferredSize(new Dimension(400, 250));
            pnlMensaje.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));

            pnlSeparacion1.setBackground(new Color(255, 255, 255));
            pnlSeparacion1.setPreferredSize(new Dimension(1000, 20));
            pnlMensaje.add(pnlSeparacion1);

            lblVelocidad.setFont(new Font("Arial", 0, 14)); // NOI18N
            lblVelocidad.setHorizontalAlignment(SwingConstants.CENTER);
            lblVelocidad.setText("Velocidad de desplazamiento: x1.0");
            pnlMensaje.add(lblVelocidad);

            pnlSeparacion2.setBackground(new Color(255, 255, 255));
            pnlSeparacion2.setPreferredSize(new Dimension(1000, 20));
            pnlMensaje.add(pnlSeparacion2);

            sliderVelocidad.setBackground(new java.awt.Color(255, 255, 255));
            sliderVelocidad.setMajorTickSpacing(100);
            sliderVelocidad.setMaximum(500);
            sliderVelocidad.setMinimum(100);
            sliderVelocidad.setPaintTicks(true);
            sliderVelocidad.setSnapToTicks(true);
            sliderVelocidad.setValue((int) velocidad * 100);
            sliderVelocidad.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
            sliderVelocidad.setFocusable(false);
            pnlMensaje.add(sliderVelocidad);

            add(pnlMensaje);

            pnlControles.setPreferredSize(new Dimension(400, 50));
            FlowLayout flowLayout1 = new FlowLayout(FlowLayout.CENTER, 120, 5);
            flowLayout1.setAlignOnBaseline(true);
            pnlControles.setLayout(flowLayout1);

            btnAceptar.setText("Aceptar");
            pnlControles.add(btnAceptar);

            btnCancelar.setText("Cancelar");
            pnlControles.add(btnCancelar);

            add(pnlControles);
        }

        //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">  
        private JButton btnAceptar;
        private JButton btnCancelar;
        private JLabel lblVelocidad;
        private JPanel pnlControles;
        private JPanel pnlMensaje;
        private JPanel pnlSeparacion1;
        private JPanel pnlSeparacion2;
        private JSlider sliderVelocidad;
        //</editor-fold>  
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

class Celda {

    private int valor;
    private Color color;

    public Celda(Color bgColor) {
        this.color = bgColor;
    }

    public Celda(int valor) {
        this.valor = valor;
        this.color = new Color(210, 210, 210);
    }

    public void setRandomColorCelda() {
        Random rand = new Random();

        this.color = Color.getHSBColor(rand.nextFloat(), 1, 1);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
