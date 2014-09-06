/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <vector>
class Solution {
public:
    void add(vector<vector<int> > &r, TreeNode *tree, int p) {
        if(tree == NULL) return;
        int len = r.size();
        if(len == p) {
            vector<int> e;
            r.push_back(e);
        }
        r[p].push_back(tree->val);
        add(r, tree->left, p + 1);
        add(r, tree->right, p + 1);
    }
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int> > r;
        add(r, root, 0);
        return r;
    }
};