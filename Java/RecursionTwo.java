import java.util.Arrays;

public class RecursionTwo {

    public static int[][] magic(int[][] m) {
        // La matrice b avrà, per ogni riga, lo stesso numero di elementi per riga della corrispondente riga della matrice m.
        int[][] b = new int[m.length][];
        for (int n = 0; n < m.length; n++) {
            b[n] = new int[m[n].length];
        }
 
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int greatest = 0;
                for (int k = 0; k <= i; k++) {
                    // La condizione qui sotto l < m[k].length evita l'out of bounds in caso di jagged arrays
                    for (int l = 0; l <= j && l < m[k].length; l++) {
                        if (m[k][l] > greatest) {
                            greatest = m[k][l];
                        }
                    }
                }
                b[i][j] = greatest;
            }
        }

        return b;
    }
 
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 },
                      { 4, 3, 6, 9, 8, 9, 10 },
                      { 5, 6, 7, 8 } };
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(magic(a)));
    }
}