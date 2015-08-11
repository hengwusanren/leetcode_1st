/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<TreeNode *> generateTrees(int from, int to) {
        vector<TreeNode *> r;
        if(from > to) return r;
        if(from == to) {
            r.push_back(new TreeNode(from));
            return r;
        }
        for(int i = from; i <= to; i++) {
            TreeNode * t;
            vector<TreeNode *> le = generateTrees(from, i - 1);
            vector<TreeNode *> ri = generateTrees(i + 1, to);
            if(le.empty()) {
                if(ri.empty()) {
                    t = new TreeNode(i);
                    t->left = NULL;
                    t->right = NULL;
                    r.push_back(t);
                    continue;
                }
                for(int j = 0; j < ri.size(); j++) {
                    t = new TreeNode(i);
                    t->left = NULL;
                    t->right = ri[j];
                    r.push_back(t);
                }
                continue;
            }
            if(ri.empty()) {
                for(int j = 0; j < le.size(); j++) {
                    t = new TreeNode(i);
                    t->right = NULL;
                    t->left = le[j];
                    r.push_back(t);
                }
                continue;
            }
            for(int k = 0; k < le.size(); k++) {
                for(int j = 0; j < ri.size(); j++) {
                    t = new TreeNode(i);
                    t->left = le[k];
                    t->right = ri[j];
                    r.push_back(t);
                }
            }
        }
        return r;
    }
    vector<TreeNode *> generateTrees(int n) {
        vector<TreeNode *> r;
        if(n < 1) {
            r.push_back(NULL);
            return r;
        }
        
        r = generateTrees(1, n);
        
        return r;
    }
};