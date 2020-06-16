public class RecursionThree {
 
    public static int matrixSum(int[][] m, int k) {
        int retValue = 0;
        if (k >= 0) {
            retValue = m[k].length + matrixSum(m, k - 1);
        }
        return retValue;
    }
 
    public static boolean matrixSumWrapper(int[][] m) {
        return m != null && m.length > 0 && matrixSum(m, m.length - 1) <= 10;
    }
 
    public static void main(String[] args) {
        int[][] m1 = { { 1, 2, 3 }, { 3, 4, 6 }, {5, 7, 8, 9, 91, 4, 6, 2, 7, 8, 9, 2, 3}}; // false
        System.out.println(matrixSumWrapper(m1));
 
        int[][] m2 = { { 1, 2, 3 }, { 3, 4, 6, 7, 8, 9, 10 } }; // true
        System.out.println(matrixSumWrapper(m2));
    }
}