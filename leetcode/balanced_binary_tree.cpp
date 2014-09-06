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
    int heightOfTree(TreeNode *root) {
        if(root == NULL) return 0;
        int leftH = heightOfTree(root->left);
        int rightH = heightOfTree(root->right);
        return leftH > rightH ? leftH + 1 : rightH + 1;
    }
    bool isBalanced(TreeNode *root) {
        if(root == NULL) return true;
        int leftH = heightOfTree(root->left);
        int rightH = heightOfTree(root->right);
        return (leftH - rightH <= 1 && leftH - rightH >= -1) && isBalanced(root->left) && isBalanced(root->right);
    }
};