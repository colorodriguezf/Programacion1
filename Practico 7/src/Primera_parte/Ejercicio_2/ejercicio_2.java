package Primera_parte.Ejercicio_2;
/*2. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números pares que tiene y la imprima. */

import java.util.Random;

public class ejercicio_2 {
    public static final int MAX = 10; //tamaño arreglo
    public static final int MINVALOR = 1; //numero minimo
    public static final int MAXVALOR = 10; //numero maximo

    public static void main (String[] args) {
        int[] arrenteros = new int[MAX];
        cargar_arreglo_aleatorio(arrenteros);
        imprimir_arreglo(arrenteros);
        obtener_numeros_pares(arrenteros);
    }

    public static void cargar_arreglo_aleatorio(int[] arrenteros) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            arrenteros[i] = (r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
        }
    }

    public static void imprimir_arreglo(int[] arrenteros) {
        for(int pos = 0; pos < MAX; pos++) {
            System.out.println("arrenteros["+pos+"] --> "+ arrenteros[pos]);
        }
    }

    public static void obtener_numeros_pares(int[] arrenteros) {
        int total = 0;
        for (int i = 0; i < MAX; i++) {
            if(arrenteros[i] % 2 == 0) {
                total++;
                System.out.println("El numero "+arrenteros[i]+ " en la posicion "+i+" es par");
            }
        }
        System.out.println("El arreglo tiene una cantidad de: "+total+" numeros pares");
    }
}
