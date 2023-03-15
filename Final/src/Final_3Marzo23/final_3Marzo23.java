package Final_3Marzo23;

/*Se tiene una matriz precargada de caracteres con secuencias de caracteres minusculas en sus filas.
 * Se pide eliminar los ultimos dos caracteres consonates de cada secuencia.
 * Secuencias separadas por uno o mas espacios y empeizan y terminan con uno o mas espacios.
 */

 import java.util.Random;

public class final_3Marzo23 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final char MINVALOR = 'a';
    public static final char MAXVALOR = 'z';
    public static final double PROB_LETRA = 0.4;
    public static final int CANT_CONSONANTES = 2;

    public static void main(String[] args){
        char[][] mat = new char[MAXFILA][MAXCOLUMNA];

        cargar_matriz(mat);
        System.out.print("Matriz precargada aleatoria:\n");
        imprimir_matriz(mat);
        eliminar_dos_caracteres_consonantes(mat);
        System.out.print("\nMatriz con dos consonantes eliminadas por secuencia\n");
        imprimir_matriz(mat);
    }


    public static void eliminar_dos_caracteres_consonantes(char[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            eliminar_dos_caracteres_consonantes_x_fila(mat[f]);
        }
    }
    
    public static void eliminar_dos_caracteres_consonantes_x_fila(char[] arr) {
        int inicio =0;
        int fin = -1;

        while(inicio < MAXCOLUMNA-1 && fin < MAXCOLUMNA) {
            inicio = buscar_pos_inicio(arr,inicio);
            if(inicio != -1) {
                fin = buscar_pos_fin(arr,inicio);
                if(fin != -1) {
                    eliminar_caracteres(arr, inicio, fin);
                }
            }
            inicio = buscar_pos_inicio(arr, fin+1);
        }
    }

    public static void corrimiento_izquierda(char[] arr, int pos) {
        while(pos < MAXCOLUMNA-1) {
            arr[pos] = arr[pos+1];
            pos++;
        }      
    } 

    public static void eliminar_caracteres(char[] arr, int inicio, int fin) {
        int contador = 0;
        int pos1 = 0;
        int pos2 = 0;
        while(fin >= inicio && contador < CANT_CONSONANTES) {
            if(es_consonante(arr[fin])) {
                if(contador == 0) {
                    pos1 = fin;
                }
                else {
                    pos2 = fin;
                }
                //si hacia corrimiento a izq de pos, si el contador no llegaba a 2 me hacia el corrimiento igual, y pide que sean las ultimas
                //2 consonantes
                contador++;
                if(contador == CANT_CONSONANTES){
                    corrimiento_izquierda(arr, pos1);
                    corrimiento_izquierda(arr, pos2);
                }
            }
            fin--;
        }
    }

    public static boolean es_consonante(char caracter) {
        return (caracter != 'a' && caracter != 'e' && caracter != 'i' && caracter != 'o' && caracter != 'u');
    }


    public static int buscar_pos_fin(char[] arr, int pos) {
        while(pos < MAXCOLUMNA-1 && arr[pos] != ' ' ) {
            pos++;
        }
        return pos-1;
    }

    public static int buscar_pos_inicio(char[] arr, int pos) {
        while(pos < MAXCOLUMNA-1 && arr[pos] == ' ') {
            pos++;
        }
        if(pos != -1) {
            return pos;
        }
        else {
            return -1;
        }
    }

    public static void imprimir_matriz(char[][] mat) {
        for(int f = 0; f < MAXFILA; f++) {
            System.out.print("\n");
            for(int c = 0; c < MAXCOLUMNA; c++) {
                System.out.print("|"+mat[f][c]+"|");
            }
        }
    }

    public static void cargar_matriz(char [][] mat) {
        Random r = new Random();
        for(int f = 0; f < MAXFILA; f++) {
            for(int c= 1; c < MAXCOLUMNA-1; c++) {
                mat[f][0] = ' ';
                mat[f][MAXCOLUMNA-1] = ' ';
                if(r.nextDouble() > PROB_LETRA) {
                    mat[f][c] = (char)(r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
                }
                else {
                    mat[f][c]= ' ';
                }
            }
        }
    }
}
