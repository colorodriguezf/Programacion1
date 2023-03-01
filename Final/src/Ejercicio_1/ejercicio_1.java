package Ejercicio_1;

/*1. Se tiene una matriz MAT de caracteres de tamaño MAXFIL X MAXCOL, que esta precargada. Se pide realizar un programa
 que agregue en un arreglo de enteros de tamaño MAXCOL ordenado de forma descendente e inicializado con 0, la cantidad de 
 caracteres vocales de las columnas. El arreglo debe estar ordenado en todo momento.
Observaciones generales:
•	Suponer que MAT esta precargada
•	No se pueden utilizar estructuras auxiliares
•	Realizar un programa completo bien modularizado */

import java.util.Random;

public class ejercicio_1 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final char MINVALOR = 'A';
    public static final char MAXVALOR = 'Z';

    public static void main(String[] args) {
        char[][] mat = new char[MAXFILA][MAXCOLUMNA];
        int[] arreglo = new int[MAXCOLUMNA];

        cargar_matriz_aleatoria_char(mat);
        imprimir_matriz_aleatoria_char(mat);
        cargar_arreglo_int(arreglo);
        consultar_cantidad_vocales(mat, arreglo);
    }

    public static void insertar_ordenado(int cant, int[] arregloint) {
        System.out.print(cant);
        for(int i = 1; i < MAXCOLUMNA; i++) {

        }
    }

    public static int consultar_cantidad_vocales_x_fila(char[] arr) {
        int cant = 0;
        for(int i = 0; i < MAXCOLUMNA; i++) {
            if(arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U') {
                cant++;
            }
        }
        return cant;
    }
    
    public static void consultar_cantidad_vocales(char[][] mat, int[] arregloint) {
        int cant;
        for(int f = 0; f < MAXCOLUMNA; f++) {
            cant = consultar_cantidad_vocales_x_fila(mat[f]);
            insertar_ordenado(cant, arregloint);
        }
    }

    public static void imprimir_matriz_aleatoria_char(char[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_arreglo_int(int[] arr) {
        arr[0] = 0;
    }

    public static void cargar_matriz_aleatoria_char(char[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                mat[f][c] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }
}
