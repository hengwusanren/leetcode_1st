public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len <= 2) return 0;
        Stack<Integer> peaks = new Stack<Integer>();
        int top = -1;
        if(A[0] > A[1]) {
            top = 0;
            peaks.push(top);
        }
        int i;
        for(i = 1; i < len - 1; i++) {
            if(A[i] >= A[i - 1] && A[i] > A[i + 1]) {
                if(peaks.empty() || A[i] >= A[peaks.peek()]) {
                    top = i;
                    peaks.push(top);
                }
            }
        }
        if(A[len - 1] >= A[len - 2] && !peaks.empty() && A[len - 1] >= A[peaks.peek()]) {
            top = len - 1;
            peaks.push(top);
        }
        if(top == -1) return 0;
        for(i = top + 1; i < len - 1; i++) {
            if(A[i] > A[i - 1] && A[i] >= A[i + 1]) {
                while(A[i] > A[peaks.peek()]) {
                    peaks.pop();
                }
                peaks.push(i);
            }
        }
        if(A[len - 1] > A[len - 2] && peaks.peek() != len - 1) {
            while(A[len - 1] > A[peaks.peek()]) {
                peaks.pop();
            }
            peaks.push(len - 1);
        }
        if(peaks.empty()) return 0;
        int curPeak = peaks.pop();
        int water = 0;
        while(!peaks.empty()) {
            int lower = A[curPeak] > A[peaks.peek()] ? A[peaks.peek()] : A[curPeak];
            for(int j = curPeak - 1; j > peaks.peek(); j--) {
                int gap = lower - A[j];
                if(gap > 0) water += gap;
            }
            curPeak = peaks.pop();
        }
        return water;
    }
}