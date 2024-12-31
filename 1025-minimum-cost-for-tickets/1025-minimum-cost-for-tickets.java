class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxValue = days[n - 1];
        int dp[] = new int[maxValue + 1];
        boolean isTravelDay[] = new boolean[maxValue + 1];

        for (int day : days) {
            isTravelDay[day] = true;
        }

        for (int i = 1; i <= maxValue; i++) {
            if (!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int d1 = costs[0] + dp[i - 1];
            int d7 = costs[1] + (i - 7 >= 0 ? dp[i - 7] : 0);
            int d30 = costs[2] + (i - 30 >= 0 ? dp[i - 30] : 0);

            dp[i] = Math.min(d1, Math.min(d7, d30));
        }

        return dp[maxValue];
    }
}
