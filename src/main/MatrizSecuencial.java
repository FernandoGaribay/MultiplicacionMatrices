package main;

public class MatrizSecuencial {

    private int matrizA[][];
    private int matrizB[][];

    public MatrizSecuencial() {
        this.matrizA = null;
        this.matrizB = null;
    }

    public MatrizSecuencial(int[][] matrizA, int[][] matrizB) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    public int[][] multiplicar() {
        if (matrizA == null || matrizB == null) {
            return null;
        }

        int filas = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;

        int[][] result = new int[filas][columnasB];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    result[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return result;
    }

    public int[][] getMatrizA() {
        return matrizA;
    }

    public void setMatrizA(int[][] matrizA) {
        this.matrizA = matrizA;
    }

    public int[][] getMatrizB() {
        return matrizB;
    }

    public void setMatrizB(int[][] matrizB) {
        this.matrizB = matrizB;
    }

    public static void main(String[] args) {
        MatrizSecuencial matrizLineal = new MatrizSecuencial();
        int[][] matrizA = {{1, 0}, {6, -2}, {-1, 4}};
        int[][] matrizB = {{2, -5, 1, -2}, {3, 2, 0, -1}};
        
        matrizLineal.setMatrizA(matrizA);
        matrizLineal.setMatrizB(matrizB);
        
        int[][] matrizR = matrizLineal.multiplicar();
        
        for (int i = 0; i < matrizR.length; i++) {
            for (int j = 0; j < matrizR[0].length; j++) {
                System.out.print(matrizR[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
