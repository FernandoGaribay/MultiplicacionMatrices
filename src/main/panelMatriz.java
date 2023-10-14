package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

public class panelMatriz extends JPanel {

    private int numCeldas;
    private int separacionCelda;
    private String text;

    public panelMatriz() {
        this.numCeldas = 10;
        this.separacionCelda = 2;
        this.text = "100x100";

        repaint();
    }

    public panelMatriz(String text) {
        this.numCeldas = 10;
        this.separacionCelda = 2;
        this.text = text;

        repaint();
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

                float colorValor = random.nextFloat();
                g.setColor(Color.getHSBColor(colorValor, 1, 1));
                g.fillRect(x, y, tamanioCelda, tamanioCelda);
            }
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        String texto = getText();
        Font font = new Font("TimesRoman", Font.BOLD, 30);
        FontMetrics fm = g2d.getFontMetrics(font);
        int xTexto = (getWidth() - fm.stringWidth(texto)) / 2;
        int yTexto = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

        g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString(texto, xTexto + 2, yTexto + 2);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(texto, xTexto, yTexto);
    }

    public String getText() {
        return text;
    }

    public void setText(String tamanio) {
        this.text = tamanio;
    }

}
