package Cuarta_parte.Ejercicio_14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*14. Hacer un programa que dado el arreglo definido y precargado, y un número
entero ingresado por el usuario, copie de forma continua las secuencias de
tamaño igual al número ingresado en otro arreglo de iguales características e
inicializado con 0. La copia en este último arreglo deben comenzar desde el
principio del mismo. */

public class ejercicio_14 {
    public static final int MAX = 20;
	public static final int MAXVALOR = 10;
	public static final int MINVALOR = 1;
	public static final double probabilidad_numero = 0.4;
    public static void main(String[] args) {
        int [] arreglOriginal = new int[MAX];
        int [] arregloCopia = new int [MAX];
        int numero;
        
        cargar_arreglo_copia(arregloCopia);
        cargar_arreglo_aleatorio_secuencias_int(arreglOriginal);
        
        System.out.print("Arreglo de secuencias int\n|");
        imprimir_arreglo_secuencias_int(arreglOriginal);
        System.out.println("ingrese un numero");
        numero = ingresar_numero();
        
        copiar_secuencias_igual_tamaño(arreglOriginal, arregloCopia, numero);
        System.out.print("Arreglo de copias int\n|");
        imprimir_arreglo_secuencias_int(arregloCopia);
    
    }
    
	public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
		Random r = new Random();
		arr[0] = 0;
		arr[MAX - 1] = 0;
		for (int pos = 1; pos < MAX - 1; pos++) {
			if (r.nextDouble() > probabilidad_numero) {
				arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
			} else {
				arr[pos] = 0;
			}
		}
	}

	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
	}
	public static void copiar_secuencias_igual_tamaño(int[]arr, int[]arrCo, int numero) {
		int fin = -1;
		int tamaño= 0;
		int inicio=0;
		int posInsertar = 1;
		while (inicio < MAX) {
			inicio = obtener_inicio_secuencia(arr, fin+1);
			if (inicio < MAX) {
				fin = obtener_fin_secuencia(arr, inicio);
				//se encontro secuencia que empieza en INICIO y termina en FIN
				tamaño = tamaño_secuencia(inicio, fin);
				if (tamaño == numero) {
					for (int i = inicio; i <=fin; i++) {
						arrCo[posInsertar] = arr[i];
						posInsertar++;
					}
					obtener_inicio_secuencia(arr, fin+1);
				}
				
			}
		}
	}
	public static void cargar_arreglo_copia(int[] arrCop) {
		for (int i = 0; i< MAX-1; i++) {
			arrCop[i] = 0;
		}
	}
	public static int ingresar_numero() {
		int numero = 0;
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		try {
			numero = Integer.valueOf(entrada.readLine());
		} catch (Exception e) {
			System.out.println(e);
		}
		return numero;
	}
	
	public static int tamaño_secuencia(  int inicio, int fin) {
		return fin-inicio+1;
	}
	public static int obtener_inicio_secuencia(int[]arr, int pos) {
		int indice = pos;
		while (indice < MAX && arr[indice] ==0){
			indice++;
		}
		return indice;
	}
	public static int obtener_fin_secuencia(int[] arr, int pos) {
		int indice = pos;
		while (indice < MAX && arr[indice] != 0) {
			indice++;
		}
		return indice-1;
	}
}
