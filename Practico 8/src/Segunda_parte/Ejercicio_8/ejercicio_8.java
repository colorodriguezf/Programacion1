package Segunda_parte.Ejercicio_8;

/*8. Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y elimine la primer ocurrencia de numero en la
fila indicada (un número igual) si existe. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_8 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int numero, fila;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            cargar_matriz(mat);
            System.out.print("Matriz aleatoria: \n");
            imprimir_mat(mat);
            ordenar_ascendente(mat);
            System.out.print("\nMatriz aleatoria ordenada ascendente: \n");
            imprimir_mat(mat);
            System.out.println("\nIngrese una fila: ");
            fila = Integer.valueOf(entrada.readLine());
            System.out.println("\nIngrese un numero el cual sera eliminado (solo el primero): ");
            numero = Integer.valueOf(entrada.readLine());
            eliminar_numero(mat[fila], numero);
            System.out.print("\nMatriz aleatoria con el numero:"+numero+" eliminado: \n");
            imprimir_mat(mat);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void eliminar_numero(int[] arr, int numero) {
        int pos = 0;
        while(pos < MAXCOLUMNA && arr[pos] != numero) {
            pos++;
        }
        if(pos < MAXCOLUMNA) {
            corrimiento_izquierda(arr, pos);
        }
        else {
            System.out.println("No existe el numero: "+numero+" en la fila");
        }
    }

    public static void corrimiento_izquierda(int[] arr, int pos) {
        while(pos < MAXCOLUMNA-1) {
            arr[pos] = arr[pos+1];
            pos++;
        }
    }

    public static void ordenar_ascendente(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            ordenar_ascendente_filas(mat[f]);
        }
    }

    public static void ordenar_ascendente_filas(int[] arr) {
        int aux = 0;
        for(int i = 1; i < MAXCOLUMNA; i++) {
            for(int j = 0; j < MAXCOLUMNA-1; j++) {
                if(arr[j] > arr[j+1]) {
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
        }
    }

    public static void imprimir_mat(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz(int[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {            
                    mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);            
            }
        }
    }
}
