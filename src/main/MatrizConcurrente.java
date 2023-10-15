package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MatrizConcurrente {
    
    private int numHilos;
    
    public MatrizConcurrente() {
        this.numHilos = 6;
    }

    // CON LISTA FUTURE
    public int[][] multiplicar(int[][] matrizA, int[][] matrizB) {
        if (matrizA == null || matrizB == null) {
            return null;
        }

        ExecutorService pilaHilos = Executors.newFixedThreadPool(numHilos);
        List<Future> resultados = new ArrayList<>();
        int filas = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        int[][] resultante = new int[filas][columnasB];

        int seccion = filas / numHilos;

        long tiempoInicio = System.currentTimeMillis();  // CONTADOR INICIA ------------------------------------------
        try {
            for (int hilo = 0; hilo < numHilos; hilo++) {
                final int filaInicio = hilo * seccion;
                final int filaFin = (hilo == numHilos - 1) ? filas : (hilo + 1) * seccion;

                resultados.add(pilaHilos.submit(() -> {
                    for (int i = filaInicio; i < filaFin; i++) {
                        for (int j = 0; j < columnasB; j++) {
                            for (int k = 0; k < columnasA; k++) {
                                resultante[i][j] += matrizA[i][k] * matrizB[k][j];
                            }
                        }
                    }
                    return null;
                }));
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

    // <editor-fold defaultstate="collapsed" desc="Multiplicar() con InvokeAll">  
    // CON METODO INVOKEALL()
//    public int[][] multiplicar(int[][] matrizA, int[][] matrizB, int numHilos) {
//        if (matrizA == null || matrizB == null) {
//            return null;
//        }
//
//        ExecutorService pilaHilos = Executors.newFixedThreadPool(numHilos);
//        List<Callable<Void>> tareas = new ArrayList<>();
//        
//        int filas = matrizA.length;
//        int columnasA = matrizA[0].length;
//        int columnasB = matrizB[0].length;
//        int[][] resultante = new int[filas][columnasB];
//        
//        int seccion = filas / numHilos;
//
//        long tiempoInicio = System.currentTimeMillis(); // CONTADOR INICIA ------------------------------------------
//        for (int hilo = 0; hilo < numHilos; hilo++) {
//            final int filaInicio = hilo * seccion;
//            final int filaFin = (hilo == numHilos - 1) ? filas : (hilo + 1) * seccion;
//
//            tareas.add(() -> {
//                for (int i = filaInicio; i < filaFin; i++) {
//                    for (int j = 0; j < columnasB; j++) {
//                        for (int k = 0; k < columnasA; k++) {
//                            resultante[i][j] += matrizA[i][k] * matrizB[k][j];
//                        }
//                    }
//                }
//                return null;
//            });
//        }
//        
//        try {
//            pilaHilos.invokeAll(tareas);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        pilaHilos.shutdown();
//        
//        long tiempoFinal = System.currentTimeMillis();  // CONTADOR FINALIZA ------------------------------------------
//        long tiempoTranscurrido = tiempoFinal - tiempoInicio;
//        System.out.println("Tiempo de cálculo: " + tiempoTranscurrido + " milisegundos");
//
//        return resultante;
//    }
    // </editor-fold>  

    public int getNumHilos() {
        return numHilos;
    }

    public void setNumHilos(int numHilos) {
        this.numHilos = numHilos;
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
        int[][] matrizA = matrizConcurrente.generarMatriz(5000, 5000);
        int[][] matrizB = matrizConcurrente.generarMatriz(5000, 5000);

        int[][] matrizR = matrizConcurrente.multiplicar(matrizA, matrizB);

        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[0].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
