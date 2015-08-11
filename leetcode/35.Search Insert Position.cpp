class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        int low = 0;
        int high = n - 1;
        while(low < high) {
            if(target <= A[low]) return low;
            if(target == A[high]) return high;
            if(target > A[high]) return high + 1;
            // A[low] < target < A[high]:
            if(low + 1 == high) return low + 1;
            int mid = (low + high) / 2;
            if(A[mid] > target) {
                high = mid;
            } else if(A[mid] < target) {
                low = mid;
            } else {
                return mid;
            }
        }
        return (target <= A[low]) ? low : (low + 1);
    }
};