public class Solution {
    public int reverse(int x) {
        int sig = x < 0 ? -1 : 1;
        x = x < 0 ? -x : x;
        StringBuffer s = new StringBuffer(Integer.toString(x));
        s.reverse();
        x = Integer.parseInt(s.toString());
        return sig * x;
    }
}