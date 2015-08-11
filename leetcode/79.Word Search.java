class pos {
    int x;
    int y;
    public pos() { x = 0; y = 0; }
    public pos(int a, int b) { x = a; y = b; }
    public pos(pos p) { x = p.x; y = p.y; }
}
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.equals("")) return true;
        int m = board.length;
        if(m == 0) return false;
        int n = board[0].length;
        if(n == 0) return false;
        int len = word.length();
        int[][] flags = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                flags[i][j] = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(len == 1) return true;
                    int id = i * n + j;
                    int offset = 0;
                    Stack<pos> s = new Stack<pos>();
                    pos p = new pos(i, j);
                    s.push(new pos(p));
                    flags[i][j] = id;
                    int dirFrom = -1; // -1 : ' ', 0 : 'u', 1 : 'd', 2 : 'l', 3 : 'r'
                    //boolean toBreak = false;
                    while(true) {
                        //if(offset == len - 1) return true;
                        if(dirFrom < 0 && p.x > 0 && flags[p.x - 1][p.y] != id && board[p.x - 1][p.y] == word.charAt(offset + 1)) {
                            offset++;
                            if(offset == len - 1) return true;
                            p.x = p.x - 1;
                            s.push(new pos(p));
                            flags[p.x][p.y] = id;
                            dirFrom = -1;
                            continue;
                        }
                        if(dirFrom < 1 && p.x < m - 1 && flags[p.x + 1][p.y] != id && board[p.x + 1][p.y] == word.charAt(offset + 1)) {
                            offset++;
                            if(offset == len - 1) return true;
                            p.x = p.x + 1;
                            s.push(new pos(p));
                            flags[p.x][p.y] = id;
                            dirFrom = -1;
                            continue;
                        }
                        if(dirFrom < 2 && p.y > 0 && flags[p.x][p.y - 1] != id && board[p.x][p.y - 1] == word.charAt(offset + 1)) {
                            offset++;
                            if(offset == len - 1) return true;
                            p.y = p.y - 1;
                            s.push(new pos(p));
                            flags[p.x][p.y] = id;
                            dirFrom = -1;
                            continue;
                        }
                        if(dirFrom < 3 && p.y < n - 1 && flags[p.x][p.y + 1] != id && board[p.x][p.y + 1] == word.charAt(offset + 1)) {
                            offset++;
                            if(offset == len - 1) return true;
                            p.y = p.y + 1;
                            s.push(new pos(p));
                            flags[p.x][p.y] = id;
                            dirFrom = -1;
                            continue;
                        }
                        s.pop();
                        if(s.empty()) {
                            //toBreak = true;
                            break;
                        }
                        offset--;
                        flags[p.x][p.y] = -1;
                        pos pp = s.peek();
                        if(p.x == pp.x + 1) dirFrom = 1;
                        else if(p.x == pp.x - 1) dirFrom = 0;
                        else if(p.y == pp.y + 1) dirFrom = 3;
                        else if(p.y == pp.y - 1) dirFrom = 2;
                        p.x = pp.x; p.y = pp.y;
                    }
                }
            }
        }
        return false;
    }
}