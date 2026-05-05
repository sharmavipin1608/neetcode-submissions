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
    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int right = 0;
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode current = queue.poll();

                if (current != null) {
                    right = current.val;
                    if (current.left != null) queue.offer(current.left);
                    if (current.right != null) queue.offer(current.right);
                }
            }

            result.add(right);
        }

        return result;
    }
}
