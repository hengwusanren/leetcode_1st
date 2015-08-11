class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        queue<int> a, b;
        int i;
        for(i = 0; i < m; i++) a.push(A[i]);
        for(i = 0; i < n; i++) b.push(B[i]);
        i = 0;
        while(!a.empty() || !b.empty()) {
            if(a.empty()) {
                A[i] = b.front();
                b.pop();
                i++;
                continue;
            }
            if(b.empty()) {
                A[i] = a.front();
                a.pop();
                i++;
                continue;
            }
            if(a.front() <= b.front()) {
                A[i] = a.front();
                a.pop();
                i++;
                continue;
            }
            A[i] = b.front();
            b.pop();
            i++;
            continue;
        }
    }
};