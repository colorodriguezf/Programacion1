package Primera_parte.Ejercicio_2;

/*2. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, obtenga la cantidad de números pares que tiene y la imprima. */

import java.util.Random;

public class ejercicio_2 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int cantidad;

        cargar_matriz_aleatoria(mat);
        System.out.println("Matriz aleatoria int: ");
        imprimir_matriz_aleatoria(mat);
        cantidad = obtener_cantidad_numeros_pares(mat);
        System.out.println("\nLa cantidad de numeros pares en la matriz son: "+cantidad);
    }

    public static int obtener_cantidad_numeros_pares(int[][]mat) {
        int cantidad = 0;
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                if(mat[f][c] % 2 ==0) {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    public static void imprimir_matriz_aleatoria(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz_aleatoria(int[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }
}
