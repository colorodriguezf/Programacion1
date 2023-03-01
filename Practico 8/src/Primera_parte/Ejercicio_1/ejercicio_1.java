package Primera_parte.Ejercicio_1;

/*1. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, invierta el orden del contenido por fila. Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_1 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
        int[][] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz_aleatoria(matint);
        System.out.println("Matriz aleatoria:");
        imprimir_matriz_aleatoria(matint);
        System.out.println("\nMatriz aleatoria invertida:");
        invertir_orden_matriz(matint);
        imprimir_matriz_aleatoria(matint);
    }

    public static void invertir_orden_matriz_x_fila(int[] matint) {
        int aux;
        int i = 0;
        int j = MAXCOLUMNA-1;
        while(i<j) {
            aux=matint[i];
            matint[i]=matint[j];            
            matint[j]=aux;//se vuelve aux, pq sino siempre valdria lo que vale en la pos i, que siempre pasa a valer j (siempre los mismos 2 valores).
            i++;
            j--;
        }
    }

    public static void invertir_orden_matriz(int[][] matint) {
       for(int f = 0; f < MAXFILA; f++) {
        invertir_orden_matriz_x_fila(matint[f]);
       }
    }

    public static void imprimir_matriz_aleatoria(int[][] matint) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+matint[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz_aleatoria(int[][] matint) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                matint[f][c] = (r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
            }
        }
    }
}
