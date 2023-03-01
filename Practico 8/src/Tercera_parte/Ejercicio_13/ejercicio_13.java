package Tercera_parte.Ejercicio_13;

/*13. Hacer un programa que dada la matriz de secuencias de enteros definida y
precargada, y un número entero ingresado por el usuario, elimine de cada fila
las secuencias de tamaño igual al número ingresado.
 */

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.util.Random;
 
 public class ejercicio_13 {
     public static final int MAXFILA = 4;
     public static final int MAXCOLUMNA = 20;
     public static final int MAXVALOR = 9;
     public static final int MINVALOR = 1;
     public static int MAX = 20;
     
     public static final double probabilidad_numero = 0.4;
     public static void main(String[] args) {
         int [][] matint = new int[MAXFILA][MAXCOLUMNA];
         int entero;
         
         BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));
         try {
             cargar_matriz_aleatorio_secuencias_int(matint);
             imprimir_matriz_secuencias_int(matint);
             System.out.println("ingrese un tamaño de secuencia");
             entero = Integer.valueOf(entrada.readLine());
             eliminar_por_fila(matint, entero);
             imprimir_matriz_secuencias_int(matint);
             
         } catch (Exception e) {
             System.out.println(e);
         }
 
     }
     public static void eliminar_por_fila(int[][]mat, int numero) {
             for (int i = 0; i < MAXFILA; i++) {
                 eliminar_secuencias(mat[i], numero);
             }
         
     }
     
     public static void eliminar_secuencias(int[]mat, int numero) {
         int fin = -1;
         int tamaño = 0;
         int inicio = 0;
         while(inicio < MAX-1) {
             inicio = obtener_inicio_secuencia(mat, fin+1);
             if (inicio < MAX-1) {
                 fin = obtener_fin_secuencia(mat, inicio);
                 tamaño = tamaño_secuencia(mat, inicio, fin);
                 if (tamaño == numero) {
                     eliminar_secuencias_tamaño(mat, inicio, fin);
                     fin = inicio-1;
                 }
                 inicio = obtener_inicio_secuencia(mat, fin+1);
             }
         } 
     }
     
     private static void corrimiento_izquierda(int[] arr, int pos) {
         while (pos < MAXCOLUMNA-1) {
             arr[pos] = arr[pos+1];
             pos++;
         }
     }
     
     public static void eliminar_secuencias_tamaño(int[]arr, int inicio, int fin) {
         for (int i = inicio; i <=fin; i++) {
             corrimiento_izquierda(arr, i);			
         }
     }
     public static int obtener_inicio_secuencia(int[] mat, int pos) {
         while (pos < MAX-1 && mat[pos] == 0) {
             pos++;
         }
         return pos;
     }
     public static int obtener_fin_secuencia(int[]mat, int pos) {
         while (pos < MAX-1 && mat[pos] != 0) {
             pos++;
         }
         return pos-1;
     }
     public static int tamaño_secuencia(int[]mat, int inicio, int fin) {
         return fin-inicio+1;
     }
     public static void cargar_matriz_aleatorio_secuencias_int(int[][] mat) {
         for (int fila = 0; fila < MAXFILA; fila++) {
             cargar_arreglo_aleatorio_secuencias_int(mat[fila]);
         }
         System.out.println("");
     }
 
     public static void cargar_arreglo_aleatorio_secuencias_int(int[] arr) {
         Random r = new Random();
         arr[0] = 0;
         arr[MAX - 1] = 0;
         for (int pos = 1; pos < MAX - 1; pos++) {
             if (r.nextDouble() > probabilidad_numero) {
                 arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
             } else {
                 arr[pos] = 0;
             }
         }
     }
 
     public static void imprimir_matriz_secuencias_int(int[][] mat) {
         for (int fila = 0; fila < MAXFILA; fila++) {
             System.out.print("|");
             for (int columna = 0; columna < MAXCOLUMNA; columna++) {
                 System.out.print(mat[fila][columna] + "|");
             }
             System.out.println("");
         }
     }
 
 }
