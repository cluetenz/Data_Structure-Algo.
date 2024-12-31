class Solution {
    private int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] memo = new int[high + 1];
        // Initialize the memo array with -1 to indicate uncomputed values
        Arrays.fill(memo, -1);
        return countHelper(0, low, high, zero, one, memo);
    }

    private int countHelper(int length, int low, int high, int zero, int one, int[] memo) {
        // If the length exceeds the maximum allowed, return 0
        if (length > high) {
            return 0;
        }

        // If this length has already been computed, return the cached result
        if (memo[length] != -1) {
            return memo[length];
        }

        int count = 0;

        // If the current length is within the valid range (>= low), count it as a valid string
        if (length >= low) {
            count = 1;
        }

        // Recursively add the counts for adding "zero" or "one" to the current length
        count = (count + countHelper(length + zero, low, high, zero, one, memo)) % mod;
        count = (count + countHelper(length + one, low, high, zero, one, memo)) % mod;

        // Cache the result for this length
        memo[length] = count;

        return count;
    }
}
//bootum up approch (dp)

class Solution {
    private final int mod = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1];
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i - one >= 0) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
        }

        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp[i]) % mod;
        }

        return ans;
    }
}
