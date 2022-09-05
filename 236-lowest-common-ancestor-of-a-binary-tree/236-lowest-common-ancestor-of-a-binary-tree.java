/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private TreeNode answer;
    
    public Solution() {
        this.answer = null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.answer;
    }
    
    private boolean recurseTree(TreeNode current, TreeNode p, TreeNode q) {
        if(current == null) {
            return false;
        }
        
        int left = this.recurseTree(current.left, p, q) ? 1 : 0;
        
        int right = this.recurseTree(current.right, p, q) ? 1 : 0;
        
        
        int mid = (current == p || current ==  q) ? 1 : 0;
        
        if(mid + left + right >= 2) {
            this.answer = current;
        }
        
        return (mid + left + right > 0);
    }
}