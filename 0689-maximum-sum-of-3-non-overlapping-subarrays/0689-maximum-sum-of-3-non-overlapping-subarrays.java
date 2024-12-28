class Solution {
    private int[][]dp=new int[20001][4];
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        int n = nums.length;
        int[] sums = new int[n - k + 1];
        int windowSum = 0;
        
        // Compute sliding window sums
        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            if (i >= k - 1) {
                sums[i - k + 1] = windowSum;
                windowSum -= nums[i - k + 1];
            }
        }

        List<Integer> indices = new ArrayList<>();
        solve(sums, 0, 3, k, indices);
        return indices.stream().mapToInt(Integer::intValue).toArray();
    }

    private void solve(int[] sums, int idx, int count, int k, List<Integer> indices) {
        if (count == 0 || idx >= sums.length) {
            return;
        }
        int take = sums[idx] + helper(sums, k, idx + k, count - 1);
        int notTake = helper(sums, k, idx + 1, count);
        if (take >= notTake) {
            indices.add(idx);
            solve(sums, idx + k, count - 1, k, indices);
        } else {
            solve(sums, idx + 1, count, k, indices);
        }
    }

    private int helper(int[] sums, int k, int idx, int count) {
        if (count == 0) {
            return 0;
        }
        if (idx >= sums.length) {
            return Integer.MIN_VALUE;
        }

        if(dp[idx][count]!=-1){
            return dp[idx][count];
        }
        int take = sums[idx] + helper(sums, k, idx + k, count - 1);
        int notTake = helper(sums, k, idx + 1, count);
        dp[idx][count]= Math.max(take, notTake);
        return dp[idx][count];
    }
}
