class Solution {
public:
    bool search(int A[], int n, int target) {
        bool r = false;
        for(int i = 0; i < n; i++) {
            if(A[i] == target) r = true;
        }
        return r;
    }
};