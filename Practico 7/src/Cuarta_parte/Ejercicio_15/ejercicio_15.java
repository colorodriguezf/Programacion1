package Cuarta_parte.Ejercicio_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*15. Hacer un programa que dado el arreglo definido y precargado elimine del
arreglo todas las ocurrencias de una secuencia patrón dada por otro arreglo
de iguales características (solo tiene esa secuencia). Al eliminar se pierden los
valores haciendo los corrimientos. */
public class ejercicio_15 {
    public static final int MAX = 20;
	public static void main(String[] args) {
		int [] arreglo = {0,0,1,2,0,0,3,4,5,0,0,5,2,5,0,0,0,2,6,0};
		int [] arregloPatron = {3,4,5,0,5,2,5,8,0,3,4,5,0,0,0,0,0,0,0,0};
		
		System.out.println("imprimo arreglo Original");
		imprimir_arreglo_secuencias_int(arreglo);
		eliminar_ocurrencias_secuencias_patron(arreglo, arregloPatron);	
		System.out.println("imprimo arreglo sin la secuencia patron");
		imprimir_arreglo_secuencias_int(arreglo);
		
	}
		public static void imprimir_arreglo_secuencias_int(int[] arr) {
			for (int pos = 0; pos < MAX; pos++) {
				System.out.print(arr[pos] + "|");
			}
			System.out.print("\n");
		}

	public static void eliminar_ocurrencias_secuencias_patron(int[] arr, int[] arrPatron) {
		int inicio = 0;
		int fin = 0;
		while (inicio < MAX-1) {
			inicio = obtener_inicio_secuencia(arr, fin+1);
			if (inicio < MAX-1) {
				fin = obtener_fin_secuencia(arr, inicio);
				if (secuencia_patron_iguales(arr, arrPatron, inicio, fin)) {
					for (int i = inicio; i <fin ; i++) {
						eliminar_secuencias(arr, inicio, fin);						
					}
					obtener_inicio_secuencia(arr, fin+1);
				}
			}
		}
	}
	
	public static void eliminar_secuencias(int[] arr, int inicio, int fin) {
		for (int i = 0; i <= fin-inicio+1; i++) {
			corrimiento_izquierda(arr, inicio);
		}
	}
	public static void corrimiento_izquierda(int[]arr, int pos) {
		for (int i = pos; i < MAX-1; i++) {
			arr[i] =arr[i+1];
		}
	}
	
	public static boolean secuencia_patron_iguales(int[] arr, int[] arrPatron, int inicio, int fin) {
		boolean existe = true;
		int iterador = 0;
		while((inicio + iterador)<= fin && arr[inicio + iterador] == arrPatron[iterador]) {
			iterador++;
		}
		if ((inicio + iterador) > fin && arrPatron[iterador] == 0) {
			existe = true;
		}else {
			existe = false;
		}
		return existe;
	}
	
	
	public static int obtener_inicio_secuencia(int[]arr, int pos) {
		int indice = pos;
		while (indice < MAX-1 && arr[indice] ==0){
			indice++;
		}
		return indice;
	}
	public static int obtener_fin_secuencia(int[] arr, int pos) {
		int indice = pos;
		while (indice < MAX-1 && arr[indice] != 0) {
			indice++;
		}
		return indice-1;
	}
}
