class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n <= 1) return n;
    	int curnum = A[0];
    	int offset = 0;
    	for(int i = 1; i < n; i++) {
    		if(A[i] == curnum) {
    			offset++;
    			continue;
    		}
    		curnum = A[i];
    		A[i - offset] = A[i];
    	}
    	n -= offset;
    	A[n] = '\0';
    	return n;
    }
};