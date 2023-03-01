/*Hacer un programa que dado una matriz de enteros de tamano 4*5 que se encuentra precargada,
 solicite al usuario una posicion fila, columna, y realice un
corrimiento a derecha. Ademas imprima la matriz antes y despues del corrimiento
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejemplo_6 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static void main(String[] args) throws Exception {
        int fila, columna;
        int[][] matint = new int[MAXFILA][MAXCOLUMNA];
        System.out.println("Matriz aleatoria:");
        cargar_matriz_aleatoria(matint);
        imprimir_matriz_aleatoria(matint);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("\nIngrese fila:");
            fila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese columna:");
            columna = Integer.valueOf(entrada.readLine());
            //verifico si lo que cargo esta dentro del rango
            if((0<=fila)&&(fila<MAXFILA) && (0<=columna)&&(columna<=MAXCOLUMNA)) {
                corrimiento_derecha_arreglo(matint[fila],columna);
                System.out.println("Matriz aleatoria con corrimiento:");
                imprimir_matriz_aleatoria(matint);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }        
    }


    public static void corrimiento_derecha_arreglo(int[] arr, int pos) {
        int indice = MAXCOLUMNA-1;
        while(indice > pos) {
            arr[indice] = arr[indice-1];
            indice--;
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

    public static void cargar_matriz_aleatoria(int [][] matint) {
        Random r = new Random();
        for (int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                matint[f][c] = (r.nextInt(MAXVALOR - MINVALOR +1)+MINVALOR);
            }
        }
    }
}
