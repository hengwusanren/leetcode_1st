class Solution {
public:
    int numTrees(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int r = 0;
        for(int i = 1; i <= n; i++) {
            r += numTrees(i - 1) * numTrees(n - i);
        }
        return r;
    }
};