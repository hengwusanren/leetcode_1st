public class Solution {
    public static boolean isSuffix(String s, String p, char prechar) {
        int slen = s.length();
        if(slen == 0) return isMatch("", p);
        for(int i = 0; i <= slen; i++) {
            if(isMatch(s.substring(i), p)) return true;
            if(prechar != '.' && (i == slen || s.charAt(i) != prechar)) break;
        }
        return false;
    }
    public static boolean isRepeatChar(String s, char c) {
        int slen = s.length();
        if(slen == 0) return true;
        for(int i = 0; i < slen; i++)
            if(s.charAt(i) != c) return false;
        return true;
    }
    // "abc", "c*", ".", ".*", -- 4 types of nodes
    public static boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if(plen == 0) return slen == 0;
        if(plen == 1) {
            if(p.equals(".")) return slen == 1;
            if(p.equals("*")) return false;
            return p.equals(s);
        }
        if(p.equals(".*")) return true;
        
        if(p.charAt(0) == '.') {
            if(p.charAt(1) == '*') {
                if(plen == 2) return true;
                return isSuffix(s, p.substring(2), '.');
            }
            if(slen == 0) return false;
            return isMatch(s.substring(1), p.substring(1));
        }
        if(p.charAt(0) == '*') return false;
        if(p.charAt(1) == '*') {
            return isSuffix(s, p.substring(2), p.charAt(0));
        }
        if(slen == 0 || s.charAt(0) != p.charAt(0)) return false;
        return isMatch(s.substring(1), p.substring(1));
    }
    // 一次就Accepted，开心！
}