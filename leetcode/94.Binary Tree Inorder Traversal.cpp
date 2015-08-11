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
    vector<int> inorderTraversal(TreeNode *root) {
        vector<int> r;
        if(!root) return r;
        
        vector<int> leftr = inorderTraversal(root->left);
        r.insert(r.end(), leftr.begin(), leftr.end());
        r.push_back(root->val);
        vector<int> rightr = inorderTraversal(root->right);
        r.insert(r.end(), rightr.begin(), rightr.end());
        
        return r;
    }
};