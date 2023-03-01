package Final2020;

/*Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o mas ceros, hacer un programa que extraiga todas las
secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N(separadas por un 0)*/

import java.util.Random;


public class final2020 {
    public static final int MAX = 20;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final double PROB_NUMERO = 0.4;

    public static void main(String[] args) {
        int[] arr = new int[MAX];
        int[] par = new int[MAX];

        cargar_arr(arr);
        System.out.println("Arreglo ARR: \n");
        imprimir_arreglo(arr);
        cargar_par(par);
        System.out.println("\nArreglo PAR: \n");
        imprimir_arreglo(par);

        buscar_secuencias_par(arr, par);

    }

    public static void buscar_secuencias_par(int[] arr, int[] par) {
        int inicio = 0;
        int fin = -1;
    
    
        while(inicio < MAX-1) {
            inicio = buscar_pos_inicio(arr, fin+1);
            System.out.print("\ninicio: "+inicio);
            if(inicio < MAX-1) {
                fin = buscar_pos_fin(arr, inicio);
                System.out.print(" fin: "+fin);
                    if(es_secuencia_par(inicio, fin)) {
                        //FALTA IR AGREGANDO AL OTRO ARREGLO
                    }
                    buscar_pos_inicio(arr, fin+1);
            }
        }
    }

    public static int buscar_inSecuencia(int[] par, int fin) {
        while(fin > 0 && fin != 0) {
            fin--;
        }
        return fin;
    }

    public static int buscar_finSecuencia(int[] par, int fin) {
        while(fin > 0 && fin == 0) {
            fin--;
        }
        return fin;
    }

    public static boolean es_secuencia_par(int inicio, int fin) {
        return (fin - inicio) % 2 == 0;
    }

    public static int buscar_pos_fin(int[] arr, int pos) {
        while(pos < MAX && arr[pos] != 0) {
            pos++;
        }
        return pos;
    }

    public static int buscar_pos_inicio(int[] arr, int inicio) {
        while(inicio < MAX && arr[inicio] == 0) {
            inicio++;
        }
        return inicio;
    }

    public static void imprimir_arreglo(int[] arr) {
        for(int i = 0; i < MAX; i++) {
            System.out.print("|"+arr[i]+"|");
        } 
    }

    public static void cargar_par(int[] par) {
        for (int i = 0; i< MAX-1; i++) {
			par[i] = 0;
		}
    }

    public static void cargar_arr(int[] arr) {
        Random r = new Random();
        arr[0]=0;
        for(int i = 1; i < MAX; i++) {
            if(r.nextDouble() > PROB_NUMERO) {
                arr[i] = r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR;
            }
            else {
                arr[i] = 0;
            }
        }
    }
}
