class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int subArraySum=nums[0];
        int minSubarraySum=nums[0];
        int maxSum=nums[0];
        int minSum=nums[0];
        for(int i=1;i<nums.length;i++){
            subArraySum=Math.max(subArraySum+nums[i],nums[i]);
            maxSum=Math.max(subArraySum,maxSum);

            minSubarraySum=Math.min(minSubarraySum+nums[i],nums[i]);
            minSum=Math.min(minSubarraySum,minSum);

        }
        return Math.max(maxSum,Math.abs(minSum));
    }
}