package rmi;


import interfaz.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplierClient extends java.rmi.server.UnicastRemoteObject implements interfaz.UserInterface {

    private long seedA;
    private long seedB;
    private int[][] matrizA;
    private int[][] matrizB;
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void recibirSeed(long seedA, long seedB) throws RemoteException {
        this.seedA = seedA;
        this.seedB = seedB;
    }

    @Override
    public void recibirMatrices(int inicio, int fin, int filas, int columnas) throws RemoteException {
        matrizA = generarMatriz(filas, columnas, seedA);
        matrizB = generarMatriz(filas, columnas, seedB);
        this.inicio = inicio;
        this.fin = fin;
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
