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
    bool isValidBST(TreeNode *root, bool L, int vL, bool R, int vR) {
        if(!root) return true;
        if(root->left) {
            if(root->left->val >= root->val) return false;
            if(R && root->left->val <= vR) return false;
            if(!isValidBST(root->left, true, root->val, R, vR)) return false;
        }
        if(root->right) {
            if(root->right->val <= root->val) return false;
            if(L && root->right->val >= vL) return false;
            if(!isValidBST(root->right, L, vL, true, root->val)) return false;
        }
        return true;
    }
    bool isValidBST(TreeNode *root) {
        return isValidBST(root, false, 0, false, 0);
    }
};