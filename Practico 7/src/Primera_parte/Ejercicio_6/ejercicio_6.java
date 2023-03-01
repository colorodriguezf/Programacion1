package Primera_parte.Ejercicio_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*6. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine todas las ocurrencia de numero en el
arreglo si existe. Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) tendrá que usar la posición para realizar un corrimiento a izquierda (quedarán tantas
copias de la última posición del arreglo como cantidad de ocurrencias del número).
 */

public class ejercicio_6 {
    public static final int MAX = 10;
	private static final int MINVALOR = 0;
	private static final int MAXVALOR = 10;
	public static void main(String[] args) {
        int arreglo [] = new int[MAX];
		int entero;
		int pos;
        
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
		try {
            cargar_arreglo_aleatorio(arreglo);
            imprimir_arreglo(arreglo);
			System.out.println("Ingrese un numero entero");
			entero = Integer.valueOf(entrada.readLine());
			pos = obtener_pos_arreglo(arreglo, entero);
            eliminar_ocurrencias(arreglo, entero);			
			imprimir_arreglo(arreglo);
			
		} catch (Exception e) {
			System.out.println(e);
		}

    }

	
    public static void corrimiento_izquierda(int[] arr, int pos) {//eliminar_primer_ocurrencia
		int posInicial = pos;
		while (posInicial < MAX-1) {
				arr[posInicial] = arr[posInicial+1];
				posInicial++;	
			
		}
		//EN ESTE METODO SE MODIFICO LA POS INICIAL, QUE VA A TOMAR COMO RESULTADO LA POS DEL USUARIO
		//Y EN EL WHILE UTILIZAMOS LA ULTIMA POSICION DEL ARREGLO, para poder encontrar el numero
		//ingresado por el usuario en la posicion
	}
	
	public static void eliminar_ocurrencias(int[] arr, int entero) {
		int pos = 0;
		while (pos < MAX-1) {
			while(arr[pos] == entero) {
				corrimiento_izquierda(arr,pos);
			} 
			pos++;
		}
	}
    public static int obtener_pos_arreglo(int[] arrenteros, int entero) {
        int pos = 0;
        while (pos < MAX && arrenteros[pos] != entero) {
            pos ++;
        }
        return pos;
    }

    public static void cargar_arreglo_aleatorio(int[] arreglo) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            arreglo[i] = r.nextInt((MAXVALOR - MINVALOR +1) + MINVALOR);
        }
    }
    
    public static void imprimir_arreglo(int [] arreglo) {
        for (int i = 0; i < MAX; i++) {
            System.out.println("arrenteros["+i+"] --> "+arreglo[i]);
        }
    }
}
