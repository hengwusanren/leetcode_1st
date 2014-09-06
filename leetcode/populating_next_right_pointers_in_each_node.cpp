/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(root == NULL) return;
        if(root->left != NULL) {
            root->left->next = root->right;
            connect(root->left);
        }
        if(root->right != NULL) {
            root->right->next = root->next == NULL ? NULL : root->next->left;
            connect(root->right);
        }
    }
};