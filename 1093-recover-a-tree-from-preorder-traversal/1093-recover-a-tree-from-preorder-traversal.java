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
    int n;
    public TreeNode recoverFromPreorder(String traversal) {
        n=traversal.length();
        int depth=0;
        int[] idx = {0};
        return solve(traversal,0,idx);
    }
    private TreeNode solve(String traversal,int depth,int[] idx){
        if(idx[0]>=n){
            return null;
        }
        int j = idx[0];
        while (j < n && traversal.charAt(j) == '-') {
            j++;
        }
        int dash=j-idx[0];
        if(dash!=depth){
            return null;
        }

        idx[0] += dash;
        
        int value = 0;
        while (idx[0] < n && Character.isDigit(traversal.charAt(idx[0]))) {
            value = value * 10 + (traversal.charAt(idx[0]) - '0');
            idx[0]++;
        }
        
        TreeNode root = new TreeNode(value);
        root.left = solve(traversal, depth + 1,idx);
        root.right = solve(traversal, depth + 1,idx);
        
        return root;
    }
}