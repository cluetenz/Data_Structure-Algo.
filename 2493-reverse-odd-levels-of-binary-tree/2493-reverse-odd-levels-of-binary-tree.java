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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<TreeNode> l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                l.add(node);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(level%2==1){
                int left=0;
                int right=l.size()-1;
                while(left<right){
                    int temp=l.get(left).val;
                    l.get(left).val=l.get(right).val;
                    l.get(right).val=temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
        
    }
}