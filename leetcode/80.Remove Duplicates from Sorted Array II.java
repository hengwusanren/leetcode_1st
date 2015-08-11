public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n <= 2) return n;
    	int curnum = A[0];
    	int curnumtime = 1;
    	int offset = 0;
    	for(int i = 1; i < n; i++) {
    		if(A[i] == curnum) {
    			curnumtime++;
    			if(curnumtime > 2) {
    				offset++;
    				continue;
    			}
    		} else {
    			curnum = A[i];
    			curnumtime = 1;
    		}
    		A[i - offset] = curnum;
    	}
    	n -= offset;
    	//A[n] = '\0';//strange...
    	return n;
    }
}