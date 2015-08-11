class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        int n = matrix.size();
        if(n == 1) return;
        for(int i = 0; i <= n - 1; i++) {
            for(int j = i; j < n - 1 - i; j++) {
                int t0 = matrix.at(i).at(j);
                int t1 = matrix.at(j).at(n - 1 - i);
                int t2 = matrix.at(n - 1 - i).at(n - 1 - j);
                matrix.at(i).at(j) = matrix.at(n - 1 - j).at(i);
                matrix.at(j).at(n - 1 - i)          = t0;
                matrix.at(n - 1 - i).at(n - 1 - j)  = t1;
                matrix.at(n - 1 - j).at(i)          = t2;
            }
        }
    }
};