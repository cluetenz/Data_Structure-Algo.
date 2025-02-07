import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        Map<Integer, Integer> ballMap = new HashMap<>();  // Stores ball → color
        Map<Integer, Integer> colorMap = new HashMap<>(); // Stores color → count

        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int col = queries[i][1];

            if (ballMap.containsKey(ball)) { // If ball already has a color
                int prevCol = ballMap.get(ball);

                // Reduce the count of the previous color
                colorMap.put(prevCol, colorMap.get(prevCol) - 1);
                if (colorMap.get(prevCol) == 0) {
                    colorMap.remove(prevCol);
                }
            }

            // Update the ball with the new color
            ballMap.put(ball, col);
            colorMap.put(col, colorMap.getOrDefault(col, 0) + 1);

            ans[i] = colorMap.size(); // The number of unique colors
        }

        return ans;
    }
}
