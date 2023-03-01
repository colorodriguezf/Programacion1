package Primera_parte.Ejercicio_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*4. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y lo agregue al principio del arreglo (posición
0). Para ello tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) y
colocar el numero en el arreglo en la posición indicada. */
public class ejercicio_4 {
    public static final int MAX = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 10;

    public static void main(String[] args) {
        int arrenteros [] = new int [MAX];
        int entero;
        int pos;
        
        BufferedReader entrada = new BufferedReader ( new InputStreamReader (System.in));
    try {
       cargar_arreglo_aleatorio(arrenteros);
       imprimir_arreglo(arrenteros);
	   System.out.println("Ingrese un numero entero: ");
       entero = Integer.valueOf(entrada.readLine());
       pos = obtener_pos_arreglo(arrenteros, entero);
       System.out.println("la posicion del numero insertado es: " + pos);
       corrimiento_derecha(arrenteros, pos);
       imprimir_arreglo(arrenteros);

        
    } catch (Exception e) {
        System.out.println(e);
    }
}

public static void corrimiento_derecha(int[] arrenteros, int pos) {
    int posfinal = MAX-1;
    while (posfinal > pos) {
        arrenteros[posfinal] = arrenteros[posfinal - 1];
        posfinal--;
    }
}

public static int obtener_pos_arreglo(int[] arrenteros, int entero) {
    int pos = 0;
    while (pos < MAX && arrenteros[pos] != entero) {
        pos ++;
    }
    return pos;
}

public static void cargar_arreglo_aleatorio(int[] arrenteros) {
    Random r = new Random();
    for (int i = 0; i < MAX; i++) {
        arrenteros[i] = r.nextInt((MAXVALOR - MINVALOR +1) + MINVALOR);
    }
}

public static void imprimir_arreglo(int [] arrenteros) {
    for (int i = 0; i < MAX; i++) {
        System.out.println("arrenteros["+i+"] --> "+arrenteros[i]);
    }
}
    
}
