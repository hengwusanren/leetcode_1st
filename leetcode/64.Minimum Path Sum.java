public class Solution {
    public static int minPathSum(int[][] grid, int x, int height, int y, int width, int[][] hist) {
        if(hist[x][y] != -1) return hist[x][y];
        if(x == height - 1 && y == width - 1) {
            hist[x][y] = grid[x][y];
            return grid[x][y];
        }
        if(x == height - 1) {
            hist[x][y] = grid[x][y] + minPathSum(grid, x, height, y + 1, width, hist);
        } else if(y == width - 1) {
            hist[x][y] = grid[x][y] + minPathSum(grid, x + 1, height, y, width, hist);
        } else {
            int ynext, xnext;
            ynext = minPathSum(grid, x, height, y + 1, width, hist);
            xnext = minPathSum(grid, x + 1, height, y, width, hist);
            hist[x][y] = grid[x][y] + (ynext > xnext ? xnext : ynext);
        }
        return hist[x][y];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int[][] hist = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                hist[i][j] = -1;
        return minPathSum(grid, 0, m, 0, n, hist);
    }
}