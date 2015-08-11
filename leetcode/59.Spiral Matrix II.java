public class Solution {
    public static int count = 0;
    public static int max = 0;
    // roundTH round:
    public static void so(int[][] matrix, int n, int m, int round) {
        if(m <= 2*round || n <= 2*round) return;

        int i, j;
        for(i = round, j = round; j < n - round; j++) {
            count++;
            if(count > max) return;
            matrix[i][j] = count;
        }
        i++; j--;
        if(i >= m - round) {
            so(matrix, n, m, ++round); return;
        }
        for(; i < m - round; i++) {
            count++;
            if(count > max) return;
            matrix[i][j] = count;
        }
        i--; j--;
        if(j < round) {
            so(matrix, n, m, ++round); return;
        }
        for(; j >= round; j--) {
            count++;
            if(count > max) return;
            matrix[i][j] = count;
        }
        i--; j++;
        if(i < round) {
            so(matrix, n, m, ++round); return;
        }
        for(; i > round; i--) {
            count++;
            if(count > max) return;
            matrix[i][j] = count;
        }

        so(matrix, n, m, ++round);
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        count = 0;
        max = n*n;
        so(matrix, n, n, 0);
        return matrix;
    }
}