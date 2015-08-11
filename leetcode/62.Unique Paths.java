public class Solution {
    public int uniquePaths(int m, int n, int[][] hist) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        if(hist[m][n] != 0) return hist[m][n];
        hist[m][n] = uniquePaths(m - 1, n, hist) + uniquePaths(m, n - 1, hist);
        return hist[m][n];
    }
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        int[][] hist = new int[m + 1][n + 1];
        return uniquePaths(m, n, hist);
    }
}