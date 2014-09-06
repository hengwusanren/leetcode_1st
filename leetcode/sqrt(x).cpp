class Solution {
public:
    int shift(int x, int d, bool left) {
        if(d < 0) return 0;
        if(d == 0) return x;
        if(left) {
            while(d > 0) {
                x *= 10;
                d--;
            }
        }
        else {
            while(d > 0) {
                x /= 10;
                d--;
            }
        }
        return x;
    }
    int sqrtOdd(int x) {
        if(x <= 5) return x + 2;
        switch(x) {
            case 6: return 7;
            case 7: return 8;
            case 8: return 8;
            case 9: return 9;
        }
        return 0;
    }
    int sqrtOddUpper(int x) {
        switch(x) {
            case 1: return 5;
            case 2: return 6;
            case 3: return 7;
            case 4: return 8;
            case 5: return 8;
            case 6: return 9;
            case 7: return 9;
            case 8: return 10;
            case 9: return 10;
        }
        return 0;
    }
    int sqrtEvn(int x) {
        if(x <= 3) return 1;
        if(x <= 8) return 2;
        return 3;
    }
    int sqrtBinSearch(int target, int low, int high) {
        if(low == high || low == high - 1 || low * low == target) return low;
        if((low+1) * (low+1) > target) return low;
        if(high * high <= target) return high;
        int m = (low + high) / 2;
        if(m * m > target) high = m;
        else if(m * m == target) return m;
        else low = m;
        return sqrtBinSearch(target, low, high);
    }
    int sqrt(int x) {
        if(x < 1) return 0;
        int k = x, d = 0;
        while(k > 0) {
            k /= 10;
            d++;
        }
        // x is in [10^(d-1), 10^d);
        // if d % 2 == 0, sqrt(x) is in (sqrtOdd(x / 10^(d-1))*10^((d-1)/2), (sqrtOdd(x / 10^(d-1)) + 1)*10^((d-1)/2));
        // if d % 2 == 1, sqrt(x) is in (sqrtEvn(x / 10^(d-1))*10^((d-1)/2), (sqrtEvn(x / 10^(d-1)) + 1)*10^((d-1)/2));
        k = shift(x, d - 1, false);
        int low  = (d % 2 == 0) ? shift(sqrtOdd(k), (d-1)/2, true)      : shift(sqrtEvn(k), (d-1)/2, true);
        int high = (d % 2 == 0) ? shift(sqrtOddUpper(k), (d-1)/2, true) : shift(sqrtEvn(k) + 1, (d-1)/2, true);
        return sqrtBinSearch(x, low, high > 46340 ? 46340 : high);
    }
};