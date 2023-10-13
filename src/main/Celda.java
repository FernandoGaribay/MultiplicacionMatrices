package main;

import java.awt.Color;
import java.util.Random;

public class Celda {

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

        this.color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
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
