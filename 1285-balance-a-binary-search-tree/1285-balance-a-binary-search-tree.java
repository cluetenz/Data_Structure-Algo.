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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inorder(root,list);
        return solve(0,list.size()-1,list);
    }
    private void inorder(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode solve(int start,int end,List<Integer>list){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        TreeNode head=new TreeNode(list.get(mid));
        head.left=solve(start,mid-1,list);
        head.right=solve(mid+1,end,list);
        return head;
    }
}