package Tercera_parte.Ejercicio_12;

/*12. Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada, permita encontrar por cada fila la posición de inicio y fin de la
anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima
posición de la fila). */

import java.util.Random;

public class ejercicio_12 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 8;
    public static final char MINVALOR = 'A';
    public static final char MAXVALOR = 'Z';
    public static final double PROBABILIDAD_LETRA = 0.4;

    public static void main(String[] args) {
        char[][] mat = new char [MAXFILA][MAXCOLUMNA];

        cargar_matriz_aleatorio_secuencias_char(mat);
        imprimir_matriz_aleatoria(mat);
        encontrar_anteultima_secuencia(mat);
        
    }

    public static void encontrar_anteultima_secuencia(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            encontrar_anteultima_secuencia_fila(mat[fila]);
        }
    }

    public static void encontrar_anteultima_secuencia_fila(char[] arr) {
        int contador = 0;
        int inicio = -1;
        int finAnteultima = -1;
        int inicioAnteultima = -1;
        int fin = buscar_posicion_fin(arr, MAXCOLUMNA-1);
        while(fin != -1) {
            inicio = buscar_posicion_inicio(arr, fin);
            if(inicio != -1) {
                if(contador == 1) {
                    inicioAnteultima = inicio;
                    finAnteultima = fin;
                }
                contador++;
                fin = buscar_posicion_fin(arr, inicio - 1);
            }
        }
        System.out.print("\nPosicion inicio de la anteultima secuencia: "+inicioAnteultima+"\nPosicion fin de anteultima secuencia: "+finAnteultima);
    }

    public static int buscar_posicion_inicio(char[] arr, int pos) {
        while(pos >= 0 && arr[pos] != ' ') {
            pos--;
        }
        if(pos >= 0) {
            return pos;
        }
        else {
            return -1;
        }
    } 


    public static int buscar_posicion_fin(char[] arr, int pos) {
        while(pos >= 0 && arr[pos] == ' ') {
            pos--;
        }
        if(pos >= 0) {
            return pos;
        }
        else {
            return -1;
        }
    }



    public static void imprimir_matriz_aleatoria(char[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz_aleatorio_secuencias_char(char[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            System.out.println("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                if(r.nextDouble() > PROBABILIDAD_LETRA) {
                    mat[f][c] = (char)(r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
                } else {
                    mat[f][c] = ' ';
                }
            }
        }
    }

}
