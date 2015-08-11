class Solution {
public:
    int atoi(const char *str) {
        char *p = (char *)str;
        int r = 0;
        bool sig = true;
        while(*p != NULL) {
            if(*p != ' ') break;
            p++;
        }
        if(*p == NULL) return 0;
        if(*p == '-' || *p == '+') {
            if(*p == '-') sig = false;
            p++;
        }
        while(*p != NULL) {
            int c = *p - '0';
            if(c < 0 || c > 9)
                break;
            if(sig && (r > 214748364 || (r == 214748364 && c > 7)))
                return 2147483647;
            if(!sig && (r > 214748364 || (r == 214748364 && c > 8)))
                return -2147483648;
            r = 10 * r + c;
            p++;
        }
        return sig ? r : -r;
    }
};