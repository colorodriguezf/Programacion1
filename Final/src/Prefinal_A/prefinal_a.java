package Prefinal_A;

/*Tema 1: Se tiene una matriz de caracteres letra minúscula.
 a) Para las primeras 3 filas que tienen una cantidad impar de vocales, se pide obtener el número de la fila que tiene la menor 
 cantidad de consonantes. 
 b) Agregar en un arreglo de caracteres letra minúscula ordenado ascendente (manteniendo su orden en todo momento), 
 las consonantes mayores al caracter letra ‘f’ de la fila correspondiente al número de fila obtenido en a).
Observaciones:
 _el tamaño del arreglo es igual a la cantidad de filas de la matriz, _la matriz y el arreglo están precargados.
 */

 import java.util.Random;

public class prefinal_a {
    public static final int MAXFILA = 10;
    public static final int MAXCOLUMNA = 10;
    public static final char MINVALOR = 'a';
    public static final char MAXVALOR = 'z';
    public static final char MAYORF = 'f';

    public static void main(String[] args) {
        char[][] mat = new char[MAXFILA][MAXCOLUMNA];
        char[] arr = new char[MAXFILA];
        int fila;

        cargar_matriz(mat);
        System.out.print("Matriz cargada aleatoria: ");
        imprimir_matriz(mat);
        cargar_arreglo(arr);
        fila = obtener_fila_menos_consonantes(mat);
        System.out.print("\na)La fila con cantidad impar de vocales, con menos consonantes es la: "+fila+"\n");
        
        System.out.print("\nArreglo precargado:\n");
        imprimir_arreglo(arr);
        System.out.print("\nArreglo precargado ordenado ascendente:\n");
        ordenar_arr_asc(arr);
        imprimir_arreglo(arr);

        agregar_consonantes_fila_A(mat[fila], arr);
        System.out.print("\nb)Arreglo con consonantes mayor a F de la fila: "+fila+" manteniendo orden:\n");

        imprimir_arreglo(arr);

    }

    public static void agregar_consonantes_fila_A(char[] mat, char[] arr) {
        int pos;
        pos = MAXFILA+1;
        for(int i = 0; i < MAXFILA; i++) {
            if(!esVocal(mat[i]) && mat[i] > MAYORF) {
               pos = obtener_pos_arr(arr, mat[i]);
               corrimiento_derecha(arr, pos);
               arr[pos] = mat[i];
            }
        }
    }

    //si hago corrimiento a derecha y se inserta la letra en ultima posicion, si la siguiente letra a insertar es consonante mayor a f,
    // pero menor a la ultima insertada, al imprimir la mayor se pierde:
    // a insertar la z y despues la j: |a|c|d|q|s| --> |a|c|d|q|Z|
    //                          --> J: |a|c|d|d|q|(corrimiento) --> |a|c|d|J|q|
    public static void corrimiento_derecha(char[]arr, int pos) {
        int posFinal = MAXFILA-1;
        while(posFinal > pos) {
            arr[posFinal] = arr[posFinal-1];
            posFinal--;
        }
    }

    public static int obtener_pos_arr(char[] arr, char car) {
        int pos=0;
        while(pos < MAXFILA-1 && car > arr[pos]) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fila_menos_consonantes(char[][] mat) {
        int fila, cantVocales, cantConsonantes, menorConsonantes, pf3;
        fila = -1;
        cantVocales = 0;
        cantConsonantes = MAXCOLUMNA+1; //empiezo con la mayor cantidad posible +1, entonces siempre es menor;
        menorConsonantes = MAXCOLUMNA+1;
        pf3= 3;
        for(int f=0; f < MAXFILA && pf3 > 0; f++) {
            cantVocales = fila_con_vocal_menos_consonante(mat[f]);
            if(!par(cantVocales)) {
                cantConsonantes = MAXCOLUMNA-cantVocales;
                if(cantConsonantes < menorConsonantes) {
                    menorConsonantes=cantConsonantes;
                    fila = f;
                }
                pf3--;
            }
        }
        return fila;
    }

    public static int fila_con_vocal_menos_consonante(char[] arr) {
        int cantidadVocal;
        cantidadVocal = 0;
        for(int f = 0; f < MAXCOLUMNA; f++) {
            if(esVocal(arr[f])) {
                cantidadVocal++;
            }
        }
        return cantidadVocal;
    }   
    
    public static boolean par(int numero) {
        return(numero%2==0);
    } 
    public static boolean esVocal(char car) {
        return(car=='a'||car=='e'||car=='e'||car=='i'||car=='o'||car=='u');
    }

    public static void imprimir_matriz(char[][] mat) {
        for(int f = 0 ; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void imprimir_arreglo(char[] arr) {
        for(int c = 0; c < MAXCOLUMNA; c++) {
            System.out.print("|"+arr[c]+"|");
        }
    }
    

    public static void cargar_matriz(char[][] mat) {
        Random r = new Random();
        for(int f = 0; f<MAXFILA; f++) {
            for(int c = 0; c<MAXCOLUMNA; c++) {                
             mat[f][c] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }

    public static void cargar_arreglo(char[] arr) {
        Random r = new Random();      
            for(int c = 0; c<MAXFILA; c++) {                
             arr[c] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
    }

    public static void ordenar_arr_asc(char[]arr) {
        char aux;
        for(int i = 1; i < MAXFILA; i++) {
            for(int j = 0; j < MAXFILA-1; j++) {
                if(arr[j]>arr[j+1]) {
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
        }
    }

      
}
