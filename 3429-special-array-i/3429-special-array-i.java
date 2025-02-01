class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n=nums.length;
        if(n==1){
            return true;
        }
        int i=0;
        int j=1;
        while(j<n){
            if((nums[i]&1)==(nums[j]&1)){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}