package rmi;

import interfaz.UserInterface;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.SwingUtilities;

public class MatrixMultiplierServer extends UnicastRemoteObject implements interfaz.ServerInterface {

    private List<UserInterface> connectedUsers;
    private List<int[][]> matricesParciales;
    private int respuestasRecibidas;
    private JList listUsers;
    private int lastLenght = 0;

    private int filas, columnas;
    private int[][] resul;

    private long seedA;
    private long seedB;

    public MatrixMultiplierServer() throws RemoteException {
        super();
        connectedUsers = new ArrayList<>();
        matricesParciales = new ArrayList<>();
        respuestasRecibidas = 0;
    }

    @Override
    public void setListUsers(JList listUsers) throws RemoteException {
        this.listUsers = listUsers;
    }

    @Override
    public void broadcastSeedA(long seedA) throws RemoteException {
        for (UserInterface connectedUser : connectedUsers) {
            connectedUser.recibirSeedA(seedA);
            this.seedA = seedA;
            System.out.println("SeedA: " + seedA);
        }
    }

    @Override
    public void broadcastSeedB(long seedB) throws RemoteException {
        for (UserInterface connectedUser : connectedUsers) {
            connectedUser.recibirSeedB(seedB);
            this.seedB = seedB;
            System.out.println("SeedB: " + seedB);
        }
    }

    @Override
    public int[][] getMatrizA(int filas, int columnas) throws RemoteException {
        System.out.println("Generada con la Seed: " + seedA);
        return generarMatriz(filas, columnas, seedA);
    }

    @Override
    public int[][] getMatrizB(int filas, int columnas) throws RemoteException {
        System.out.println("Generada con la Seed: " + seedB);
        return generarMatriz(filas, columnas, seedB);
    }

    @Override
    public void mandarMatrices(int inicio, int fin, int filas, int columnas, UserInterface user) throws RemoteException {
        this.filas = filas;
        this.columnas = columnas;
        user.recibirMatrices(inicio, fin, filas, columnas);
    }

    @Override
    public void connectUser(UserInterface usuario) throws RemoteException {
        this.connectedUsers.add(usuario);
        SwingUtilities.invokeLater(() -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (UserInterface client : connectedUsers) {
                try {
                    listModel.addElement(client.getName());
                } catch (RemoteException ex) {
                    ex.getMessage();
                }
            }

            listUsers.setModel(listModel);
        });
        System.out.println("-> Usuario: " + usuario.getName() + " conectado.");
    }

    @Override
    public void disconnectUser(UserInterface usuario) throws RemoteException {
        this.connectedUsers.remove(usuario);
        SwingUtilities.invokeLater(() -> {
            DefaultListModel<String> listModel = new DefaultListModel<>();

            for (UserInterface client : connectedUsers) {
                try {
                    listModel.addElement(client.getName());
                } catch (RemoteException ex) {
                    ex.getMessage();
                }
            }

            listUsers.setModel(listModel);
        });
        System.out.println("-> Usuario: " + usuario.getName() + " conectado.");
    }

    @Override
    public List<UserInterface> getConnectedUsers() throws RemoteException {
        return connectedUsers;
    }

    @Override
    public synchronized void recibirMatrizParcial(int[][] matrizParcial, int inicio, int fin) throws RemoteException {
        matricesParciales.add(matrizParcial);
        respuestasRecibidas++;

        // Verificar si se han recibido todas las respuestas
        if (respuestasRecibidas == connectedUsers.size()) {
            // Todas las respuestas han sido recibidas, se obtiene la resultante
            resul = obtenerMatrizResultante();
            respuestasRecibidas = 0;
        }

    }

    @Override
    public int[][] obtenerMatrizResultante() throws RemoteException {
        int[][] matrizResultante = new int[filas][columnas];

        System.out.println("-> Filas: " + filas);
        System.out.println("-> Columnas: " + columnas);

        if (lastLenght < filas) {
            for (int[][] matrizParcial : matricesParciales) {
                for (int i = 0; i < matrizParcial.length; i++) {
                    for (int j = 0; j < matrizParcial[0].length; j++) {
                        matrizResultante[i][j] += matrizParcial[i][j];
                    }
                }
            }
            lastLenght = filas;
        } else {
            for (int[][] matrizParcial : matricesParciales) {
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        matrizResultante[i][j] += matrizParcial[i][j];
                    }
                }
            }
            lastLenght = filas;
        }

        return matrizResultante;
    }

    @Override
    public int[][] getResul() {
        return resul;
    }

    @Override
    public void resetResul() {
        matricesParciales = new ArrayList<>();
        respuestasRecibidas = 0;
        filas = 0;
        columnas  = 0;
        this.resul = null;
    }

//    public static void main(String[] args) {
//
//        try {
//            String ipAddress = "192.168.1.87";
//            System.setProperty("java.rmi.server.hostname", ipAddress);
//            Registry registry = LocateRegistry.createRegistry(1234);
//
//            ServerInterface chatServer = new MatrixMultiplierServer();
//            registry.rebind("ChatServer", chatServer);
//            System.out.println("ChatServer ready at " + ipAddress);
//
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("Ingrese el número de filas para la matriz: ");
//            int filas = scanner.nextInt();
//            System.out.print("Ingrese el número de columnas para la matriz: ");
//            int columnas = scanner.nextInt();
//
//            long seedA = 12345;
//            int[][] matrixA = generarMatriz(filas, columnas, seedA);
//            long seedB = 54321;
//            int[][] matrixB = generarMatriz(filas, columnas, seedB);
//
//            // Broadcast mandar semilla
//            chatServer.broadcastSeed(seedA, seedB);
//
//            // Repartir matriz
//            int totalClients = chatServer.getConnectedUsers().size();
//            int rowsPerClient = filas / totalClients;
//            int remainingRows = filas % totalClients;
//
//            int assignedRows = 0;
//            for (int i = 0; i < totalClients; i++) {
//                int currentRows = rowsPerClient;
//
//                if (remainingRows > 0) {
//                    currentRows++;
//                    remainingRows--;
//                }
//
//                if ((assignedRows + currentRows) > filas) {
//                    currentRows = filas - assignedRows;
//                }
//
//                UserInterface usuario = chatServer.getConnectedUsers().get(i);
//                chatServer.mandarMatrices(assignedRows, (assignedRows + currentRows - 1), filas, columnas, usuario);
//
//                assignedRows += currentRows;
//            }
//
//            // RECIBIR MATRICES          
//            imprimirMatriz(multiplicarMatrices(matrixA, matrixB));
//            System.out.println("\n\n");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
    public static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int rowsA = matrizA.length;
        int colsA = matrizA[0].length;
        int colsB = matrizB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return result;
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
