public class Solution {
    public static int offset2len(int n) {
        return n < 0 ? (0 - n * 2) : (n * 2 + 1);
    }
    public static int offsetOfPalindromeAt(String s, int pos) {
        int len = s.length();
        if(len <= 1) return 0;
        int offset = 0;//以pos为对称中心
        int offset1 = 0;//以pos、pos+1为对称中心
        for(int i = 1; pos - i >= 0 && pos + i < len; i++) {
            if(s.charAt(pos - i) == s.charAt(pos + i)) offset++;
            else break;
        }
        for(int i = 1; pos - i + 1 >= 0 && pos + i < len; i++) {
            if(s.charAt(pos - i + 1) == s.charAt(pos + i)) offset1--;
            else break;
        }
        return (offset2len(offset) > offset2len(offset1)) ? offset : offset1;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        int curpos = 0;
        int curoffset = 0;
        for(int i = 0; i < len; i++) {
            int tmpoffset = offsetOfPalindromeAt(s, i);
            if(offset2len(tmpoffset) >= offset2len(curoffset)) {
                curoffset = tmpoffset;
                curpos = i;
            }
        }
        System.out.println("curpos: " + Integer.toString(curpos));
        System.out.println("curoffset: " + Integer.toString(curoffset));
        if(curoffset >= 0) {
            return s.substring(curpos - curoffset, curpos + curoffset + 1);
        }
        return s.substring(curpos + curoffset + 1, curpos - curoffset + 1);
    }
}