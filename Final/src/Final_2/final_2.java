package Final_2;

/*Se tiene una matriz precargada con seciencias de enteros distintos de cero en sus filas. Ademas se tiene precargado un arreglo
 * con algunos numeros de filas. Los numeros de filas no se repiten y estan ubicados de forma consecutiva desde el principio del arreglo.
 * Luego se completa con -1. De dichas filas se pide eliminar la ultima secuencia que cumpla con la condicion de tener solo valores pares.
 * Las fila comienzan y terminan con uno o mas 0
 */

 import java.util.Random;

public class final_2 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROB_NUMERO = 0.4;

    public static void main(String[] args) {
        int[][] mat = new int [MAXFILA][MAXCOLUMNA];
        int[] arr = new int [MAXFILA];

        cargar_matriz(mat);
        System.out.println("Matriz precargada: ");
        imprimir_matriz(mat);
        cargar_arreglo(arr);
        imprimir_arreglo(arr);

        buscar_secuencias(arr, mat);
        System.out.print("\nMatriz con ultima secuencia par eliminada: \n");
        imprimir_matriz(mat);
    }

    public static void buscar_secuencias(int[] arr, int[][] mat) {
        for(int i = 0; i < MAXFILA; i++) {
            buscar_secuencias_pares_x_fila(mat[arr[i]], i); //paso i para imprimir si en esa fila hay sec pares.
        }
    }

    public static void buscar_secuencias_pares_x_fila(int mat[], int posfila) {
        int inicio = -1;
        int fin = MAXCOLUMNA-1;
        boolean pares = false;

        while(fin > 0 && pares == false) {
            fin = obtener_fin_ultima_secuencia(mat, fin);
             if(fin!= -1) {
                inicio = obtener_inicio_ultima_secuencia(mat, fin);
                if(inicio != -1) {
                    pares = verificar_secuencia_par(inicio, fin, mat);
                    if(pares) {
                        System.out.print("FILA: "+posfila +"--> Inicio : "+inicio);
                        System.out.println(" Fin : "+fin);
                        System.out.println("La ultima secuencia de la fila "+posfila+" es de numeros pares: "+pares);
                        eliminar_secuencia_par(inicio, fin, mat);
                   }
                }
               fin = obtener_fin_ultima_secuencia(mat, inicio - 1);
             } 
        }
    }


    public static void corrimiento_izquierda(int mat[], int pos) {
        while(pos < MAXCOLUMNA-1) {
            mat[pos] = mat[pos+1];
            pos++;
        }
    }

    public static void eliminar_secuencia_par(int inicio, int fin, int[] mat) {
        for(int i = inicio; i <= fin; i++) {
            corrimiento_izquierda(mat, i);
        }
    }

    public static boolean verificar_secuencia_par(int inicio, int fin, int[] mat) {
        int contador = 0;
        int pos = inicio;
        while(pos <= fin && mat[pos] % 2 == 0) {
            contador++;
            pos++;
        }
        return (contador == (fin - inicio + 1));
    }

    public static int obtener_inicio_ultima_secuencia(int[] mat, int pos) {
        while(pos >= 0 && mat[pos] != 0) {
            pos--;
        }
        if(pos >= 0) {
            return pos+1;
        }
        else {
            return -1;
        }
    }

    public static int obtener_fin_ultima_secuencia(int[] mat, int pos) {
        while(pos >= 0 && mat[pos] == 0) {
            pos--;
        }
        if(pos > 0) {
            return pos;
        }
        else {
            return -1;
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        System.out.println("\nArreglo: \n");
        for(int i = 0; i < MAXFILA; i++) {
            System.out.print("arr["+i+"] --> "+arr[i]+"\n");
        }
    }

    public static void cargar_arreglo(int[] arr) {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
    }

    public static void imprimir_matriz(int [][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
        System.out.print("\n");
    }

    public static void cargar_matriz(int[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 1; c < MAXCOLUMNA-1; c++) {
                mat[f][0] =0;
                mat[f][MAXCOLUMNA-1] = 0;
                if(r.nextDouble() > PROB_NUMERO) {
                    mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR + 1)+ MINVALOR);
                }
                else {
                    mat[f][c] = 0;
                }
            }
        }
    }
}
