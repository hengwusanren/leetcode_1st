public class Solution {
    public int maxSubArray(int[] A) {
    	int len = A.length;
    	if(len == 0) return 0;
    	if(len == 1) return A[0];

    	int curBegin = 0;
    	int curEnd = 0;
    	int curSum = A[0];
    	int curFront = 0;
    	int curFSum = A[0];
    	int curBSum = A[0] < 0 ? A[0] : 0;
    	int largestEle = A[0];

    	for(curFront = 1; curFront < len; curFront++) {
    	    if(A[curFront] > largestEle) largestEle = A[curFront];
    		if(curFSum < curBSum) {
    			curBegin = curFront;
    			curBSum = curFSum;
    		}
    		curFSum += A[curFront];
    		if(curFSum - curBSum > curSum) {
    			curEnd = curFront;
    			curSum = curFSum - curBSum;
    		}
    	}

        //curSum -= curBSum;
        return (curSum > 0) ? curSum : largestEle;
    }
}