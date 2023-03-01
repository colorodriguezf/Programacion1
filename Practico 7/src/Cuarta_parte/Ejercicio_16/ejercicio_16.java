package Cuarta_parte.Ejercicio_16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*16. Hacer un programa que dado el arreglo definido y precargado elimine todas
las secuencias que tienen orden descendente entre sus elementos.
 */

public class ejercicio_16 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 10;
    public static final int MINVALOR=0;
       public static final double probabilidad_numero = 0.4;

       
       
       public static void main(String[] args) {
           int[]arreglo = {0,0,2,1,0,4,6,0,0,5,9,0,8,2,1,0,3,1,0,0};
           
           System.out.print("Arreglo de secuencias int\n|");
           imprimir_arreglo_secuencias_int(arreglo);
           buscar_secuencia(arreglo);
           System.out.println("secuencias descendentes eliminadas");
           imprimir_arreglo_secuencias_int(arreglo);
       }

       public static void buscar_secuencia(int[] arr) {
           int fin = -1;
           int inicio = 0;
           boolean descendente = true;
           while (inicio < MAX-1) {
               inicio = obtener_inicio_secuencia(arr, fin+1);
               if (inicio < MAX-1) {
                   fin = obtener_fin_secuencia(arr, inicio);
                   
                   descendente = secuencia_descendente(arr, inicio, fin);
                   System.out.println("el inicio de sec es:  " + inicio);
                   System.out.println("el fin de la sec es:  " + fin);
                   System.out.println("La secuencia es descendente?  " + descendente);
                   if (descendente) {
                       corrimiento_izquierda(arr, inicio, fin);
                       
                   }
               }
           }
       }
       public static void corrimiento_izquierda(int[]arr, int inicio, int fin) {
           int indice = inicio;
           while (indice < fin+1) {
               arr[indice] = arr[indice-1];
               indice++;
            }
        }
       public static boolean secuencia_descendente(int[]arr, int inicio, int fin) {
           int pos = inicio;
           while ((pos < fin)  && (arr[pos] >= arr[pos+1]) ) {
               pos++;
           }
           if (pos == fin) {
               return true;
            } else {
               return false;
           }
           
       }
       
       public static int obtener_inicio_secuencia(int[] arr, int inicio) {
           int indice = inicio;
           while ((arr[indice] == 0) && (indice < MAX - 1)) {
               indice++;
           }
           return indice;
       }

       public static int obtener_fin_secuencia(int[] arr, int inicio) {
           int pos = inicio;
           while ((pos < MAX-1) && (arr[pos] != 0)) {
               pos++;
            }
            return pos-1;
        }

        public static void imprimir_arreglo_secuencias_int(int[] arr) {
            
            for (int pos = 0; pos < MAX; pos++) {
                System.out.print(arr[pos] + "|");
            }
            System.out.print("\n");
        }
        
    }
