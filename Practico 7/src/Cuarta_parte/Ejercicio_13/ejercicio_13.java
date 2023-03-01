package Cuarta_parte.Ejercicio_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*13. Hacer un programa que dado el arreglo definido y precargado, y un número
entero ingresado por el usuario, elimine las secuencias de tamaño igual al
número ingresado. */

public class ejercicio_13 {
    public static final int MAX = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double probabilidad_numero = 0.4;

    public static void main(String[] args) {
        int[] arreglo = new int[MAX];
        int numero;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            cargar_arreglo_aleatorio_secuencias(arreglo);
            imprimir_arreglo_secuencias(arreglo);
            System.out.println("Ingrese un numero (se eliminaran las secuencias de igual tamaño): ");
            numero = Integer.valueOf(entrada.readLine());
            eliminar_secuencias_numero(arreglo, numero);
            imprimir_arreglo_secuencias(arreglo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void eliminar_secuencias_numero(int[] arreglo, int numero) {
        int fin = -1;
        int inicio = 0;
        int tamaño = 0;

        while(inicio < MAX-1) {
            inicio = obtener_inicio_secuencia(arreglo, fin+1);
            if(inicio < MAX-1) {
                fin = obtener_fin_secuencia(arreglo, inicio);
                tamaño = tamaño_secuencia(arreglo, inicio, fin);
                if(tamaño == numero) {
                    for(int i = 0; i < tamaño; i++) {
                        corrimiento_izquierda(arreglo, numero, inicio);
                    }
                    inicio = obtener_inicio_secuencia(arreglo, fin+1);
                }
            }
        }
    }


    public static void corrimiento_izquierda(int[] arreglo, int numero, int inicio) {
        int pos = inicio;
        while(numero > 0 && pos < MAX-1) {
            arreglo[pos] = arreglo[pos+1];
            pos++;
            numero--;
        }
    }

    public static int tamaño_secuencia(int [] arr, int inicio, int fin) {
		return fin-inicio+1;
	}    

    public static int obtener_fin_secuencia(int[] arreglo, int pos) {
        int indice = pos;
        while((indice < MAX) && (arreglo[indice] != 0)) {
            indice++;
        }
        return indice;
    }
    
    public static int obtener_inicio_secuencia(int[] arreglo, int pos) {
        int indice = pos;
        while((indice < MAX) && (arreglo[indice] == 0)) {
            indice++;
        }
        return indice;
    }

    public static void imprimir_arreglo_secuencias(int[] arreglo) {
        System.out.print("Arreglo de secuencias\n|");
        for(int i = 0; i < MAX; i++) {
            System.out.print(arreglo[i] + "|");
        }
        System.out.println("\n");
    }

    public static void cargar_arreglo_aleatorio_secuencias(int[] arreglo) {
        Random r = new Random();
        arreglo[0] = 0;
        arreglo[MAX-1] = 0;
        for(int i = 0; i < MAX; i++) {
            if(r.nextDouble() > probabilidad_numero) {
                arreglo[i] = (r.nextInt(MAXVALOR - MINVALOR +1)+ MINVALOR);
            }
            else {
                arreglo[i] = 0;
            }
        }
    }
}
