package algoritmos;

import interfaz.ProgresoListener;
import java.util.Random;

public class MatrizSecuencial {

    final ProgresoListener progresoListener;
    private int tiempoEjecucion;

    public MatrizSecuencial(ProgresoListener progresoListener) {
        this.progresoListener = progresoListener;
        this.tiempoEjecucion = 0;
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
        int progresoHilo = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultante[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
            progresoHilo++;
            double porcentaje = ((i + 1) * 100.0) / filas;
            progresoListener.progresoActualizado(0, porcentaje);
//            System.out.println("Progreso: " + porcentaje + "%");
        }
        long tiempoFinal = System.currentTimeMillis();
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
//        MatrizSecuencial matrizLineal = new MatrizSecuencial();
//        int[][] matrizA = matrizLineal.generarMatriz(1000, 1000);
//        int[][] matrizB = matrizLineal.generarMatriz(1000, 1000);
//
//        int[][] matrizR = matrizLineal.multiplicar(matrizA, matrizB);

//        for (int i = 0; i < matrizR.length; i++) {
//            for (int j = 0; j < matrizR[0].length; j++) {
//                System.out.print(matrizR[i][j] + " ");
//            }
//            System.out.println("");
//        }
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

}
