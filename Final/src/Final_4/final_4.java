package Final_4;

/*Tema 2: Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. 
 De dichas filas se pide eliminar la penúltima y la antepenúltima secuencia que tengan al menos 3 números impares.
Observaciones: 
•	Las secuencias están separadas por uno o más ceros, empiezan y terminan con uno o más ceros,
•	Realizar el programa completo sin realizar métodos de carga e impresión de arreglo y matriz, ni utilizar estructuras auxiliares
 */


 import java.util.Random;

public class final_4 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROB_NUMERO = 0.2;

    public static void main (String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int [] arr = new int[MAXFILA];

        cargar_matriz_aleatoria(mat);
        System.out.println("Matriz aleatoria de enteros: ");
        imprimir_mat(mat);
        eliminar_secuencias(mat);
        System.out.print("\nMatriz aleatoria con penúltima y la antepenúltima secuencia eliminada si tiene 3 o mas numeros impares: ");
        imprimir_mat(mat);
    }


    public static void eliminar_secuencias(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            eliminar_secuencias_x_fila(mat[f]);
        }
    }

    public static void eliminar_secuencias_x_fila(int[] arr) {
        int inicio = 0;
        int fin = MAXCOLUMNA-1;
        int cant_secuencias = 0;

        while(fin > 0 && cant_secuencias <=2) {
            fin = buscar_pos_fin(arr, fin);
            if(fin != -1) {
                inicio = buscar_pos_inicio(arr, fin);
                if(cant_secuencias > 0 && cant_secuencias <= 2) {
                    verificar_impar_y_eliminar(arr, inicio, fin);
                } 
                cant_secuencias++;
            }
            fin = buscar_pos_fin(arr, inicio-1);
        }
    }

    public static void verificar_impar_y_eliminar(int[]arr, int inicio, int fin) {
        int cant_impares = 0;
        while(fin >= inicio) {
            if(es_impar(arr[fin])) {
                cant_impares++;
            }
            fin--;
        }
        if(cant_impares >= 3) {
            corrimiento_izquierda(arr, inicio);
        }
    }

    public static void corrimiento_izquierda(int[]arr, int pos) {
        while(pos < MAXCOLUMNA-1) {
            arr[pos] = arr[pos+1];
            pos++;
        }
    }

    public static boolean es_impar(int num) {
        return (num % 2 != 0);
    }

    public static int buscar_pos_inicio(int[] arr, int pos) {
        while(pos > 0 && arr[pos] != 0) {
            pos--;
        }
        return pos+1;
    }

    public static int buscar_pos_fin(int[] arr, int pos) {
        while(pos > 0 && arr[pos] == 0) {
            pos--;
        }
        if(pos != -1) {
            return pos;
        }
        else {
            return -1;
        }
    }

    public static void imprimir_mat(int[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz_aleatoria(int[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            mat[f][0] = 0;
            mat[f][MAXCOLUMNA-1] = 0;
            for(int c = 1; c < MAXCOLUMNA-1; c++) {
                if(r.nextDouble() > PROB_NUMERO) {
                    mat[f][c] = r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR;
                }
                else {
                    mat[f][c] = 0;
                }
            }
        }
    }
}
