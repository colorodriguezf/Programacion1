package Primera_parte.Ejercicio_3;

/*3. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario una posición fila, columna y realice un corrimiento a
izquierda. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_3 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) throws Exception {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int posfila;
        int poscolumna;

        cargar_matriz_aleatoria(mat);
        System.out.println("Matriz aleatoria: ");
        imprimir_matriz_aleatoria(mat);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("\nIngrese una posicion fila: ");
            posfila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una posicion columna: ");
            poscolumna = Integer.valueOf(entrada.readLine());
            corrimiento_izquierda(mat[posfila], poscolumna);
            System.out.println("Matriz aleatoria con corrimiento en mat["+posfila+"]["+poscolumna+"]: ");
            imprimir_matriz_aleatoria(mat);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static void corrimiento_izquierda(int[] arr, int pos) {
        int indice = 0;
        while(indice < pos) {
            arr[indice] = arr[indice+1];
            indice++;
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
                mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR) + 1) + MINVALOR;
            }
        }
    }
}
