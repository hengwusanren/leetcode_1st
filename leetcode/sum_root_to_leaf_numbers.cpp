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
    int sumNumbersIt(TreeNode *root, int s) {
        if(root == NULL) return s;
        if(root->left == NULL && root->right == NULL) return 10 * s + root->val;
        return ((root->left == NULL) ? 0 : sumNumbersIt(root->left, 10 * s + root->val)) + ((root->right == NULL) ? 0 : sumNumbersIt(root->right, 10 * s + root->val));
    }
    int sumNumbers(TreeNode *root) {
        return sumNumbersIt(root, 0);
    }
};