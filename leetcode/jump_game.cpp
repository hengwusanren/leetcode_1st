class Solution {
public:
    bool canJump(int A[], int n) {
        int step = 0;
        while(step < n - 1) {
            if(A[step] == 0) break;
            step += A[step];
        }
        if(step >= n - 1) return true;
        return false;
    }
};