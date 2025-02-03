class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int incLen=1;
        int decLen=1;
        int i=1;
        int res=1;
        while(i<n){
            if(nums[i]>nums[i-1]){
                incLen+=1;
                decLen=1;
            }else if(nums[i]<nums[i-1]){
                decLen+=1;
                incLen=1;
            } else {
                incLen = 1;
                decLen = 1;
            }
            res=Math.max(res,Math.max(incLen,decLen));
            i++;
        } 
        return res;
    }
}