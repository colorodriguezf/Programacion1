package Tercera_parte.Ejercicio_10;

/*10.Se tiene una matriz de enteros de tamaño 4*20 de secuencias de números
entre 1 y 9 (por cada fila), separadas por 0. La matriz esta precargada, y
además cada fila empieza y termina con uno o más separadores 0.
 Hacer un programa que dada la matriz de secuencias de enteros definida
y precargada, 
--> permita obtener a través de métodos la posición de inicio y
la posición de fin de la secuencia ubicada a partir de una posición entera
y una fila, ambas ingresadas por el usuario. Finalmente, si existen imprima
por pantalla ambas posiciones obtenidas.  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_10 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROBABILIDAD_NUMERO = 0.4;

    public static void main(String [] args) {
        int [][] mat = new int [MAXFILA][MAXCOLUMNA];
        int inicio, fin;
        int fila, posicion;

        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
		
		try {
            cargar_matriz_aleatorio_secuencias_int(mat);
			imprimir_matriz_aleatoria(mat);
			System.out.println("\nIngrese una posicion");
			posicion = Integer.valueOf(entrada.readLine());
			System.out.println("Ingrese una fila");
			fila = Integer.valueOf(entrada.readLine());
            inicio = obtener_inicio_secuencia(mat[fila], posicion);
            fin = obtener_fin_secuencia(mat[fila], inicio);
            System.out.println("La secuencia inicia en " + inicio);
			System.out.println("La secuencia termina en " + (fin-1));
        } catch (Exception e) {
			System.out.println(e);
		}
    }

    public static int obtener_fin_secuencia(int[] arr, int inicio) {
        int indice = inicio;
       while(indice < MAXCOLUMNA && arr[indice] !=0) {
            indice++;
       }
       return indice;
    }

    public static int obtener_inicio_secuencia(int[] arr, int posicion) {
        int indice = posicion;
        while(indice < MAXCOLUMNA && arr[indice] == 0) {
            indice++;
        }
        return indice;
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
