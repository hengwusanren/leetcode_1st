class Solution {
public:
    void sortColors(int A[], int n) {
        int redend = -1, whiteend = -1, blueend = -1;
        for(int i = 0; i < n; i++) {
            if(A[i] == 0) {
                redend++;
                A[redend] = 0;
                whiteend++;
                if(whiteend > redend) A[whiteend] = 1;
                blueend++;
                if(blueend > whiteend) A[blueend] = 2;
            } else if(A[i] == 1) {
                whiteend++;
                A[whiteend] = 1;
                blueend++;
                if(blueend > whiteend) A[blueend] = 2;
            } else if(A[i] == 2) {
                blueend++;
                A[blueend] = 2;
            }
        }
    }
};