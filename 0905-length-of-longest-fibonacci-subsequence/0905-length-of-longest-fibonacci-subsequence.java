class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int[][] t = new int[n][n];
        for (int[] row : t) Arrays.fill(row, 2);
        // t[j][k] = length of the longest Fibonacci-like subsequence that ends at indices j and k in the array arr.

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }
        
        int max_length = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int target = arr[k] - arr[j];
                if (mp.containsKey(target) && mp.get(target) < j) {
                    int i = mp.get(target);
                    t[j][k] = t[i][j] + 1;
                }
                max_length = Math.max(max_length, t[j][k]);
            }
        }
        return max_length >= 3 ? max_length : 0;
    }
}