public class Solution {
    public static StringBuffer sb = new StringBuffer("");
    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer("");
        return lcp(strs, sb);
    }
    public String lcp(String[] strs, StringBuffer sb) {
        int len = strs.length;
        if(len == 0) return sb.toString();
        if(len == 1) return strs[0];
        if(strs[0].length() == 0) return sb.toString();
        
        String[] substrs = new String[len];
        substrs[0] = strs[0].substring(1);
        for(int i = 1; i < len; i++) {
            if(strs[i].length() == 0 || strs[i].charAt(0) != strs[i-1].charAt(0)) {
                return sb.toString();
            }
            substrs[i] = strs[i].substring(1);
        }
        sb.append(strs[0].charAt(0));
        return lcp(substrs, sb);
    }
}