public class Solution {
    public static int longestValidParentheses(String s, int p, int len, int[] hist) {
        if(p >= len) return 0;
        if(hist[p] >= 0) return hist[p];
        if(s.charAt(p) == ')') {
            hist[p] = 0;
            return 0;
        }
        int next = p + 1;
        int sum = 0;
        int nextval = longestValidParentheses(s, next, len, hist);
        while(nextval > 0) {
            sum += nextval;
            next += nextval;
            nextval = longestValidParentheses(s, next, len, hist);
        }
        if(next < len && s.charAt(next) == ')') sum += 2;
        hist[p] = sum;
        return sum;
    }
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        int[] hist = new int[n];
        for(int i = 0; i < n; i++) hist[i] = -1;
        int max = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == ')') {
                hist[i] = 0;
                continue;
            }
            int next = i + 1;
            int sum = 0;
            boolean closed = false;
            while(next < n) {
                if(hist[next] > 0) {
                    sum += hist[next];
                    next += hist[next];
                } else if(!closed && s.charAt(next) == ')') {
                    sum += 2;
                    next++;
                    closed = true;
                } else {
                    break;
                }
            }
            if(!closed) sum = 0;
            hist[i] = sum;
            if(max < sum) max = sum;
        }
        return max;
    }
}