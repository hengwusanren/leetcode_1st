public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) return n;
        if(n == 2) return 2;
        int[] ways2Index = new int[n];
        ways2Index[0] = 1;
        ways2Index[1] = 2;
        for(int i = 2; i < n; i++)
            ways2Index[i] = ways2Index[i - 1] + ways2Index[i - 2];
        return ways2Index[n - 1];
    }
}