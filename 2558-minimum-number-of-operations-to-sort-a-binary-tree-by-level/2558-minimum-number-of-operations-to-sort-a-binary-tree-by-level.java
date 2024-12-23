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
    public int minimumOperations(TreeNode root) {
        Queue <TreeNode> q=new LinkedList<>();
        q.offer(root);
        int result=0;
        while(!q.isEmpty()){
            int size=q.size();
            int arr[]=new int[size];
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                arr[i]=node.val;

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            result+=minNoOfSwipToSort(arr);
        }
        return result;
    }
    public int minNoOfSwipToSort(int[] arr) {
    int n = arr.length;
    int[] sortedArr = Arrays.copyOf(arr, n);
    Arrays.sort(sortedArr);

    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
        indexMap.put(arr[i], i);
    }

    boolean[] visited = new boolean[n];
    int swaps = 0;

    for (int i = 0; i < n; i++) {
        if (visited[i] || arr[i] == sortedArr[i]) {
            continue;
        }

        int cycleSize = 0;
        int j = i;

        while (!visited[j]) {
            visited[j] = true;
            j = indexMap.get(sortedArr[j]);
            cycleSize++;
        }

        if (cycleSize > 1) {
            swaps += (cycleSize - 1);
        }
    }

    return swaps;
}

}