package Primera_parte.Ejercicio_3;
/*3. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario una posición y realice un corrimiento a izquierda o hacia la
menor posición del arreglo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ejercicio_3 {
    public static final int MAX = 10; //tamaño arreglo
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 10;

    public static void main(String[] args) {
        int pos;
        int[] arrenteros = new int[MAX];

        BufferedReader entrada = new BufferedReader ( new InputStreamReader (System.in));

        try {
            cargar_arreglo_aleatorio(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese una posicion");
            pos = Integer.valueOf(entrada.readLine());
            corrimiento_izquierda(arrenteros, pos);
            imprimir_arreglo(arrenteros);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void corrimiento_izquierda(int[] arrenteros, int pos) {
        int posinicial = 0;
        while (posinicial < pos) {
            arrenteros[posinicial] = arrenteros[posinicial + 1];
            posinicial++;
        }
    }

    public static void cargar_arreglo_aleatorio(int[] arrenteros) {
        Random r = new Random();
        for(int i = 0; i < MAX; i++) {
            arrenteros[i] = (r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
        }
    }

    public static void imprimir_arreglo(int [] arrenteros) {
        for(int i = 0; i < MAX; i++) {
            System.out.println("arrenteros[" +i+ "] --> "+arrenteros[i]);
        }
    }
}
