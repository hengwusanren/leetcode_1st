public class Solution {
    public String convert(String s, int nRows) {
        if(nRows == 0) return "";
        if(nRows == 1) return s;
        int len = s.length();
        int mCols;
        char[][] board;
        
		mCols = len / (nRows - 1);
		int lastcol = len % (nRows - 1);
		if(!(lastcol == 0 || (mCols % 2 != 0 && lastcol == 1))) mCols++;
		
		board = new char[mCols][nRows];
		for(int i = 0; i < mCols; i++)
			for(int j = 0; j < nRows; j++)
				board[i][j] = 0;
		int p = 0;
		boolean time2return = false;
		for(int i = 0; i < mCols; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < nRows; j++) {
					board[i][j] = s.charAt(p);
					p++;
					if(p >= len) {
						time2return = true;
						break;
					}
				}
			} else {
				for(int j = nRows - 2; j >= 1; j--) {
					board[i][j] = s.charAt(p);
					p++;
					if(p >= len) {
						time2return = true;
						break;
					}
				}
			}
			if(time2return) break;
		}
        
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < nRows; i++) {
            for(int j = 0; j < mCols; j++) {
                if(board[j][i] != 0) sb.append(board[j][i]);
            }
        }
        
        return sb.toString();
    }
}