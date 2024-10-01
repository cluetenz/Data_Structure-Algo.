public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        
        // Count the remainder frequencies
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k; // Handle negative remainders
            }
            remainderCount[remainder]++;
        }
        
        // Check for valid pairings
        for (int r = 1; r < k; r++) {
            if (remainderCount[r] != remainderCount[k - r]) {
                return false;
            }
        }
        
        // Special case for remainder 0
        if (remainderCount[0] % 2 != 0) {
            return false;
        }
        return true;
    }
}
