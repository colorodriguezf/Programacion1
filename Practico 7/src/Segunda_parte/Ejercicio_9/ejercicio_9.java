package Segunda_parte.Ejercicio_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*9. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados. */

public class ejercicio_9 {
    public static final int MAX = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 10;

    public static void main(String[] args){
        int[] arreglo = new int[MAX];
        int posicion;
        int numero1;
        int numero2;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            cargar_arreglo_aleatorio(arreglo);
            imprimir_arreglo(arreglo);
            System.out.println("Ingrese la primer posicion:");
            numero1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la segunda posicion:");
            numero2 = Integer.valueOf(entrada.readLine());
            ordenar_arreglo_burbujeo(arreglo, numero1, numero2);
            imprimir_arreglo(arreglo);
        }catch(Exception e) {
            System.out.println(e);
        }
    }


    public static void ordenar_arreglo_burbujeo(int[] arreglo, int numero1, int numero2) {
        int temp;
        for(int i = numero1; i < numero2; i++) {
            for(int j = numero1; j < numero2; j++) {
                if(arreglo[j] > arreglo[j+1]) {
                    temp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }
    }

    public static void imprimir_arreglo(int[] arreglo){
        for (int i = 0; i < MAX; i++) {
            System.out.println("arreglo["+i+"] --> "+arreglo[i]);
        }
    }

    public static void cargar_arreglo_aleatorio(int[] arreglo){
        Random r = new Random();
        for(int i = 0; i < MAX; i++) {
            arreglo[i] = r.nextInt((MAXVALOR - MINVALOR) + MINVALOR);
        }
    }
}
