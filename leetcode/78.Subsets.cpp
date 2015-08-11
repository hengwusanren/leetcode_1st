class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        int n = S.size();
        sort(S.begin(), S.end());
        return subsetsBefore(S, n);
    }
    vector<vector<int> > subsetsBefore(vector<int> &S, int p) {
        vector<vector<int> > v;
        if(p == 0) {
            vector<int> temp;
            v.push_back(temp);
            return v;
        }
        v = subsetsBefore(S, p - 1);
        vector<vector<int> > v1 = v;
        vector<vector<int> >::iterator it = v1.begin();
        int i = 0, n = v1.size();
        for(; it != v1.end() && i < n; it++, i++) {
            vector<int> temp = *it;
            temp.push_back(S.at(p - 1));
            v.push_back(temp);
        }
        
        return v;
    }
};