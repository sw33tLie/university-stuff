public class RecursionOne {
    
    public static boolean e1(int[][] m) {
        boolean retValue = m != null;
        for (int i = 0; retValue && i < m.length && m.length > 0; i++) {
            boolean existsInCurrentRow = false;
            for (int j = 0; j < m[i].length && !existsInCurrentRow; j++) {
                if (m[i][j] % 3 == 0) {
                    existsInCurrentRow = true;
                }
            }
 
            if (!existsInCurrentRow) {
                retValue = false;
            }
        }
 
        return retValue;
    }
 
    public static int e2R(int[] a, int lowerThan, int k) {
        if (k < a.length) {
            return (a[k] < lowerThan && a[k] % 2 != 0 ? 1 : 0) + e2R(a, lowerThan, k + 1);
        }
        else {
            return 0;
        }
    }
 
    public static int e2(int[] a, int lowerThan) {
        return a != null && a.length > 0 ? e2R(a, lowerThan, 0) : 0;
    }
 
    public static void main(String[] args) {
        System.out.println("--- Ex 1 ---");
        int[][] m1 = { { 1, 3, 6 }, { 2, 9, 5 }, {2, 3, 5} };
        System.out.println(e1(m1)); // true
 
        int[][] m2 = { { 1, 3, 6 }, { 2, 9, 5 }, {2, 4, 5} };
        System.out.println(e1(m2)); // false
 
        int[][] m3 = null;
        System.out.println(e1(m3)); // false
 
        int[][] m4 = new int[0][];
        System.out.println(e1(m4)); // true
 
        System.out.println("--- Ex 2 ---");
 
        int[] a1 = { 1, 5, 7, 8 };
        System.out.println(e2(a1, 6)); // 2
 
    }
}