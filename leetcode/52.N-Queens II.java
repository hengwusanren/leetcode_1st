public class Solution {
    class Pos {
        int x;
        int y;
        public Pos() { x = 0; y = 0; }
        public Pos(int a, int b) { x = a; y = b; }
        public Pos(Pos p) { x = p.x; y = p.y; }
        @Override
        public String toString() {
            return Integer.toString(x) + " " + Integer.toString(y);
        }
        @Override
        public int hashCode() {
            String s = this.toString();
            return s.hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            if(null == obj) {
                return false;
            }
            if(!(obj instanceof Pos)) {
                return false;
            }
            Pos tmpObj = (Pos)obj;
            return tmpObj.x == x && tmpObj.y == y;
        }
    }
    public int totalNQueens(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int r = 0;
        ArrayList<ArrayList<Pos>> effects = new ArrayList<ArrayList<Pos>>(); // 每个Queen在加入path时所增加的（下面的）所有禁位
        boolean[][] flags = new boolean[n][n]; // 棋盘上的禁位分布，true为禁位，否则可取
        ArrayList<Integer> path = new ArrayList<Integer>(); // 当前已经安排了的各行Queen的位移
        int curRow = 0; // 当前是在安排第几个Queen的禁位
        int curCol = 0; // 当前要安排的Queen位置
        while(curRow < n) {
            while(curCol == n || flags[curRow][curCol]){
                if(curCol == n) {
                    // BACKTRACK: y
                    if(curRow == 0)
                        return r;
                    curRow--;
                    curCol = path.get(path.size() - 1);
                    // RECOVER FLAGS WITH THE VALUE OF LASTPOS IN EFFECTS: y
                    ArrayList<Pos> toRecover = effects.get(effects.size() - 1);
                    for(Pos e : toRecover) {
                        flags[e.x][e.y] = false;
                    }
                    effects.remove(effects.size() - 1);

                    path.remove(path.size() - 1);
                    curCol++;
                    continue;
                }
                curCol++;
            }
            // 找到一个可取位置，ADD TO PATH: y
            path.add(curCol);
            if(curRow == n - 1) {
                // ADD TO SOLUTIONS: y
                r++;
                path.remove(path.size() - 1);
                curCol++;
                continue;
            }
            // UPDATE EFFECTS & FLAGS:
            ArrayList<Pos> toUpdate = new ArrayList<Pos>();
            for(int line = curRow + 1, lineoffset = 1; line < n; line++, lineoffset++) {
                if(!flags[line][curCol]) {
                    toUpdate.add(new Pos(line, curCol));
                    flags[line][curCol] = true;
                }
                if(curCol - lineoffset >= 0 && !flags[line][curCol - lineoffset]) {
                    toUpdate.add(new Pos(line, curCol - lineoffset));
                    flags[line][curCol - lineoffset] = true;
                }
                if(curCol + lineoffset < n && !flags[line][curCol + lineoffset]) {
                    toUpdate.add(new Pos(line, curCol + lineoffset));
                    flags[line][curCol + lineoffset] = true;
                }
            }
            effects.add(toUpdate);

            curRow++;
            curCol = 0;
        }
        return r;
    }
}