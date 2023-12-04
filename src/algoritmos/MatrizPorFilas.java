package algoritmos;

import interfaz.ProgresoListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MatrizPorFilas {

    final ProgresoListener progresoListener;
    private int tiempoEjecucion;
    private int numHilos;

    public MatrizPorFilas(ProgresoListener progresoListener) {
        this.progresoListener = progresoListener;
        this.tiempoEjecucion = 0;
        this.numHilos = 8;
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
                final int hiloFinal = hilo; // Copia final de la variable hilo
                final int filaInicio = hilo * seccion;
                final int filaFin = (hilo == numHilos - 1) ? filas : (hilo + 1) * seccion;

//                AtomicInteger progresoHilo = new AtomicInteger(0); // Operaciones atomicas (no pueden ser interrumpidas)
                resultados.add(pilaHilos.submit(() -> {
                    int progresoHilo = 0;
                    for (int i = filaInicio; i < filaFin; i++) {
                        for (int j = 0; j < columnasB; j++) {
                            for (int k = 0; k < columnasA; k++) {
                                resultante[i][j] += matrizA[i][k] * matrizB[k][j];
                            }
                        }
                        progresoHilo++;
                        double porcentaje = (progresoHilo * 100.0) / (filaFin - filaInicio);
                        progresoListener.progresoActualizado(hiloFinal, porcentaje); // Actualizar Interfaz
//                        System.out.println("Progreso Hilo " + hiloFinal + ": " + porcentaje + "%");
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
        tiempoEjecucion = (int) (tiempoFinal - tiempoInicio);
        System.out.println("Tiempo de calculo: " + tiempoEjecucion + " milisegundos");

        return resultante;
    }

    public int[][] multiplicarSubMatrizEnRango(int[][] matrizA, int[][] matrizB, int inicio, int fin) {
        if (matrizA == null || matrizB == null || inicio < 0 || fin >= matrizA.length || fin < inicio) {
            return null;
        }

        ExecutorService pilaHilos = Executors.newFixedThreadPool(numHilos);
        List<Future> resultados = new ArrayList<>();
        int filas = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;
        int[][] resultante = new int[filas][columnasB];
        int seccion = (fin - inicio + 1) / numHilos;

        long tiempoInicio = System.currentTimeMillis();  // CONTADOR INICIA ------------------------------------------
        try {
            for (int hilo = 0; hilo < numHilos; hilo++) {
                final int hiloFinal = hilo; // Copia final de la variable hilo
                final int filaInicio = inicio + hilo * seccion;
                final int filaFin = (hilo == numHilos - 1) ? fin + 1 : inicio + (hilo + 1) * seccion;

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
        tiempoEjecucion = (int) (tiempoFinal - tiempoInicio);
        System.out.println("Tiempo de calculo: " + tiempoEjecucion + " milisegundos");

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
//        MatrizPorFilas matrizConcurrente = new MatrizPorFilas();
//        int[][] matrizA = matrizConcurrente.generarMatriz(2000, 2000);
//        int[][] matrizB = matrizConcurrente.generarMatriz(2000, 2000);
//
//        int[][] matrizR = matrizConcurrente.multiplicar(matrizA, matrizB);

//        // Imprimir Matriz
//        for (int i = 0; i < matrizR.length; i++) {
//            for (int j = 0; j < matrizR[0].length; j++) {
//                System.out.print(matrizR[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

    public int getNumHilos() {
        return numHilos;
    }

    public void setNumHilos(int numHilos) {
        this.numHilos = numHilos;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

}
