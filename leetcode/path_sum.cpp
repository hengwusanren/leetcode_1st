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
    int typeOfNode(TreeNode *node) {
        if(node->right == NULL) {
            if(node->left == NULL)
                return 0;
            return 1;
        }
        if(node->left == NULL)
            return 2;
        return 3;
    }
    bool hasPathSum(TreeNode *root, int sum) {
        if(root == NULL) return false;
        switch(typeOfNode(root)) {
            case 0:
                return root->val == sum ? true : false;
            case 1:
                return hasPathSum(root->left, sum - root->val);
            case 2:
                return hasPathSum(root->right, sum - root->val);
            case 3:
                return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);;
        }
    }
};