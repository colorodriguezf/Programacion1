package Segunda_parte.Ejercicio_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*8. Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y elimine la primer ocurrencia de numero (un número igual) en el
arreglo si existe.
 */
public class ejercicio_8 {
    public static final int MAX = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 10;

    public static void main(String[] args) {
        int[] arreglo = new int[MAX];
        int posicion;
        int numero;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            cargar_arreglo(arreglo);
            System.out.println("\nArreglo desordenado: \n");
            imprimir_arreglo(arreglo);
            ordenar_arreglo_burbujeo(arreglo);
            System.out.println("\nArreglo ordenado: \n");
            imprimir_arreglo(arreglo);
            System.out.println("\nInserte un numero:");
            numero = Integer.valueOf(entrada.readLine());
            posicion = obtener_posicion_arreglo(arreglo,numero);
            System.out.println("El numero:"+numero+" se encuentra en la posicion: "+posicion+"\n");
            corrimiento_izquierda(arreglo, posicion);
            imprimir_arreglo(arreglo);


        }catch(Exception e){
            System.out.println(e);
        }
    }


    public static void corrimiento_izquierda(int[] arreglo, int posicion){
        int posinicial = posicion;
        while(posinicial < MAX-1) {
            arreglo[posinicial] = arreglo[posinicial + 1];
            posinicial++;
        } 
    }

    public static int obtener_posicion_arreglo(int[] arreglo, int numero) {
        int pos = 0;
        while(pos < MAX && arreglo[pos] < numero) {
            pos++;
        }
        return pos;
    }

    public static void ordenar_arreglo_burbujeo(int[] arreglo) {
        int temp;
        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX-1; j++) {
                if(arreglo[j] > arreglo[j+1]) {
                    temp = arreglo[j]; //se guarda en temp, porque si arreglo[j+1] = arreglo[j], arreglo[j] ya vale arreglo[j+1] entonces se repetirian siempre los mismos valores
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = temp;
                }
            }
        }
    }

    public static void imprimir_arreglo(int[] arreglo){
        for(int i = 0; i < MAX; i++){
            System.out.println("arreglo["+i+"] --> "+arreglo[i]);
        }
    }

    public static void cargar_arreglo(int[]arreglo) {
        Random r = new Random();
        for(int i = 0; i < MAX; i++) {
            arreglo[i] = r.nextInt((MAXVALOR - MINVALOR) + MINVALOR);
        }
    }
}
