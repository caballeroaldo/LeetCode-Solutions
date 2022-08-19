/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        max = Math.max(max, 2 + left + right);
        
        return 1 + Math.max(left, right);
    }
}