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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        solve(root,heap);
        int ans=0;
        for(int i=0;i<k;i++){
            ans=heap.poll();
        }
        return ans;
    }
    private void solve(TreeNode root,PriorityQueue<Integer> heap){
        if(root==null){
            return;
        }
        solve(root.left,heap);
        heap.offer(root.val);
        solve(root.right,heap);
    }
}