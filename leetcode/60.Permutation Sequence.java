public class Solution {
    public static void swap(int[] num, int p, int q) {
        int t = num[p];
        num[p] = num[q];
        num[q] = t;
    }
    public static void reverse(int[] num, int begin, int end) {
        for(int i = begin, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
    public static void nextPermutation(int[] num) {
        int len = num.length;
        if(len <= 1) return;
        int j = len - 2;
        for(; j >= 0; j--) {
            if(num[j] < num[j + 1]) break;
        }
        if(j == -1) {
            reverse(num, 0, len - 1);
            return;
        }
        int k = len - 1;
        for(; k >= 0; k--) {
            if(num[k] > num[j]) break;
        }
        swap(num, j, k);
        reverse(num, j + 1, len - 1);
    }
    public String getPermutation(int n, int k) {
        int[] s = new int[n];
        for(int i = 1; i <= n; i++) s[i - 1] = i;
        for(int i = 0; i < k - 1; i++) nextPermutation(s);
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < n; i++) sb.append((char)(s[i] + '0'));
        return sb.toString();
    }
}