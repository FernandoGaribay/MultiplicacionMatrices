package algoritmos;

import interfaz.ProgresoListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrizPorBloques {

    private int tiempoEjecucion;
    private int numBloques;

    public MatrizPorBloques() {
        this.tiempoEjecucion = 0;
        this.numBloques = 8;
    }

        public int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        if (matrizA == null || matrizB == null) {
            return null;
        }

        ExecutorService pilaHilos = Executors.newFixedThreadPool(numBloques);
        List<Future> resultados = new ArrayList<>();
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
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
                            int progresoHilo = 0;
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
        tiempoEjecucion = (int) (tiempoFinal - tiempoInicio);
        System.out.println("Tiempo de calculo: " + tiempoEjecucion + " milisegundos");

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
        MatrizPorBloques matrizBloques = new MatrizPorBloques();
        int[][] matrizA = matrizBloques.generarMatriz(1000, 1000);
        int[][] matrizB = matrizBloques.generarMatriz(1000, 1000);

        int[][] matrizR = matrizBloques.multiplicar(matrizA, matrizB);

//        for (int i = 0; i < matrizR.length; i++) {
//            for (int j = 0; j < matrizR[0].length; j++) {
//                System.out.print(matrizR[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

    public int getNumBloques() {
        return numBloques;
    }

    public void setNumBloques(int numBloques) {
        this.numBloques = numBloques;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }
}

// Algoritmo antiguo
/*
    public int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        if (matrizA == null || matrizB == null) {
            return null;
        }

        ExecutorService pilaHilos = Executors.newFixedThreadPool(numBloques);
        List<Future> resultados = new ArrayList<>();
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        int[][] resultante = new int[filasA][columnasB];
        int volumenBloque = filasA / numBloques;

        long tiempoInicio = System.currentTimeMillis();  // CONTADOR INICIA ------------------------------------------
        try {
            for (int i = 0; i < numBloques; i++) {
                int iStart = i * volumenBloque;
                int iEnd = Math.min(iStart + volumenBloque, filasA);
                for (int j = 0; j < columnasB; j += volumenBloque) {
                    int jStart = j;
                    int jEnd = Math.min(jStart + volumenBloque, columnasB);
                    for (int k = 0; k < columnasA; k += volumenBloque) {
                        int kStart = k;
                        int kEnd = Math.min(kStart + volumenBloque, columnasA);

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
        tiempoEjecucion = (int) (tiempoFinal - tiempoInicio);
        System.out.println("Tiempo de calculo: " + tiempoEjecucion + " milisegundos");

        return resultante;
    }
 */
