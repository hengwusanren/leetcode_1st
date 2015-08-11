class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        string s;
        map<string, int> anagram;
        vector<string> res;
        for(int i = 0; i < strs.size(); i++) {
            //将第i个string的字符顺序重排
            s = strs[i];
            sort(s.begin(), s.end());
            //这个string还没被收录，那么收录，记下出现的索引
            if (anagram.find(s) == anagram.end()) {
                anagram[s] = i;
            } else {//这个string已经被收录
                if (anagram[s] >= 0) {//如果是头一次检查，则把原string也加进res中
                    res.push_back(strs[anagram[s]]);
                    anagram[s] = -1;
                }
                res.push_back(strs[i]);//自己也加进res中
            }
        }
        return res;
    }
};