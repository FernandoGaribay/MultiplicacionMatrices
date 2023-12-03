package rmi;

import componentes.PreviewPanel;
import componentes.panelMatriz;
import interfaz.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplierClient extends java.rmi.server.UnicastRemoteObject implements interfaz.UserInterface {

    private PreviewPanel previewPanel;
    private panelMatriz panelA;
    private panelMatriz panelB;

    private long seedA;
    private long seedB;
    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] result;
    private int inicio, fin;

    private String name;
    private ServerInterface chatServer;

    public MatrixMultiplierClient(String name, ServerInterface chatServer) throws RemoteException {
        super();
        this.name = name;
        this.chatServer = chatServer;
        this.chatServer.connectUser(this);
    }

    private int[][] multiplicarMatricesEnRango() {
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
        return result;
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
        
        imprimirMatriz(matrizA);
        System.out.println("\n\n");
        imprimirMatriz(matrizB);
        
        
        this.inicio = inicio;
        this.fin = fin;

        // Actualizar paneles
        panelA.setVacio(false);
        panelA.setText("[" + inicio + "," + fin + "]");
        panelA.repaint();

        panelB.setVacio(false);
        panelB.setText("[" + inicio + "," + fin + "]");
        panelB.repaint();
        
        result = multiplicarMatricesEnRango();
        chatServer.recibirMatrizParcial(result, inicio, fin);
    }

    @Override
    public void getMatrizA () {
        previewPanel.setMatriz(getMatrizEnRango(matrizA, inicio, fin)); 
    }

    @Override
    public void getMatrizB () {
        previewPanel.setMatriz(getMatrizEnRango(matrizB, inicio, fin)); 
    }

    @Override
    public void setPanelsListeners(PreviewPanel previewPanel, panelMatriz panelA, panelMatriz panelB) throws RemoteException {
        this.previewPanel = previewPanel;
        this.panelA = panelA;
        this.panelB = panelB;
    }

    public static void main(String[] args) {
        try {
            String name = "jos";
            String serverIP = "192.168.1.87";
            Registry registry = LocateRegistry.getRegistry(serverIP, 1234);

            ServerInterface chatServer = (ServerInterface) registry.lookup("ChatServer");
            MatrixMultiplierClient client = new MatrixMultiplierClient(name, chatServer);

            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            System.out.println("Matriz resultante en el rango [" + client.inicio + ", " + client.fin + "]:");
            int[][] result = client.multiplicarMatricesEnRango();
            chatServer.recibirMatrizParcial(result, client.inicio, client.fin);

            imprimirMatriz(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
