package Primera_parte.Ejercicio_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*1. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con
el que está en 9, el que está en 1 con el que está en 8…). Este intercambio no se debe realizar
de manera explícita, hay que hacer un método que incluya una iteración de intercambio.*/

public class ejercicio_1 {
    public static final int MAX =10; //tamaño del arreglo

    public static void main (String [] args) {
        int [] arrenteros = new int[MAX]; //declaramos un arreglo de enteros, con tamaño MAX = 10;
        cargar_arreglo(arrenteros);
        imprimir_arreglo(arrenteros);
        invertir_orden_arreglo(arrenteros);
        System.out.println("\n-----------Arreglo invertido:-------------------\n");
        imprimir_arreglo(arrenteros);
    }

    public static void cargar_arreglo(int[] arrenteros) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for(int pos = 0; pos < MAX; pos++) {
                System.out.println("Ingrese un numero:");
                arrenteros[pos] = Integer.valueOf(entrada.readLine());
            }
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void imprimir_arreglo(int[] arrenteros) {
        for(int pos = 0; pos < MAX; pos++) {
            System.out.println("arrenteros["+pos+"] --> "+ arrenteros[pos]);
        }
    }

    public static void invertir_orden_arreglo(int[] arrenteros) {
        int aux = 0;
        int posfinal = MAX-1;
        for (int i = 0; i < MAX/2; i++) {
            aux = arrenteros[i]; //aux vale lo mismo que el arreglo en esa posicion -- primero vale 1
            arrenteros[i] = arrenteros[posfinal]; //arreglo en la pos 0, vale lo que esta en la ultima posicion 10-1 = 9;
            arrenteros[posfinal] = aux; //arreglo en la pos final, vale lo que vale aux que es el arreglo en la pos  i, en este caso 0, vale 1
            posfinal--; // vamos pasando de la pos 9, a la 8, 7 y asi.
        }

    //otra FORMA DE INVERTIR ARREGLO

	/*public static void invertir_orden_arreglo_2(int[] arr) {
		int aux;
		int i = 0;
		int j = MAX-1;
		while (i<j) {
			aux = arr[i];
			arr[i] = arr[j];
			arr[j] = aux;
			i++;
			j--;
		}
	 } */

    }
}