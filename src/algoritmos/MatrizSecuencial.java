package algoritmos;

import java.util.Random;

public class MatrizSecuencial {

    public MatrizSecuencial() {

    }

    public int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        if (matrizA == null || matrizB == null) {
            return null;
        }

        int filas = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;

        int[][] resultante = new int[filas][columnasB];

        long tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultante[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTranscurrido = tiempoFinal - tiempoInicio;
        System.out.println("Tiempo de calculo: " + tiempoTranscurrido + " milisegundos");

        return resultante;
    }

    public int[][] generarMatriz(int filas, int columnas) {
        int[][] matrizTemp = new int[filas][columnas];
        Random random = new Random();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizTemp[i][j] = random.nextInt(10);
            }
        }
        return matrizTemp;
    }

    public static void main(String[] args) {
        MatrizSecuencial matrizLineal = new MatrizSecuencial();
        int[][] matrizA = matrizLineal.generarMatriz(1000, 1000);
        int[][] matrizB = matrizLineal.generarMatriz(1000, 1000);

        int[][] matrizR = matrizLineal.multiplicar(matrizA, matrizB);

        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[0].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
