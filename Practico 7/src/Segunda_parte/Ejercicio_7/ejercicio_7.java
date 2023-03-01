package Segunda_parte.Ejercicio_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*7. Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada. */

public class ejercicio_7 {
        public static final int MAX = 10;
        public static final int MINVALOR = 1;
        public static final int MAXVALOR = 10;

        public static void main (String[]args) {
            int[] arreglo = new int[MAX];
            int numero;
            int pos;

            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            try{
                cargar_arreglo(arreglo);
                System.out.println("\nArreglo cargado aleatoriamente:\n");
                imprimir_arreglo(arreglo);
                System.out.println("\nArreglo ordenado de mayor a menor:\n");
                ordenar_arreglo_burbujeo(arreglo);
                imprimir_arreglo(arreglo);
                System.out.println("Ingrese un numero: ");
                numero = Integer.valueOf(entrada.readLine());
                pos = obtener_posicion_arreglo(arreglo, numero);
                System.out.println("El numero se encuentra en la posicion: "+pos);
                corrimiento_derecha(arreglo, pos);
                arreglo[pos] = numero;
                imprimir_arreglo(arreglo);



            }catch(Exception e){
                System.out.println(e);
            }
        }

        public static void corrimiento_derecha(int[] arreglo, int pos){
            int posfinal = MAX-1;
            while(posfinal > pos) {
                arreglo[posfinal] = arreglo[posfinal -1];
                posfinal--;
            }
        }

        public static int obtener_posicion_arreglo(int[] arreglo, int numero) {
            int pos = 0;
            while(pos < MAX && arreglo[pos] < numero) {
                pos++;
            }
            return pos;
        }

        public static void ordenar_arreglo_burbujeo(int[] arreglo){
            int temp;
            for(int i = 0; i < MAX; i++) {
                for(int j = 0; j < MAX-1; j++) {
                    if(arreglo[j] > arreglo[j+1]) {
                        temp = arreglo[j];
                        arreglo[j] = arreglo[j+1];
                        arreglo[j+1] = temp;
                    }
                }

            }
        }

        public static void cargar_arreglo(int[] arreglo) {
            Random r = new Random();
            for(int i = 0; i < MAX; i++) {
                arreglo[i] = r.nextInt((MAXVALOR - MINVALOR + 1)-MINVALOR);
            }
        }

        public static void imprimir_arreglo(int[] arreglo) {
            for(int i = 0; i < MAX; i++) {
                System.out.println("arreglo["+i+"] --> "+ arreglo[i]);
            }
        }
}
