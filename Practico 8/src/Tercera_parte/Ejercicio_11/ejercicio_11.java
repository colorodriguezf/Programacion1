package Tercera_parte.Ejercicio_11;

/*10.Se tiene una matriz de enteros de tamaño 4*20 de secuencias de números
entre 1 y 9 (por cada fila), separadas por 0. La matriz esta precargada, y
además cada fila empieza y termina con uno o más separadores 0.
--> Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada permita encontrar por cada fila la posición de inicio y fin de la
secuencia cuya suma de valores sea mayor. */

import java.util.Random;

public class ejercicio_11 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROBABILIDAD_NUMERO = 0.4;

    public static void main(String [] args) {
        int [][] mat = new int [MAXFILA][MAXCOLUMNA];
		
		try {
            cargar_matriz_aleatorio_secuencias_int(mat);
			imprimir_matriz_aleatoria(mat);
            obtener_secuencia_mayorvalor(mat);
        } catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public static void obtener_secuencia_mayorvalor(int [][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            obtener_secuencia_mayor_valor_x_fila(mat[f], f);
        }
    }
    
    public static void obtener_secuencia_mayor_valor_x_fila(int[] arr, int f) {
        int inicio = 0;
        int fin = 0;
        int suma;
        int sumaMayor = 0;
        int inicioMayor = 0;
        int finMayor= 0;

        while(inicio < MAXCOLUMNA) {
            inicio = obtener_inicio_secuencia(arr,inicio);
            if(inicio < MAXCOLUMNA) {
                fin = obtener_fin_secuencia(arr,inicio);
                suma = obtener_suma_secuencia(arr, inicio, fin);
                if(suma > sumaMayor) {
                    sumaMayor = suma;
                    inicioMayor = inicio;
                    finMayor = fin;
                }
                inicio = obtener_inicio_secuencia(arr, fin + 1);
            }
        }
        System.out.println("\nLa suma de las secuencias de mayor valor en la fila: "+f+" entre : "+ inicioMayor+ " y "+ finMayor+ " es "+ sumaMayor);
        
    }
    
    public static int obtener_suma_secuencia(int[] arr, int inicio, int fin) {
        int suma = 0;
        for(int i = inicio; i < fin; i++) {
            suma+= arr[i];
        }
        return suma;        
    }
    
    public static int obtener_fin_secuencia(int[] arr, int inicio) {
        while(inicio < MAXCOLUMNA && arr[inicio] != 0) {
            inicio++;
        }
        return inicio-1;
    }
    
    public static int obtener_inicio_secuencia(int[] arr, int inicio) {
        while(inicio < MAXCOLUMNA && arr[inicio] == 0) {
            inicio++;
        }
        return inicio;
    }
    

    
    public static void imprimir_matriz_aleatoria(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz_aleatorio_secuencias_int(int[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            mat[f][0] = 0;
            mat[f][MAXCOLUMNA-1] = 0;
            for(int c = 1; c < MAXCOLUMNA-1; c++) {
                if(r.nextDouble() > PROBABILIDAD_NUMERO) {
                    mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
                } else {
                    mat[f][c] = 0;
                }
            }
        }
    }
}
