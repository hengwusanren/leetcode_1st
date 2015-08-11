class Solution {
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        int * C = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(k < m + n) {
            if(i == m || j == n) {
                C[k] = i == m ? B[j] : A[i];
                (i == m ? j : i)++;
            }
            else if(A[i] < B[j]) {
                C[k] = A[i];
                i++;
            }
            else {
                C[k] = B[j];
                j++;
            }
            k++;
        }
        int p = (m+n) / 2;
        int q = ((m+n)%2 == 1) ? p : p - 1;
        return ((double)C[p] + (double)C[q]) / 2;
    }
};