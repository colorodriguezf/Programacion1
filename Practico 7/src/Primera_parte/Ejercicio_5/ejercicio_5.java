package Primera_parte.Ejercicio_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/*5. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un
número igual) en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un
corrimiento a izquierda (queda una copia de la última posición del arreglo en la anteúltima
posición). */
public class ejercicio_5 {
    public static final int MIN = 1;
	public static final int MAX = 10;
	private static final int MINVALOR = 1;
	private static final int MAXVALOR = 10;

    public static void main(String[] args) {
        int arreglo [] = new int [MAX];
		int entero;
		int pos;
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        try {
            cargar_arreglo_aleatorio(arreglo);
            imprimir_arreglo(arreglo);
			System.out.println("Ingrese un numero entero");
			entero = Integer.valueOf(entrada.readLine());
			pos = obtener_pos_arreglo(arreglo, entero);
            corrimiento_izquierda(arreglo, pos);	
			
			imprimir_arreglo(arreglo);
            
        }catch (Exception e) {
            System.out.println(e);
		}	
    } 


    public static void corrimiento_izquierda(int[] arreglo, int pos) {
        int posinicial = 0;
        while ((posinicial < MAX-1)) {
			arreglo[posinicial] = arreglo[posinicial+1];
			posinicial++;
		}
        //EN ESTE METODO SE MODIFICO LA POS INICIAL, QUE VA A TOMAR COMO RESULTADO LA POS DEL USUARIO
		//Y EN EL WHILE UTILIZAMOS LA ULTIMA POSICION DEL ARREGLO, para poder encontrar el numero
		//ingresado por el usuario en la posicion
    }

    public static int obtener_pos_arreglo(int[] arrenteros, int entero) {
        int pos = 0;
        while (pos < MAX && arrenteros[pos] != entero) {
            pos ++;
        }
        return pos;
    }

    public static void cargar_arreglo_aleatorio(int[] arreglo) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            arreglo[i] = r.nextInt((MAXVALOR - MINVALOR +1) + MINVALOR);
        }
    }
    
    public static void imprimir_arreglo(int [] arreglo) {
        for (int i = 0; i < MAX; i++) {
            System.out.println("arrenteros["+i+"] --> "+arreglo[i]);
        }
    }
        
}
