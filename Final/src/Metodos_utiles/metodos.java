package Metodos_utiles;
//Metodos utiles de arreglos y matrices
import java.util.Random;

public class metodos {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROB_NUMERO = 0.2;

    public static void main (String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int [] arr = new int[MAXFILA];
        System.out.print("-------------ARREGLOS--------------------\n");
        System.out.print("Arreglo de prueba: \n");
        cargar_arreglo(arr);
        imp_arreglo(arr);
        ordenar_mayor_a_menor(arr);
        System.out.print("\nArreglo ordenado de mayor a menor: \n");
        imp_arreglo(arr);
        ordenar_menor_a_mayor(arr);
        System.out.print("\nArreglo ordenado de menor a mayor: \n");
        imp_arreglo(arr);

        //---------------------------------------------------
        System.out.print("\n\n\n-------------MATRICES--------------------");
        cargar_matriz_aleatoria(mat);
        System.out.println("\nMatriz aleatoria de enteros: ");
        imprimir_mat(mat);
    }
    //ARREGLOS:
    public static void cargar_arreglo(int[] arr) {
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 1;
        arr[3] = 4;
        arr[4] = 3;


    }

    //ORDENA DE MAYOR A MENOR UN ARREGLO
    //SI ES UNA SECUENCIA --> DEBE RECIBIR POS INICIO Y POS FIN, Y SE REEMPLAZAN EN LOS < DE LOS FOR
    public static void ordenar_mayor_a_menor(int[] arr) {
        int aux = 0;
       for(int i = 1; i < MAXFILA; i++) {
        for(int j = 0; j < MAXFILA -1; j++) {
            if(arr[j] < arr[j + 1]) {
                aux = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = aux;
            }
        }
       }
    }

     //ORDENA DE MENOR A MAYOR UN ARREGLO
    //SI ES UNA SECUENCIA --> DEBE RECIBIR POS INICIO Y POS FIN, Y SE REEMPLAZAN EN LOS < DE LOS FOR
    public static void ordenar_menor_a_mayor(int[] arr) {
        int aux = 0;
       for(int i = 1; i < MAXFILA; i++) {
        for(int j = 0; j < MAXFILA -1; j++) {
            if(arr[j] > arr[j + 1]) {
                aux = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = aux;
            }
        }
       }
    }

    public static void imp_arreglo(int[] arr) {
        for(int i = 0; i < MAXFILA; i++) {
            System.out.print("|"+arr[i]+"|");
        }
    }

    //--------------------------------------------------------------------------------------------
    //MATRICES:

    //recibo arreglo, y posicion: mientras pos < MAXCOLUMNA y esa pos sea == 0: sumo pos++;
    //si pos == 0; corta y devuelve donde inicia la secuencia 
    public static int buscar_pos_inicio(int[] arr, int pos) {
        while(pos < MAXCOLUMNA-1 && arr[pos] == 0) {
            pos++;
        }
        if(pos != -1) {
            return pos;
        }
        else{
            return -1;
        }
    }
    
    //recibo arreglo, y posicion: mientras pos < MAXCOLUMNA y esa pos sea != 0: sumo pos++;
    //si pos == 0; corta y devuelve donde inicia la secuencia, como esa posicion es donde esta 0, devolvemos pos-1
    //si el arreglo es 01230, la sec inicia en pos 1 y termina en 4(que es 0, pq como la pos 3 != 0 entonces pos++ vale 4)
    // pero pos 4 es 0, entonces devolviendo pos-1.. inicia en 1, y termina en pos 3
    public static int buscar_pos_fin(int[] arr, int pos) {
        while(pos < MAXCOLUMNA-1 && arr[pos] != 0 ) {
            pos++;
        }
        return pos-1;
    }


    //Carga e imppresion de matriz aleatoria:
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
            mat[f][0] = 0; //char = ' '
            mat[f][MAXCOLUMNA-1] = 0; //char = ' '
            for(int c = 1; c < MAXCOLUMNA-1; c++) {
                if(r.nextDouble() > PROB_NUMERO) {
                    mat[f][c] =  /*(char) */ r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR;
                }
                else {
                    mat[f][c] = 0;
                    /*mat[f][c] = ' '; */
                }
            }
        }
    }
    //--------------------------------------------------------------
}
