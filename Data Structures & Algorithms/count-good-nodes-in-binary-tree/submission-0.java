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
    int result = 0;
    
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return result;    
    }

    private void dfs(TreeNode node, int maxSoFar) {
        if (null == node) return;

        if (maxSoFar <= node.val) result++;

        //System.out.println(String.format("Node : %s, maxSoFar : %s, result : %s", node.val, maxSoFar, result));

        dfs(node.left, Math.max(maxSoFar, node.val));
        dfs(node.right, Math.max(maxSoFar, node.val));
    }
}
