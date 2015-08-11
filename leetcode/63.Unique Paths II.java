public class Solution {
    public int uniquePathsWithObstacles(int m, int x, int n, int y, int[][] hist) {
        if(x >= m || y >= n) return 0;
        if(hist[x][y] >= 0) return hist[x][y];
        hist[x][y] = uniquePathsWithObstacles(m, x + 1, n, y, hist) + uniquePathsWithObstacles(m, x, n, y + 1, hist);
        return hist[x][y];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        if(n == 0) return 0;
        int[][] hist = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                hist[i][j] = obstacleGrid[i][j] - 1;
        hist[m - 1][n - 1] = 1 - obstacleGrid[m - 1][n - 1];
        return uniquePathsWithObstacles(m, 0, n, 0, hist);
    }
}