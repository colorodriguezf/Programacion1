package Recuperatorio_2022;

/*Tema 1: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. Se pide guardar en un arreglo los
 números de filas de las primeras 4 filas que cumplen con la condición de tener a lo sumo 3 secuencias sin orden ascendente.
Observaciones: _el tamaño arreglo es igual a la cantidad de filas de la matriz, y está inicializado con -1,
_las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
_realizar el programa completo sin realizar métodos de carga e impresión de matriz, ni utilizar estructuras auxiliares.
 */

 import java.util.Random;

 
 public class recuperatorio_2022 {
    public static final int MAXFILA = 10;
    public static final int MAXCOLUMNA = 30;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROB_NUM = 0.4;
    public static final int CANT_SEC_SOA = 3;
    public static final int CANT_FILAS = 4;

    public static void main(String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int[] arrFil = new int[MAXFILA];

        cargar_matriz(mat);
        System.out.print("Matriz precargada aleatoria:\n");
        imprimir_matriz(mat);

        guardar_en_arreglo_filas(mat, arrFil);
        System.out.print("\nArreglo con números de filas de las primeras 4 filas que cumplen con la condición:\n");
        imprimir_arreglo(arrFil);

    }

    public static void guardar_en_arreglo_filas(int[][] mat, int[] arrFil) {
        int cant, posArr, cantFilas;
        cant = 0;
        posArr = 0;
        cantFilas = 0;
        for(int f = 0; f < MAXFILA; f++) {
            cant = verificar_secuencias_x_fila(mat[f]);
            if(cant >= CANT_SEC_SOA && cantFilas < CANT_FILAS) {
                arrFil[posArr] = f;
                posArr++;
                cantFilas++;
            }
        }
    }

    public static int verificar_secuencias_x_fila(int[] arr) {
        int inicio = 0;
        int fin = -1;
        int cant = 0;

        while(inicio < MAXCOLUMNA-1) {
            inicio = buscar_pos_inicio(arr, inicio);
            if(inicio != -1) {
                fin = buscar_pos_fin(arr, inicio);
                if(fin != -1) {
                    if(!secuencia_ordenada(arr, inicio, fin)) {
                        cant++;
                    }
                }
            }
            inicio = buscar_pos_inicio(arr, fin+1);
        }
        return cant;
    }

    public static boolean secuencia_ordenada(int[] arr, int inicio, int fin) {
        while(inicio < fin && arr[inicio] < arr[inicio+1]) {
            inicio++;
        }
        return (inicio == fin);
    }

    public static int buscar_pos_inicio(int[]arr, int pos) {
        while(pos < MAXCOLUMNA-1 && arr[pos]== 0) {
            pos++;
        }
        if(pos != -1) {
            return pos;
        }
        else {
            return -1;
        }
    }

    public static int buscar_pos_fin(int[]arr, int pos) {
        while(pos < MAXCOLUMNA-1 && arr[pos]!= 0) {
            pos++;
        }
        return pos-1;
    }

    public static void imprimir_arreglo(int[] arr) {
        for(int i = 0; i < MAXFILA; i++) {
            System.out.print("| fila "+arr[i]+"|");
        }
    }

    public static void imprimir_matriz(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            System.out.print("fila "+f+" --> ");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz(int [][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c= 1; c < MAXCOLUMNA-1; c++) {
                mat[f][0] = 0;
                mat[f][MAXCOLUMNA-1] = 0;
                if(r.nextDouble() > PROB_NUM) {
                    mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
                }
                else {
                    mat[f][c]= 0;
                }
            }
        }
    }
}
