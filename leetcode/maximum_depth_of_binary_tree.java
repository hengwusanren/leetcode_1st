/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depL = maxDepth(root.left) + 1;
        int depR = maxDepth(root.right) + 1;
        return (depL > depR) ? depL : depR;
    }
}