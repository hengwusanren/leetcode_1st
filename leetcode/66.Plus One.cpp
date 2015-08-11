class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        vector<int> r;
        int inc = 1;
        for(vector<int>::reverse_iterator it = digits.rbegin(); it != digits.rend(); it++) {
            if(*it + inc > 9)
                r.insert(r.begin(), 0);
            else {
                r.insert(r.begin(), *it + inc);
                inc = 0;
            }
        }
        if(inc) r.insert(r.begin(), inc);
        return r;
    }
};