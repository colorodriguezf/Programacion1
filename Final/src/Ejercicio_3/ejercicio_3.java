package Ejercicio_3;

/* Se tiene una matriz que ocntiene caracteres letra minuscula.
 * a) Se pide obtener el numero de la fila que tiene
 *  menor cantidad de consonantes menores al caracter 'm'.
 * b) Determinar si en un arreglo dado de caracteres letra minuscula ordenado ascendente, estan todas las consonantes incluidas en la
 *  fila correspondiente al numero de fila obtenido en a.
 */

import java.util.Random;

public class ejercicio_3 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 'a';
    public static final int MAXVALOR = 'z';

    public static void main(String [] args) {
        char[][] mat = new char[MAXFILA][MAXCOLUMNA];
        char[] arr = new char[MAXCOLUMNA];

        int fila;
        //a)
        cargar_matriz(mat);
        System.out.print("Matriz precargada aleatoria:");
        imprimir_matriz(mat);
        fila = columna_menos_consonante_menor_m(mat, arr);
        System.out.print("\na) La fila que menos consonantes tiene, menores a la letra 'm' es la fila: "+fila);
        System.out.print("\n----------------------------------------------------------------------------\n");
        //b)
        cargar_arr(arr);
        ordenar_asc_arreglo(arr);
        System.out.print("\n Arreglo precargada aleatoria ordenado ascendente:\n");
        imprimir_arr(arr);
        verificar_consonantes(arr, mat[fila], fila);
    }

    //a)
    public static int columna_menos_consonante_menor_m(char[][] mat, char[] arr) {
        int cantidad = -1;
        int cantidad_menor = 100;
        int fila = 0;
        for(int f = 0; f < MAXFILA; f++) {
            cantidad = columna_menos_consonante(mat[f]);
            if(cantidad < cantidad_menor) {
                fila = f;
                cantidad_menor = cantidad;
            }
        }
        System.out.print("\nFILA: "+fila+" | CANTIDAD: "+cantidad);
        return fila;
    }

    public static int columna_menos_consonante(char[] arr) {
        int contador = 0;
        for(int i = 0; i < MAXCOLUMNA; i++) {
            char letra = arr[i];
            if(letra!='a' && letra!='e' && letra!= 'i' && letra!='o' && letra!='u' &&
             letra < 'm') {
                contador++;
             }
        }
        return contador;
    }

    //b

    public static void ordenar_asc_arreglo(char[] arr) {
        int aux;
        for(int i = 1; i < MAXCOLUMNA; i++) {
            for(int j = 0; j < MAXCOLUMNA-1; j++) {
                if(arr[j] > arr[j+1]) {
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = (char)aux;
                }
            }
        }
    }
    public static void verificar_consonantes(char[]arr, char[] mat, int fila) {
        int totaconsonantesM;
        totaconsonantesM = totalconsonantesMat(mat);
        int coincidencia = 0;
        for(int a = 0; a < MAXCOLUMNA; a++) {
            for(int m = 0; m < MAXCOLUMNA; m++) {
                if(mat[m] == arr[a]) {
                    coincidencia++;
                }
            }
        }
        if(coincidencia == totaconsonantesM) {
            System.out.println("\nb) El arreglo contiene todas las consonantes que tiene la matriz en la fila: "+fila);
        }
        else {
            System.out.println("\nb) Las cantidades no coinciden: MAT: "+coincidencia+", ARR: "+totaconsonantesM);
        }
    }  

    public static int totalconsonantesMat(char[] arr) {
        int contador=0;
          for(int i = 0; i < MAXCOLUMNA; i++) {
            char letra = arr[i];
            if(letra!='a' && letra!='e' && letra!= 'i' && letra!='o' && letra!='u') {
                contador++;
             }
        }
        return contador;
    }

    public static void imprimir_matriz(char[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }


    public static void cargar_matriz(char [][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c= 0; c < MAXCOLUMNA; c++) {
                    mat[f][c] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);    
            }
        }
    }


    public static void cargar_arr(char[] arr) {
        Random r = new Random();
            for(int c= 0; c < MAXCOLUMNA; c++) {
                    arr[c] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);    
            }
    }

    public static void imprimir_arr(char[] arr) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+arr[c]+"|");
            }
    }
}
