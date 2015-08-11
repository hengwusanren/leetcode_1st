public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int u = 3;
        
        // 3 x 3:
        for(int i = 0; i < u*u; i += u) {
            for(int j = 0; j < u*u; j += u) {
                int[] s = new int[u*u];
                for(int k = 0; k < u*u; k++)
                    s[k] = 0;
                for(int x = 0; x < u; x++) {
                    for(int y = 0; y < u; y++) {
                        if(board[i+x][j+y] == '.') continue;
                        if(s[board[i+x][j+y] - '1'] != 0) return false;
                        s[board[i+x][j+y] - '1'] = 1;
                    }
                }
            }
        }
        
        // 1 x 9:
        for(int i = 0; i < u*u; i++) {
            int[] s = new int[u*u];
            for(int k = 0; k < u*u; k++)
                s[k] = 0;
            for(int j = 0; j < u*u; j++) {
                if(board[i][j] == '.') continue;
                if(s[board[i][j] - '1'] != 0) return false;
                s[board[i][j] - '1'] = 1;
            }
        }
        
        // 9 x 1:
        for(int i = 0; i < u*u; i++) {
            int[] s = new int[u*u];
            for(int k = 0; k < u*u; k++)
                s[k] = 0;
            for(int j = 0; j < u*u; j++) {
                if(board[j][i] == '.') continue;
                if(s[board[j][i] - '1'] != 0) return false;
                s[board[j][i] - '1'] = 1;
            }
        }
        
        return true;
    }
}