class Solution {
public:
    int findBreak(int A[], int n, int p, int q) {
        int len = q - p + 1;
        if(len == 1 || A[p] < A[q]) return p;
        if(len == 2) return q;
        int m = (p + q) / 2;
        if(A[m] > A[p]) return findBreak(A, n, m, q);
        return findBreak(A, n, p, m);
    }
    int findBreak(int A[], int n) {
        return findBreak(A, n, 0, n - 1);
    }
    int searchInSortedArray(int A[], int n, int left, int right, int target) {
        if(left > right) return -1;
        if(left == right) return A[left] == target ? left : -1;
        if(left == right - 1) {
            if(A[left] == target) return left;
            if(A[right] == target) return right;
            return -1;
        }
        int mid = (left + right) / 2;
        if(A[mid] == target) return mid;
        if(A[mid] < target) return searchInSortedArray(A, n, mid, right, target);
        if(A[mid] > target) return searchInSortedArray(A, n, left, mid, target);
    }
    int search(int A[], int n, int target) {
        if(n == 0) return -1;
        if(n == 1) return A[0] == target ? 0 : -1;
        
        int breakpos = findBreak(A, n);
        breakpos = (breakpos == 0 ? n-1 : breakpos - 1);
        
        if(breakpos >= n - 1) {
            return searchInSortedArray(A, n, 0, n - 1, target);
        } else if(target > A[breakpos] || target < A[breakpos + 1]) {
            return -1;
        } else if(target >= A[0]) {
            return searchInSortedArray(A, n, 0, breakpos, target);
        } else {
            return searchInSortedArray(A, n, breakpos + 1, n - 1, target);
        }
    }
};