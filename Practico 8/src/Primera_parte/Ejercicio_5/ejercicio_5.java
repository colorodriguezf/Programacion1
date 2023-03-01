package Primera_parte.Ejercicio_5;

/*5. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda y no continuar buscando.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_5 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
        int [][] mat = new int[MAXFILA][MAXCOLUMNA];
        int numero;   
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            cargar_matriz_aleatoria(mat);
            imprimir_matriz_aleatoria(mat);
            System.out.println("\nIngrese un numero el cual sera eliminado (solo el primero): ");
            numero = Integer.valueOf(entrada.readLine());
            buscar_posicion_y_corrimiento_izquierda(mat, numero);
            imprimir_matriz_aleatoria(mat);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void corrimiento_izquierda(int[] arr, int posicion) {
        int indice = 0;
        while(indice < posicion) {
            arr[indice] = arr[indice + 1];
            indice++;
        }
    }

    public static int buscar_pos_columna(int[] arr, int numero) {
        int posicion = 0;
        while((posicion < MAXCOLUMNA-1) && (arr[posicion] != numero)) {
            posicion++;
        }
        return posicion;
    }

    public static void buscar_posicion_y_corrimiento_izquierda(int[][] mat, int numero) {
        int fila = 0;
        int columna = MAXCOLUMNA;
        while((fila < MAXCOLUMNA) && (columna == MAXCOLUMNA)) {
            columna = buscar_pos_columna(mat[fila], numero);
            if(columna == MAXCOLUMNA) {
                fila++;
            }
            corrimiento_izquierda(mat[fila], columna);
        }
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
