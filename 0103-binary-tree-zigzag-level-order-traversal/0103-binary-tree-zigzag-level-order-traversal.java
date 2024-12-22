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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> dq = new LinkedList<>();
        boolean leftToRight = true;
        dq.add(root);
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>(size);
            
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode node = dq.removeFirst();
                    level.add(node.val);
                    
                    if (node.left != null) {
                        dq.addLast(node.left);
                    }
                    if (node.right != null) {
                        dq.addLast(node.right);
                    }
                } else {
                    TreeNode node = dq.removeLast();
                    level.add(node.val);
                    
                    if (node.right != null) {
                        dq.addFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.addFirst(node.left);
                    }
                }
            }
            
            result.add(level);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}
