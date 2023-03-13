package Segunda_parte.Ejercicio_7;

/*7. Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y luego inserte el numero en la matriz en la fila
indicada manteniendo su orden.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_7 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int numero, fila;
        int pos;

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
            System.out.println("\nIngrese un numero el cual sera insertado: ");
            numero = Integer.valueOf(entrada.readLine());
            pos = buscar_pos_numero(mat[fila], numero);
            corrimiento_derecha(mat[fila], pos);
            insertar_numero(mat[fila], pos, numero);
            System.out.print("\nMatriz aleatoria con el numero:"+numero+" insertado: \n");
            imprimir_mat(mat);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void insertar_numero(int[] arr, int pos, int numero) {
        arr[pos] = numero;
    }

    public static int buscar_pos_numero(int[]arr, int numero){
        int pos = 0;
        while(pos < MAXCOLUMNA && arr[pos] < numero) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_derecha(int[] arr, int pos) {
        int posFinal = MAXCOLUMNA-1;
        while(posFinal > pos) {
            arr[posFinal] = arr[posFinal-1];
            posFinal--;
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
