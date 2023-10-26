package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JPanel;

public class panelMatriz extends JPanel {

    private boolean vacio;
    private boolean handCursor;
    private int numCeldas;
    private int separacionCelda;
    private String text;

    public panelMatriz() {
        this.vacio = true;
        this.handCursor = true;
        this.numCeldas = 10;
        this.separacionCelda = 2;
        this.text = "100x100";

        initEventos();
        repaint();
    }

    public panelMatriz(String text) {
        this.vacio = true;
        this.numCeldas = 10;
        this.separacionCelda = 2;
        this.text = text;

        repaint();
    }

    private void initEventos() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (handCursor) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Random random = new Random();
        int tamanioCelda = getWidth() / numCeldas;
        setBackground(Color.WHITE);
        for (int i = 0; i <= numCeldas; i++) {
            for (int j = 0; j <= numCeldas; j++) {
                int x = i * (tamanioCelda + separacionCelda);
                int y = j * (tamanioCelda + separacionCelda);

                if (vacio) {
                    g.setColor(Color.getHSBColor(0, 0f, 0.9f));
                } else {
                    float colorValor = random.nextFloat();
                    g.setColor(Color.getHSBColor(colorValor, 0.8f, 1));
                }
                g.fillRect(x, y, tamanioCelda, tamanioCelda);
            }
        }

        if (!vacio) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            String texto = getText();
            Font fontNegro = new Font("TimesRoman", Font.BOLD, 22);
            Font fontBlanco = new Font("TimesRoman", Font.BOLD, 22);

            FontMetrics fmNegro = g2d.getFontMetrics(fontNegro);
            FontMetrics fmBlanco = g2d.getFontMetrics(fontBlanco);

            int xTextoN = (getWidth() - fmNegro.stringWidth(texto)) / 2;
            int yTextoN = (getHeight() + fmNegro.getAscent() - fmNegro.getDescent()) / 2;

            int xTextoB = (getWidth() - fmBlanco.stringWidth(texto)) / 2;
            int yTextoB = (getHeight() + fmBlanco.getAscent() - fmBlanco.getDescent()) / 2;

            g2d.setColor(Color.WHITE);
            g2d.setFont(fontBlanco);
            int bordeAncho = 2;
            for (int i = -bordeAncho; i <= bordeAncho; i++) {
                for (int j = -bordeAncho; j <= bordeAncho; j++) {
                    g2d.drawString(texto, xTextoB + i, yTextoB + j);
                }
            }

            g2d.setColor(Color.BLACK);
            g2d.setFont(fontNegro);
            g2d.drawString(texto, xTextoN, yTextoN);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String tamanio) {
        this.text = tamanio;
    }

    public boolean isVacio() {
        return vacio;
    }

    public void setVacio(boolean vacio) {
        this.vacio = vacio;
    }

    public boolean isHandCursor() {
        return handCursor;
    }

    public void setHandCursor(boolean handCursor) {
        this.handCursor = handCursor;
    }
    
    
}
