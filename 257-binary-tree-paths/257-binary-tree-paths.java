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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        path(result, root, "");
        return result;
    }
    
    private void path(List<String> res, TreeNode node, String currentPath) {
        if(node == null) {
             return;
        }
        currentPath = currentPath+Integer.toString(node.val);
        
        path(res,node.left,currentPath+"->");
        path(res,node.right,currentPath+"->");
        
        if(node.right == null && node.left == null) {
            res.add(currentPath);
        }
        
    }
}