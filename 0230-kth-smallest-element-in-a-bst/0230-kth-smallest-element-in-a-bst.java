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
//Apporch:- simple by inorder and reducing k
//T.C:- 
class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
