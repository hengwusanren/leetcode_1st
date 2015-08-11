class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        vector<int> v;
        int m = n;
        for(int i = 0; i < n; i++) {
            if(A[i] == elem) {
                m--;
                continue;
            }
            v.push_back(A[i]);
        }
        for(int i = 0; i < m; i++)
            A[i] = v.at(i);
        
        return m;
    }
};