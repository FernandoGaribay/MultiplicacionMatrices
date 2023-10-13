package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Controles extends JPanel {

    JPanel centrar;
    JPanel izquierda;
    JPanel derecha;

    JButton btnConf;
    
    JButton zoomIn;
    JButton btnCenter;
    JButton zoomOut;

    public Controles() {
        initComponentes();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int panelWidth = (int) (getWidth());
                int panelHeigh = (int) (getHeight());

                System.out.println("width; " + panelWidth);
                izquierda.setLayout(new FlowLayout(FlowLayout.CENTER, 10, (int)(btnConf.getPreferredSize().getHeight() / 2)));
                izquierda.setPreferredSize(new Dimension((int) (panelWidth * 0.20), panelHeigh));
                System.out.println("Width izquierda; " + (int) (panelWidth * 0.20));

                centrar.setPreferredSize(new Dimension((int) (panelWidth * 0.60), panelHeigh));
                centrar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, (int)(btnCenter.getPreferredSize().getHeight() / 2)));
                System.out.println("Width centrar; " + (int) (panelWidth * 0.60));
                
                derecha.setPreferredSize(new Dimension((int) (panelWidth * 0.20), panelHeigh));
                System.out.println("Width derecha; " + (int) (panelWidth * 0.20));

                revalidate();
            }
        });
    }

    public void initComponentes() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(Color.red);

        centrar = new JPanel(new FlowLayout());
        zoomIn = new JButton("Zoom In");
        zoomIn.setPreferredSize(new Dimension(100,50));
        btnCenter = new JButton("[]");
        btnCenter.setPreferredSize(new Dimension(50,50));
        zoomOut = new JButton("Zoom Out");
        zoomOut.setPreferredSize(new Dimension(100,50));
        centrar.add(zoomIn);
        centrar.add(btnCenter);
        centrar.add(zoomOut);
        centrar.setBackground(Color.GREEN);

        izquierda = new JPanel(new FlowLayout());
        btnConf = new JButton("Zoom In");
        btnConf.setPreferredSize(new Dimension(100,50));
        izquierda.add(btnConf);
        izquierda.setBackground(Color.PINK);

        derecha = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        derecha.setBackground(Color.PINK);

        add(izquierda);
        add(centrar);
        add(derecha);

    }
}
