package Primera_parte.Ejercicio_6;

/*6. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine todas las ocurrencia de numero
en la matriz si existe. Mientras exista (en cada iteración tiene que buscar la posición fila y
columna) tendrá que usar dicha posición para realizar un corrimiento a izquierda. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class ejercicio_6 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
    int[][] mat = new int[MAXFILA][MAXCOLUMNA];
    int numero;
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    try{
        cargar_matriz_aleatoria(mat);
        imprimir_matriz_aleatoria(mat);
        System.out.print("\nIngrese un numero entero a eliminar en la matriz: ");
        numero = Integer.valueOf(entrada.readLine());
        eliminar_ocurrencias(mat, numero);
        System.out.print("\nMatriz con el numero: "+numero+" eliminado");

        imprimir_matriz_aleatoria(mat);
    }catch (Exception e) {
        System.out.println(e);
    }
}

    public static void corrimiento_izquierda(int arr[], int columna) {
        int posicion = columna;
        while(posicion < MAXCOLUMNA-1) {
            arr[posicion] = arr[posicion+1];
            posicion++;
        }
    }

    public static void eliminar_ocurrencias(int[][] arr, int numero) {
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                if(arr[f][c] == numero) {
                    corrimiento_izquierda(arr[f],c);
                }
            }
        }
    }

    public static int buscar_pos_columna(int[] arr, int numero) {
        int posicion = 0;
        while(posicion < MAXCOLUMNA && arr[posicion] != numero) {
            posicion++;
        }
        return posicion;
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
