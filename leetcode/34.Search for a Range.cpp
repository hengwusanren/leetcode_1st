class Solution {
public:
    int searchRangeLeft(int A[], int n, int target, int left, int right) {
        if(A[left] > target || A[right] < target || (right == left && A[left] != target)) return -1;
        if(right == left + 1 && A[left] < target && A[right] == target) return right;
        if(A[left] == target && (left == 0 || A[left - 1] < target)) return left;
        int m = (left + right) / 2;
        if(A[m] < target)
            return searchRangeLeft(A, n, target, m == left ? left + 1 : m, right);
        if(A[m] >= target)
            return searchRangeLeft(A, n, target, left, m == right ? right - 1 : m);
    }
    int searchRangeRight(int A[], int n, int target, int left, int right) {
        if(A[left] > target || A[right] < target || (right == left && A[left] != target)) return -1;
        if(right == left + 1 && A[left] == target && A[right] > target) return left;
        if(A[right] == target && (right == n - 1 || A[right + 1] > target)) return right;
        int m = (left + right) / 2;
        if(A[m] <= target)
            return searchRangeRight(A, n, target, m == left ? left + 1 : m, right);
        if(A[m] > target)
            return searchRangeRight(A, n, target, left, m == right ? right - 1 : m);
    }
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> r;
        int left = searchRangeLeft(A, n, target, 0, n-1);
        int right = searchRangeRight(A, n, target, 0, n-1);
        
        r.push_back(left);
        r.push_back(right);
        return r;
    }
};