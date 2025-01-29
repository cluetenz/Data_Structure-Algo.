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
import java.util.HashMap;

class Solution {
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        
        return solve(preorder, inorder, 0, inorder.length - 1, hm);
    }

    public TreeNode solve(int[] preorder, int[] inorder, int i, int j, HashMap<Integer, Integer> hm) {
        if (i > j) {
            return null;
        }
        
        int currentVal = preorder[idx]; 
        idx++;
        
        TreeNode node = new TreeNode(currentVal);
        
        if (i == j) {
            return node;
        }
        
        int inorderIndex = hm.get(currentVal);
        
        node.left = solve(preorder, inorder, i, inorderIndex - 1, hm);
        node.right = solve(preorder, inorder, inorderIndex + 1, j, hm);
        
        return node;
    }
}
