package Cuarta_parte.Ejercicio_11;

import java.util.Random;

/*11. Hacer un programa que dado el arreglo definido y precargado permita
encontrar la posición de inicio y fin de la secuencia cuya suma de valores sea
mayor. */

public class ejercicio_11 {
    public static final int MAX = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int[] arreglo = new int[MAX];
        cargar_arreglo_aleatorio_secuencias(arreglo);
        imprimir_arreglo_secuencias(arreglo);
        imprimir_suma_mayor_secuencia(arreglo);
    }


    public static void imprimir_suma_mayor_secuencia(int[] arreglo) {
        int inicio = 0;
        int fin = -1;
        int suma = 0;
        int sumaMayor = 0;
        int inicioMayor = 0;
        int finMayor = 0;

        while(inicio < MAX-1) {
            inicio = obtener_inicio_secuencia(arreglo, fin+1);
            if(inicio < MAX-1) {
                fin = obtener_fin_secuencia(arreglo, inicio);
                System.out.println("Inicio secuencia = " +inicio+ "\nFin secuencia= "+fin);
                suma = obtener_suma_secuencia(arreglo, inicio,fin);
                if(suma > sumaMayor) {
                    sumaMayor = suma;
                    inicioMayor = inicio;
                    finMayor = fin;
                    inicio = obtener_inicio_secuencia(arreglo, fin+1);
                }
            }
        }
        System.out.println("La secuencia mayor suma "+ sumaMayor +" comenzando en la posicion "+inicioMayor+" y terminando en la posicion "+finMayor);
    }

    public static int obtener_suma_secuencia(int[] arreglo, int inicio, int fin) {
        int suma = 0;
        while(inicio <= fin) {
            suma += arreglo[inicio];
            inicio++;
        }
        return suma;
    }

    public static int obtener_fin_secuencia(int[] arreglo, int pos) {
        int indice = pos;
        while((indice < MAX) && (arreglo[indice] != 0)) {
            indice++;
        }
        return indice;
    }
    
    public static int obtener_inicio_secuencia(int[] arreglo, int pos) {
        int indice = pos;
        while((indice < MAX) && (arreglo[indice] == 0)) {
            indice++;
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
        arreglo[MAX-1] = 0;
        for(int pos = 1; pos < MAX; pos ++) {
            if(r.nextDouble() > probabilidad_numero) {
                arreglo[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
            arreglo[pos] = 0;        
            }
        }
    }
}
