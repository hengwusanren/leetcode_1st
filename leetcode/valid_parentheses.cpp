#include <string>
#include <stack>
class Solution {
public:
    int map(char c) {
        switch(c) {
            case '(': return -1;
            case '[': return -2;
            case '{': return -3;
            case ')': return 1;
            case ']': return 2;
            case '}': return 3;
        }
        return 0;
    }
    bool isValid(string s) {
        const char *charr = s.c_str();
        int len = s.length();
        if(len == 0) return true;
        
        stack<int> st;
        st.push(map(charr[0]));
        for(int i = 1; i < len; i++) {
            int c = map(charr[i]);
            if(!st.empty() && c + st.top() == 0)
                st.pop();
            else st.push(c);
        }
        if(st.empty()) return true;
        return false;
    }
};