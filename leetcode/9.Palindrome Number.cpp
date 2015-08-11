class Solution {
public:
    bool isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0) return false;
        int d = 1;
        int len = lenOfInt(x, d);
        if(len == 1) return true;
        return isP(x, d);
    }
    bool isP(int x, int d) {
        if(x == 0) return true;
        int head = x / d;
        int rear = x % 10;
        if(head == rear) {
            x %= d;
            x /= 10;
            d /= 100;
            return isP(x, d);
        }
        return false;
    }
    int lenOfInt(int x, int &d) {
        d = 1;
        int i = 1;
        while(1) {
            int k = x/d;
            if(k < 10 && k > 0) return i;
            d *= 10;
            i++;
        }
    }
};