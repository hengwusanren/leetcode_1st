public class Solution {
    public static ArrayList<Integer> r;
    // roundTH round:
    public static void so(int[][] matrix, int n, int m, int round) {
        if(m <= 2*round || n <= 2*round) return;

        int i, j;
        for(i = round, j = round; j < n - round; j++) {
            r.add(matrix[i][j]);
        }
        i++; j--;
        if(i >= m - round) {
            so(matrix, n, m, ++round); return;
        }
        for(; i < m - round; i++) {
            r.add(matrix[i][j]);
        }
        i--; j--;
        if(j < round) {
            so(matrix, n, m, ++round); return;
        }
        for(; j >= round; j--) {
            r.add(matrix[i][j]);
        }
        i--; j++;
        if(i < round) {
            so(matrix, n, m, ++round); return;
        }
        for(; i > round; i--) {
            r.add(matrix[i][j]);
        }

        so(matrix, n, m, ++round);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        r = new ArrayList<Integer>();
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length : 0;
        so(matrix, n, m, 0);
        return r;
    }
}