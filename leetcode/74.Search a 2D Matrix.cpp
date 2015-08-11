class Solution {
public:
    int binSearch(vector<int> v, int left, int right, int target) {
        if(v.at(left) > target || v.at(right) < target || left > right) return -1;
        if(v.at(right) == target) return right;
        if(v.at(left) == target || left >= right - 1) return left;
        int m = (left + right) / 2;
        if(v.at(m) > target) {
            return binSearch(v, left, m, target);
        }
        else if(v.at(m) < target) {
            return binSearch(v, m, right, target);
        }
        else return m;
    }
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        vector<int> rowHeads;
        for(vector<vector<int> >::iterator it = matrix.begin(); it != matrix.end(); it++) {
            rowHeads.push_back((*it).front());
        }
        int r = matrix.back().front() < target ? matrix.size() - 1 : binSearch(rowHeads, 0, matrix.size() - 1, target);
        if(r == -1) return false;
        int c = binSearch(matrix.at(r), 0, matrix.front().size() - 1, target);
        if(c == -1) return false;
        return matrix.at(r).at(c) == target;
    }
};