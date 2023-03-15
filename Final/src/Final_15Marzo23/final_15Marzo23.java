package Final_15Marzo23;

/* 
 * Se tiene un arreglo de numeros enteros con secuencias separadas por uno o mas ceros, 
 * se pide eliminar las secuencias que cumplen con las siguientes condiciones conjuntas :
 * 
 * tengan igual cantidad de numeros impares y pares y a la vez no posean valores multiplos de 5 
 * 
 */

import java.util.Random;

public class final_15Marzo23 {
    public static final int MAX = 30;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 30;
    public static final double PROB_NUMERO = 0.4;
    public static final int MULTIPLO5 = 5;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        cargar_arreglo(arr);
        System.out.print("Arreglo aleatorio de secuencias: \n");
        imprimir_arreglo(arr);
        verificar_secuencias(arr);
        System.out.print("\nArreglo con secuencias eliminadas: \n");
        imprimir_arreglo(arr);
    }


    public static void verificar_secuencias(int[] arr) {
        int inicio = 0;
        int fin = -1;

        while(inicio < MAX-1 && fin < MAX) {
            inicio = buscar_pos_inicio(arr, inicio);
            if(inicio != -1) {
                fin = buscar_pos_fin(arr, inicio);
                if(igualdad_pares_impares(arr, inicio, fin) && !multiplo5(arr, inicio, fin)) {
                    eliminar_secuencias(arr, inicio, fin);
                }
            }
            inicio = buscar_pos_inicio(arr, fin+1);
        }
    }

    public static void corrimiento_izquierda(int[] arr, int pos) {
        while(pos < MAX-1) {
            arr[pos] = arr[pos+1];
            pos++;
        }
    }

    public static void eliminar_secuencias(int[] arr, int inicio, int fin) {
        for(int i=inicio; i<=fin; i++) {
            corrimiento_izquierda(arr,i);
        }
    }

    public static boolean multiplo5(int[] arr, int inicio, int fin) {
        while(inicio <= fin &&  arr[inicio]% MULTIPLO5 == 0) {
            inicio++;
        }
        return (inicio == fin);
    }

    public static boolean igualdad_pares_impares(int [] arr, int inicio, int fin) {
        int par = 0;
        int impar = 0;
        for(int i = inicio; i <= fin; i++) {
            if(es_par(arr[i])) {
                par++;
            }
            else {
                impar++;
            }
        }
        return (par == impar);
    }

    public static boolean es_par(int num) {
        return (num % 2 == 0);
    }

    public static int buscar_pos_fin(int[] arr, int pos) {
        while(pos < MAX-1 && arr[pos] != 0 ) {
            pos++;
        }
        return pos-1;
    }

    public static int buscar_pos_inicio(int[] arr, int pos) {
        while(pos < MAX-1 && arr[pos] == 0) {
            pos++;
        }
        if(pos != -1) {
            return pos;
        }
        else {
            return -1;
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for(int f = 0; f < MAX; f++) {
                System.out.print("|"+arr[f]+"|");
            }
    }

    public static void cargar_arreglo(int[] arr) {
        Random r = new Random();      
            for(int c= 1; c < MAX-1; c++) {
                arr[0] = 0;
                arr[MAX-1] = 0;
                if(r.nextDouble() > PROB_NUMERO) {
                    arr[c] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
                }
                else {
                    arr[c]= 0;
                }
        }
    }
}
