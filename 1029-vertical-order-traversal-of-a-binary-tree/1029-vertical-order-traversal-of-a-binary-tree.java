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
import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, 0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int hd = curr.hd;
            int level = curr.level;
            TreeNode node = curr.node;

            map.putIfAbsent(hd, new TreeMap<>());
            map.get(hd).putIfAbsent(level, new PriorityQueue<>());
            map.get(hd).get(level).offer(node.val);

            if (node.left != null) {
                q.add(new Pair(hd - 1, level + 1, node.left));
            }
            if (node.right != null) {
                q.add(new Pair(hd + 1, level + 1, node.right));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levelMap : map.values()) {
            List<Integer> verticalList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levelMap.values()) {
                while (!nodes.isEmpty()) {
                    verticalList.add(nodes.poll());
                }
            }
            ans.add(verticalList);
        }
        return ans;
    }

    static class Pair {
        int hd;
        int level;
        TreeNode node;

        public Pair(int hd, int level, TreeNode node) {
            this.hd = hd;
            this.level = level;
            this.node = node;
        }
    }
}
