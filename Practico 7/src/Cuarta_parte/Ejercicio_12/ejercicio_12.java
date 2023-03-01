package Cuarta_parte.Ejercicio_12;

import java.util.Random;


/*12. Hacer un programa que dado el arreglo definido y precargado permita
encontrar la posición de inicio y fin de la anteúltima secuencia (considerar
comenzar a buscarla a partir de la ultima posición del arreglo). */

public class ejercicio_12 {
    public static final int MAX = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double probabilidad_numero = 0.4;

    public static void main(String []args) {
        int[] arreglo = new int[MAX];

        cargar_arreglo_aleatorio_secuencias(arreglo);
        imprimir_arreglo_secuencias(arreglo);
        obtener_anteultima_secuencia(arreglo, 2);
    }

    public static void obtener_anteultima_secuencia(int[] arreglo, int pos) {
        int fin = MAX;
        int inicio = MAX-1;
        int i = 0;
        int iniAux = 0;
        int finAux = 0;

        while(inicio >= 0 && pos > i) {
            inicio = obtener_inicio_secuencia(arreglo, fin-1);
            inicio = obtener_inicio_secuencia(arreglo, fin-1);
				if(inicio > 0) {
					fin = obtener_fin_secuencia(arreglo, inicio);
					iniAux = fin;
					finAux = inicio;
					inicio = iniAux;
					fin = finAux;
					i++;
				}				
		}
		System.out.println("inicio "+inicio+ " fin "+fin);
    }
    

    public static int obtener_fin_secuencia(int[]arreglo, int pos) {
		int indice = pos;
		while (indice >=0 && arreglo[indice] !=0) {
			indice--;
		}
		return indice++;
	}

    public static int obtener_inicio_secuencia(int[]arreglo, int pos) {
		int indice = pos;
		while (indice >= 0 && arreglo[indice] == 0) {
			indice--;
		}
		return indice;
	}

    public static void imprimir_arreglo_secuencias(int[] arreglo) {
        System.out.print("Arreglo de secuencias int\n|");
		for (int pos = 0; pos < MAX; pos++) {
			System.out.print(arreglo[pos] + "|");
		}
		System.out.print("\n");
    }

    public static void cargar_arreglo_aleatorio_secuencias(int[] arreglo) {
        Random r = new Random();
        arreglo[0] = 0;
        arreglo[MAX -1] = 0;
        for(int pos = 1; pos < MAX -1; pos++ ) {
            if(r.nextDouble() > probabilidad_numero) {
                arreglo[pos] = (r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
            }
            else {
                arreglo[pos] = 0;
            }
        }
    }


}
