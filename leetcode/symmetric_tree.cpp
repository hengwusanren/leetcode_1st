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
    bool isSymmetricAboutRoot(TreeNode *left, TreeNode *right) {
        if(left == NULL) {
            if(right == NULL) return true;
            return false;
        }
        if(right == NULL) return false;
        return (left->val == right->val) && isSymmetricAboutRoot(left->left, right->right) && isSymmetricAboutRoot(left->right, right->left);
    }
    bool isSymmetric(TreeNode *root) {
        if(root == NULL) return true;
        return isSymmetricAboutRoot(root->left, root->right);
    }
};