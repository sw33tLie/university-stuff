public class MatrixLoop {
    /* ESERCIZIO 1 (Massimo 7 punti -- da consegnare elettronicamente).
     * Scrivere un metodo iterativo di nome eUno con le seguenti caratteristiche:
     * --) eUno ha due parametri formali:
     *     Il primo parametro e' un riferimento (puntatore) ad una matrice di interi di nome a.
     *     Il secondo parametro e' un riferimento ad un array di interi di nome b;
     * --) eUno restituisce la somma di tutti gli elementi e di a per cui esista un elemento
     *     di b che sia multiplo di e.
     * La classe Gennaio0TestExUno puo' essere usata per il testing di eUno,
     * contenendo esempi sul funzionamento atteso per eUno.
     * SCRIVERE eUno immediatamente al di sotto di questo commento.
     */
 
    public static int e1(int[][] a, int[] b) {
        int somma = 0;
        boolean skip = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < b.length && !skip; k++) {
                    if (b[k] % a[i][j] == 0) {
                        somma += a[i][j];
                        skip = true;
                    }
                   
                }
                skip = false;
            }
        }
        return somma;
    }
 
    public static void main(String[] args) {
        int[][] m1 = {{ 3, 5 }, { 7, 13 }};
        int[] m2 = { 6, 2, 26, 26 };
        System.out.println(e1(m1, m2));
    }
}