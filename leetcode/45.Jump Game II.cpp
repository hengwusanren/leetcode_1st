using namespace std;
class Solution {
public:
    vector<int> hasjump;
    int jump(int A[], int n) {
        for(int i = 0; i < n; i++)
            hasjump.push_back(0);
        
        return jump(A, 0, n);
    }
    int jump(int A[], int begin, int n) {
        if(n - begin == 1) {
            hasjump.at(begin) = 0;
            return 0;
        }
        if(n - begin == 2) {
            hasjump.at(begin) = 1;
            return 1;
        }
        if(begin < n - 2 && begin + A[begin] >= n - 1) {
            hasjump.at(begin) = 1;
            return 1;
        }
        int m = A[begin];
        int result = n - begin;
        for(int i = 1 + begin; i <= m + begin; i++) {
            if(A[i] <= m - i + begin) continue;
            
            int t;
            if(hasjump.at(i) != 0)
                t = hasjump.at(i) + 1;
            else {
                t = jump(A, i, n) + 1;
                hasjump.at(i) = t - 1;
            }
            if(t < result)
                result = t;
        }
        hasjump.at(begin) = result;
        return result;
    }
};