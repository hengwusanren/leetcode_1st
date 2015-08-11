class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > v;
        if(n < k || k < 1) return v;
        if(n == k) {
            vector<int> temp;
            for(int i = 1; i <= n; i++)
                temp.push_back(i);
            v.push_back(temp);
            return v;
        }
        if(k == 1) {
            for(int i = 1; i <= n; i++) {
                vector<int> temp;
                temp.push_back(i);
                v.push_back(temp);
            }
            return v;
        }
        v = combine(n - 1, k);
        vector<vector<int> > v1 = combine(n - 1, k - 1);
        vector<vector<int> >::iterator it;
        for(it = v1.begin(); it != v1.end(); it++) {
            (*it).push_back(n);
            v.push_back(*it);
        }
        
        return v;
    }
};