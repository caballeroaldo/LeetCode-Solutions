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
    public List<List<Integer>> levelOrder(TreeNode root) {        
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<Integer>(levelSize);
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                level.add(current.val);
                if(current.left != null) {
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
            res.add(level);
        }
        return res;
        
    }
}