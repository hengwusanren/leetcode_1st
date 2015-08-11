class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> r;
        if(n == 0) {
            r.push_back(0);
            return r;
        }
        if(n == 1) {
            r.push_back(0);
            r.push_back(1);
            return r;
        }
        
        vector<int> s = grayCode(n - 1);
        r.insert(r.begin(), s.begin(), s.end());
        int len = s.size();
        vector<int>::reverse_iterator it;
        for(it = s.rbegin(); it != s.rend(); it++) {
            r.push_back(*it + len);
        }
        
        vector<int>().swap(s);
        return r;
    }
};