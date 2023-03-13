package Segunda_parte.Ejercicio_9;

/*9. Hacer un programa que dado una matriz de enteros de tamaño 4*5 que
se encuentra precargada, solicite al usuario el ingreso de una fila y dos
números enteros (columnas de la matriz), y ordene de forma creciente la
matriz en la fila indicada entre las dos posiciones columnas ingresadas. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
public class ejercicio_9 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int fila, numero1, numero2;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            cargar_matriz(mat);
            System.out.print("Matriz aleatoria: \n");
            imprimir_mat(mat);
            System.out.println("\nIngrese una fila: ");
            fila = Integer.valueOf(entrada.readLine());
            System.out.println("\nIngrese la primera posicion (columna): ");
            numero1 = Integer.valueOf(entrada.readLine());
            System.out.println("\nIngrese la segunda posicion (columna): ");
            numero2 = Integer.valueOf(entrada.readLine());
            ordenar_matriz(mat[fila], numero1, numero2);
            System.out.print("Matriz aleatoria ordenada en la fila: "+fila+", entre pos "+numero1+" y "+numero2+" \n");
            imprimir_mat(mat);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void ordenar_matriz(int[] arr, int numero1, int numero2){
        int aux = 0;
        for(int i = numero1; i < numero2; i++){
            for(int j = numero1; j < numero2; j++){
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
