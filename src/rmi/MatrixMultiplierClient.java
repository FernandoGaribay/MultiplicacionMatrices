package rmi;

import algoritmos.MatrizPorFilas;
import componentes.PreviewPanel;
import componentes.panelMatriz;
import interfaz.ProgresoListener;
import interfaz.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class MatrixMultiplierClient extends java.rmi.server.UnicastRemoteObject implements interfaz.UserInterface, ProgresoListener {

    private PreviewPanel previewPanel;
    private panelMatriz panelA;
    private panelMatriz panelB;

    private long seedA;
    private long seedB;
    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] result;
    private int inicio, fin;
    SwingWorker<int[][], Void> worker;

    private MatrizPorFilas objConcurrente;

    private String name;
    private ServerInterface chatServer;

    public MatrixMultiplierClient(String name, ServerInterface chatServer) throws RemoteException {
        super();
        this.name = name;
        this.chatServer = chatServer;
        this.chatServer.connectUser(this);
        objConcurrente = new MatrizPorFilas(this);
    }

    private void multiplicarMatricesEnRango() {
        int rowsA = matrizA.length;
        int colsA = matrizA[0].length;
        int colsB = matrizB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = inicio; i <= fin; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        //        imprimirMatrizEnRango(result, inicio, fin);
        setResult(result);
    }

    public void multiplicarPorFilas() {
        worker = new SwingWorker<int[][], Void>() {
            int tiempoEjecucion = 0;
            String algoritmo = "";
            int rowsA = matrizA.length;
            int colsA = matrizA[0].length;
            int colsB = matrizB[0].length;
            int[][] newResult = new int[rowsA][colsB];

            @Override
            protected int[][] doInBackground() {
                objConcurrente.setNumHilos(12);
                newResult = objConcurrente.multiplicarSubMatrizEnRango(matrizA, matrizB, inicio, fin);
                algoritmo = "Metodo Por Filas";
                tiempoEjecucion = objConcurrente.getTiempoEjecucion();
                return newResult;
            }
        };

        worker.execute();
    }

    @Override
    public void progresoActualizado(int hilo, double porcentaje) {
        //        hilosUI.get(hilo).actualizarPorcentaje(porcentaje);
        //        pnlContenedorHilos.repaint();
        //        pnlContenedorHilos.revalidate();
    }

    public String convertirTiempo(long tiempoEnMilisegundos) {
        long segundosTotales = tiempoEnMilisegundos / 1000;
        long minutos = segundosTotales / 60;
        long segundos = segundosTotales % 60;
        long decimasSegundos = (tiempoEnMilisegundos % 1000) / 100;

        // Formatea la cadena en el formato minutos:segundos:decimas con 2 dijitos
        String tiempoFormateado = String.format("%02d:%02d:%02d", minutos, segundos, decimasSegundos);

        return tiempoFormateado;
    }

    public static void imprimirMatrizEnRango(int[][] matriz, int inicioFila, int finFila) {
        int columnas = matriz[0].length;

        for (int i = inicioFila; i <= finFila; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getMatrizEnRango(int[][] matriz, int inicioFila, int finFila) {
        int filas = finFila - inicioFila + 1;
        int columnas = matriz[0].length;

        int[][] matrizEnRango = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizEnRango[i][j] = matriz[inicioFila + i][j];
            }
        }

        return matrizEnRango;
    }

    @Override
    public String getName() {
        return name;
    }

    public int[][] getResult() {
        return result;
    }

    public void setResult(int[][] result) {
        this.result = result;
    }

    @Override
    public void recibirSeedA(long seedA) throws RemoteException {
        this.seedA = seedA;
        System.out.println("SeedA: " + seedA);
    }

    @Override
    public void recibirSeedB(long seedB) throws RemoteException {
        this.seedB = seedB;
        System.out.println("SeedB: " + seedB);
    }

    @Override
    public void recibirMatrices(int inicio, int fin, int filas, int columnas) throws RemoteException {
        matrizA = generarMatriz(filas, columnas, seedA);
        matrizB = generarMatriz(filas, columnas, seedB);

        this.inicio = inicio;
        this.fin = fin;

        // Actualizar paneles
        panelA.setVacio(false);
        panelA.setText("[" + inicio + "," + fin + "]");
        panelA.repaint();

        panelB.setVacio(false);
        panelB.setText("[" + inicio + "," + fin + "]");
        panelB.repaint();

        multiplicarPorFilas();
        try {
            int[][] result = worker.get();
            chatServer.recibirMatrizParcial(result, inicio, fin);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getMatrizA() {
        previewPanel.setMatriz(getMatrizEnRango(matrizA, inicio, fin));
    }

    @Override
    public void getMatrizB() {
        previewPanel.setMatriz(getMatrizEnRango(matrizB, inicio, fin));
    }

    @Override
    public void setPanelsListeners(PreviewPanel previewPanel, panelMatriz panelA, panelMatriz panelB) throws RemoteException {
        this.previewPanel = previewPanel;
        this.panelA = panelA;
        this.panelB = panelB;
    }

    public static int[][] generarMatriz(int rows, int columns, long seed) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random(seed);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }

    public static void imprimirMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
