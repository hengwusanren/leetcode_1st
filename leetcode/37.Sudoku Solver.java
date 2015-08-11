public class Solution {
    public void solveSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9) return;
        ArrayList<Integer> keys = new ArrayList<Integer>();
        ArrayList<ArrayList<Character>> values = new ArrayList<ArrayList<Character>>();
        ArrayList<Integer> valueOffsets = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;
                int keyid = i * 9 + j;
                //System.out.println("now is (" + i + ", " + j + ")");
                map.put(keyid, keys.size());
                boolean[] possible = new boolean[9];
                for(int k = 0; k < 9; k++) {
                    if(board[i][k] == '.') {
                        if(k >= j) continue;
                        int thiskey = map.get(i * 9 + k);
                        possible[values.get(thiskey).get(valueOffsets.get(thiskey)) - '1'] = true;
                    }
                    else possible[board[i][k] - '1'] = true;
                }
                for(int k = 0; k < 9; k++) {
                    if(board[k][j] == '.') {
                        if(k >= i) continue;
                        int thiskey = map.get(k * 9 + j);
                        possible[values.get(thiskey).get(valueOffsets.get(thiskey)) - '1'] = true;
                    }
                    else possible[board[k][j] - '1'] = true;
                }
                int xbegin = (i / 3) * 3;
                int ybegin = (j / 3) * 3;
                for(int x = 0; x < 3; x++) {
                    for(int y = 0; y < 3; y++) {
                        if(board[xbegin + x][ybegin + y] == '.') {
                            if((xbegin + x) * 9 + (ybegin + y) >= (i * 9 + j)) continue;
                            int thiskey = map.get((xbegin + x) * 9 + (ybegin + y));
                            possible[values.get(thiskey).get(valueOffsets.get(thiskey)) - '1'] = true;
                        }
                        else possible[board[xbegin + x][ybegin + y] - '1'] = true;
                    }
                }
                ArrayList<Character> p = new ArrayList<Character>();
                for(int k = 0; k < 9; k++) {
                    if(!possible[k]) p.add((char)('1' + k));
                }

                if(p.size() == 0) { // backtrack
                    if(keys.size() == 0) return;
                    int curOffset = valueOffsets.get(valueOffsets.size() - 1) + 1;
                    while(curOffset >= values.get(values.size() - 1).size()) {
                        keys.remove(keys.size() - 1);
                        values.remove(values.size() - 1);
                        valueOffsets.remove(valueOffsets.size() - 1);
                        curOffset = valueOffsets.get(valueOffsets.size() - 1) + 1;
                    }
                    valueOffsets.remove(valueOffsets.size() - 1);
                    valueOffsets.add(curOffset);
                    int curKey = keys.get(keys.size() - 1);
                    i = curKey / 9;
                    j = curKey % 9;
                    continue;
                }
                keys.add(keyid);
                values.add(p);
                valueOffsets.add(0);
            }
        }
        for(int k = 0; k < keys.size(); k++) {
            int i = keys.get(k) / 9;
            int j = keys.get(k) % 9;
            board[i][j] = values.get(k).get(valueOffsets.get(k));
        }
    }
}