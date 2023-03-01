package Tercera_parte.Ejercicio_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*10. Hacer un programa que dado el arreglo definido y precargado permita
obtener a través de métodos la posición de inicio y la posición de fin de la
secuencia ubicada a partir de una posición entera ingresada por el
usuario. Finalmente, si existen imprima por pantalla ambas posiciones
obtenidas.  */
public class ejercicio_10 {
    public static final int MAX = 15;
	public static final int MAXVALOR = 9;
	public static final int MINVALOR = 1;
	public static final double probabilidad_letra = 0.4;
	public static final double probabilidad_numero = 0.4;

    public static void main(String[] args) {
		int arreglo[] = new int [MAX];
		int pos=0;
		int posInic = 0;
		int posFin=0;
		
		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		try {
            cargar_arreglo_aleatorio_secuencias_int(arreglo);
            imprimir_arreglo_secuencias_int(arreglo);
            System.out.println("ingrese una secuencia: ");
			pos = Integer.valueOf(entrada.readLine());
            posInic = obtener_inic_secuencia(arreglo, pos);
			posFin = obtener_fin_secuencia(arreglo, posInic);
            System.out.println("La posicion inicial es " +posInic+ " y la posicion final es " +posFin );

        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public static int obtener_inic_secuencia(int[] arr, int pos ) {
		int indice=pos;
		while ((indice < MAX ) && (arr[indice] == 0)){
			indice++;;
		}
		return indice;
	}

	public static int obtener_fin_secuencia(int[] arr, int posIni) {
		int indice = posIni;
		while ((indice < MAX) && (arr[indice] != 0)) {
			indice++;
		}
		return indice-1;
	}

	public static void imprimir_arreglo_secuencias_int(int[] arr) {
		System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arr[pos] + "|");
		}
		System.out.print("\n");
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
}
