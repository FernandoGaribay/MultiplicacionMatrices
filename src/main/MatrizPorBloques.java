package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrizPorBloques {

    private int numBloques;

    public MatrizPorBloques() {
        this.numBloques = 16;
    }

    public int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        if (matrizA == null || matrizB == null) {
            return null;
        }

        ExecutorService pilaHilos = Executors.newFixedThreadPool(numBloques);
        List<Future> resultados = new ArrayList<>();
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int filasB = matrizB.length;
        int columnasB = matrizB[0].length;
        int[][] resultante = new int[filasA][columnasB];
        int volumenBloque = filasA / numBloques;

        long tiempoInicio = System.currentTimeMillis();  // CONTADOR INICIA ------------------------------------------
        try {
            for (int i = 0; i < filasA; i += volumenBloque) {
                for (int j = 0; j < columnasB; j += volumenBloque) {
                    for (int k = 0; k < columnasA; k += volumenBloque) {
                        int iStart = i;
                        int jStart = j;
                        int kStart = k;
                        int iEnd = Math.min(i + volumenBloque, filasA);
                        int jEnd = Math.min(j + volumenBloque, columnasB);
                        int kEnd = Math.min(k + volumenBloque, columnasA);

                        resultados.add(pilaHilos.submit(() -> {
                            for (int x = iStart; x < iEnd; x++) {
                                for (int y = jStart; y < jEnd; y++) {
                                    for (int z = kStart; z < kEnd; z++) {
                                        resultante[x][y] += matrizA[x][z] * matrizB[z][y];
                                    }
                                }
                            }
                            return null;
                        }));
                    }
                }
            }
            for (Future resultado : resultados) {
                resultado.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pilaHilos.shutdown();
        }

        long tiempoFinal = System.currentTimeMillis();  // CONTADOR FINALIZA ------------------------------------------
        long tiempoTranscurrido = tiempoFinal - tiempoInicio;
        System.out.println("Tiempo de cálculo: " + tiempoTranscurrido + " milisegundos");

        return resultante;
    }

    public int getNumBloques() {
        return numBloques;
    }

    public void setNumBloques(int numBloques) {
        this.numBloques = numBloques;
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
        MatrizConcurrente matrizConcurrente = new MatrizConcurrente();
        int[][] matrizA = matrizConcurrente.generarMatriz(100, 5000);
        int[][] matrizB = matrizConcurrente.generarMatriz(3000, 100);

        int[][] matrizR = matrizConcurrente.multiplicar(matrizA, matrizB);

        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[0].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
