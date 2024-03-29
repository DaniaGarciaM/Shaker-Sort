
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class shakerSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[] leerArreglo(int n) throws IOException {
        int[] a = new int[n];
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            a[i] = Integer.parseInt(entrada);
        }
        return a;
    }


    public static int[] shakerSort(int[] listaD) {
        boolean ordenado = true;
        int inicia = 0;
        int termina = listaD.length - 1;
        int mantener;
        while (ordenado) {
            ordenado = false;
            for (int i = inicia; i < termina; i++) {
                if (listaD[i] > listaD[i + 1]) {
                    mantener = listaD[i];
                    listaD[i] = listaD[i + 1];
                    listaD[i + 1] = mantener;
                    ordenado = true;
                }
            }
            if (!ordenado) {
                break;
            }
            ordenado = false;
            termina = termina - 1;
            for(int i = termina-1; i>=inicia; i--){
                if (listaD[i] > listaD[i + 1]) {
                    mantener = listaD[i];
                    listaD[i] = listaD[i + 1];
                    listaD[i + 1] = mantener;
                    ordenado = true;
                }
            }
            inicia = inicia + 1;
        }
        return listaD;
    }

    public static void imprimirArreglo(int[] a) {
        System.out.println("-------------------------");
        System.out.println("Lista ordenada");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        int[] array;
        int t;
        System.out.println("Programa que ordena la lista de números");
        System.out.println("Escribe la longitud de la lista a ingresar: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);

        array = leerArreglo(t);
        array = shakerSort(array);
        imprimirArreglo(array);
    }

}
