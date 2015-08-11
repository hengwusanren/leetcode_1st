class Solution {
public:
    double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n == -1)
            return 1 / x;
        double p = pow(x, n/2);
        return p * p * pow(x, n - n/2 - n/2);
    }
};