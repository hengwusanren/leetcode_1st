public class Solution {
    public static void swap(int[] A, int p, int q) {
        int t = A[p];
        A[p] = A[q];
        A[q] = t;
    }
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        for(int i = 0; i < len; i++) {
            while(A[i] > 0 && A[i] <= len && A[A[i] - 1] != A[i])
                swap(A, i, A[i] - 1);
        }
        for(int i = 0; i < len; i++) {
            if(A[i] != i + 1)
                return i + 1;
        }
        return len + 1;
    }
}