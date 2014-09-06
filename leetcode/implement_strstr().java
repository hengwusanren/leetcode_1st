public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle.equals("")) return haystack;
        if(haystack.equals("")) return null;
        int p = haystack.indexOf(needle);
        if(p < 0 || p >= haystack.length()) return null;
        return haystack.substring(p);
    }
}