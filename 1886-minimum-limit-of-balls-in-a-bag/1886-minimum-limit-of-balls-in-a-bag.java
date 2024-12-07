//Approch:- Binary Search on Ans
//T.C:-O(nlog(maxValue(nums)))
class Solution {
    public boolean isPossible(int[] nums, int maxOperations, int mid) {
        int noOfOpr = 0;
        for (int num : nums) {
            noOfOpr += (num - 1) / mid; // Number of operations needed
        }
        return noOfOpr <= maxOperations;
    }

    public int maxValue(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l =1;
        int h = maxValue(nums);
        int result = h;

        // Binary Search
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}
