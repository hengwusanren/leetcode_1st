public class Solution {
    public int lengthOfLastWord(String s) {
        String snew = s.trim();
        int len = snew.length();
        int pos = snew.lastIndexOf(" ");
        if(pos == len - 1) return 0;
        return len - pos - 1;
    }
}