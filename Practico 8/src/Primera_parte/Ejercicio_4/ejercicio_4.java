package Primera_parte.Ejercicio_4;

/*4. Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y una posición fila, columna. Con estos
datos tendrá que realizar un corrimiento a derecha (se pierde el último valor en dicha fila)
y colocar el numero en la matriz en la posición fila, columna indicada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_4 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
        int[][] mat = new int[MAXFILA][MAXCOLUMNA];
        int numero, posfila, poscolumna;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            cargar_matriz_aleatoria(mat);
            imprimir_matriz_aleatoria(mat);
            System.out.print("\nIngrese un numero entero a insertar en la matriz: ");
            numero = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese un numero posicion fila: ");
            posfila = Integer.valueOf(entrada.readLine());
            System.out.print("Ingrese un numero posicion columna: ");
            poscolumna = Integer.valueOf(entrada.readLine());
            corrimiento_derecha(mat[posfila], poscolumna);
            System.out.print("\nMatriz con corrimiento a derecha en mat["+posfila+"]["+poscolumna+"]");
            imprimir_matriz_aleatoria(mat);
            mat[posfila][poscolumna] = numero;
            System.out.println("\nMatriz con numero insertado y corrimiento: ");
            imprimir_matriz_aleatoria(mat);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void corrimiento_derecha(int[] mat, int poscolumna) {
        int pos = MAXCOLUMNA - 1;
        while(pos > poscolumna) {
            mat[pos] = mat[pos-1];
            pos--;
        }
    }

    public static void imprimir_matriz_aleatoria(int[][] mat) {
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
            for(int c = 0; c < MAXCOLUMNA; c++) {
                mat[f][c] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }
}
