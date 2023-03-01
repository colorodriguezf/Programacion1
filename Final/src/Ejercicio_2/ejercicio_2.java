package Ejercicio_2;

/*2. Se tiene dos arreglos de secuencias de caracteres letra. Se pide realizar un programa (sin metodo de carga del arreglo) que
 intercambie la secuencia de mayor tamaño de A por la secuencia de mayor tamaño de B.
Observaciones generales:
•	Todos los arreglos de secuencias empiezan y terminan con espacios
•	Las secuencias estan separadas por uno o mas espacios
•	Todos los arreglos mencionados tienen tamaño MAX
•	No utilizar estructuras auxiliares */

import java.util.Random;

public class ejercicio_2 {
    public static final char MINVALOR = 'A';
    public static final char MAXVALOR = 'Z';
    public static final int MAXTAM = 15;
    public static final double PROB_LETRA = 0.4;

    public static void main(String[] args) {
        char[] arrA = new char[MAXTAM];
        char[] arrB = new char[MAXTAM];

        cargar_arreglos(arrA, arrB);
        imprimir_arreglos(arrA, arrB);
        intercambiar_secuencias(arrA, arrB);
        imprimir_arreglos(arrA, arrB);

    }


    public static void secuencia_mayor_valor(char[] arrA,char[] arrOtro, char letra) {
        int inicio = 0;
        int fin = -1;
        int posI =0;
        int posF = 1;
        int tam =0;
        int tamMayor = 0;
        while(inicio < MAXTAM-1) {
            inicio = obtener_inicio_secuencia(arrA, inicio);
            if(inicio < MAXTAM-1) {
                fin = obtener_fin_secuencia(arrA, inicio);
                tam = tamanio_sec(inicio, fin);
                if(tam > tamMayor) {
                    tamMayor = tam;
                    posI = inicio;
                    posF = fin;
                }
                inicio = obtener_inicio_secuencia(arrA, fin+1);
            }
        }
        intercambiar(arrA, arrOtro, posI, posF);
        System.out.println("\nMayor secuencia ARREGLO "+letra+" INICIO: "+posI+" FIN: "+posF);
    }


    public static void intercambiar(char[]arr, char[] arrOtro, int posI, int posF) {
        //ESTO INTERCAMBIA LA SEC DE A POR LA DE B, PERO PIERDO LOS DATOS DE B
        //Y NO SE COMO INTERCAMBIAR ESOS VALORES PERDIDOS POR LOS DE A.

        for(int i = posI; i <= posF; i++) {
            arrOtro[i] = arr[i];
        }
    }

    public static int tamanio_sec(int inicio, int fin) {
        return fin - inicio;
    }
    public static int obtener_fin_secuencia(char[] arr, int pos) {
        while(pos < MAXTAM-1 && arr[pos] != ' ') {
            pos++;
        }
        return pos-1;
    }

    public static int obtener_inicio_secuencia(char[] arr, int inicio) {
        while(inicio < MAXTAM && arr[inicio] == ' ') {
            inicio++;
        }
        return inicio;
    }
    public static void intercambiar_secuencias(char[] arrA, char[] arrB) {
        secuencia_mayor_valor(arrA, arrB, 'A');
        secuencia_mayor_valor(arrB, arrA, 'B');
    }

    public static void imprimir_arreglos(char[] arrA, char[] arrB) {
        imprimir_arreglo(arrA, 'A');
        imprimir_arreglo(arrB, 'B');
    }

    public static void imprimir_arreglo(char[] arr, char letra) {
        System.out.print(":\nArreglo"+letra+":\n");
        for(int i = 0; i < MAXTAM; i++) {
            System.out.print("|"+arr[i]+"|");
        }
    }

    public static void cargar_arreglos(char[] arrA, char[] arrB) {
        cargar_arreglo(arrA);
        cargar_arreglo(arrB);
    }

    public static void cargar_arreglo(char[] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXTAM-1] = ' ';
        for(int i = 1; i < MAXTAM-1; i++) {
            if(r.nextDouble() > PROB_LETRA) {
                arr[i] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
            else {
                arr[i] = ' ';
            }
        }
    }
}
