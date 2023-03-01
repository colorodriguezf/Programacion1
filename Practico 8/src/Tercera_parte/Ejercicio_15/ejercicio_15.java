package Tercera_parte.Ejercicio_15;

/*15. Hacer un programa que dada la matriz de secuencias de caracteres definida y
precargada elimine todas las secuencias que tienen orden descendente entre
sus elementos. */

import java.util.Random;

public class ejercicio_15 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final char MINVALOR = 'A';
    public static final char MAXVALOR = 'Z';
    public static final double PROBABILIDAD_LETRA = 0.4;

    public static void main(String[] args) {
        char[][] mat = new char[MAXFILA][MAXCOLUMNA];

        cargar_matriz_char_aleatoria(mat);
        System.out.println("\nMatriz inicial\n");
        imprimir_matriz_char_aleatoria(mat);
        eliminar_secuencias_descendentes_matriz(mat);
        System.out.println("\nMatriz sin secuencias descendentes\n");
        imprimir_matriz_char_aleatoria(mat);
      
  }
  
  public static void eliminar_secuencias_descendentes(char[]arr) {
      int inicio = 0;
      int fin = -1;
      while (inicio < MAXCOLUMNA-1) {
          inicio = obtener_ini_secuencia(arr, fin+1);
          if (inicio < MAXCOLUMNA-1) {
              fin = obtener_fin_secuencia(arr, inicio);
                  if (secuencias_orden_descendente(arr, inicio, fin)) {
                      eliminar_secuencias(arr, inicio, fin);
                  }
              inicio = obtener_ini_secuencia(arr, fin+1);
          }
      }
  }
  public static void eliminar_secuencias_descendentes_matriz (char[][] mat) {
      for (int fila = 0; fila < MAXFILA; fila++) {
          eliminar_secuencias_descendentes(mat[fila]);
      }
  }
  
  public static boolean secuencias_orden_descendente (char[]arr, int inicio, int fin) {
      int pos = inicio;
      while (pos < fin && arr[pos] >= arr[pos+1]) {
          pos++;
      }
      if (pos == fin) {
          return true;
      }
      else 
          return false;
  }
  public static void corrimiento_izq(char[]arr, int pos) {
      for (int i = pos; i < MAXCOLUMNA-1; i++) {
          arr[i] = arr[i +1];
      }
  }
  public static void eliminar_secuencias(char[]arr, int inicio, int fin) {
      for (int i = inicio; i <= fin; i++) {
          corrimiento_izq(arr, inicio);
      }
  }
  
  public static int obtener_ini_secuencia(char[]arr, int pos) {
      while (pos < MAXCOLUMNA && arr[pos] == ' ') {
          pos++;
      }
      return pos;
  }
  
  public static int obtener_fin_secuencia(char[]arr, int pos) {
      while (pos < MAXCOLUMNA && arr[pos] != ' ') {
          pos++;
      }
      return pos-1;
  }

    public static void imprimir_matriz_char_aleatoria(char[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz_char_aleatoria(char[][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c = 0; c < MAXCOLUMNA; c++) {
                if(r.nextDouble() > 0.4) {
                    mat[f][c] =(char)(r.nextInt(MAXVALOR - MINVALOR +1) + MINVALOR);
                }
                else {
                    mat[f][c] = ' ';
                }
            }
        }
    }
}
