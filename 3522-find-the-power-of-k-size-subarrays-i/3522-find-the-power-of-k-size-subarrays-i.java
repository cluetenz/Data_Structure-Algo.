class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int []ans=new int [n-k+1];
        int i=0;
        int j=k-1;
        int r=0;
        while(j<n){
            if(isSortedAndConsecutive(nums,i,j)){
                ans[r]=nums[j];
            }
            else{
                ans[r]=-1;
            }
            r++;
            i++;
            j++;
        }
        return ans;
    }
    public boolean isSortedAndConsecutive(int[] arr, int i, int j) {
    for (int k = i; k < j; k++) {
        if (arr[k] + 1 != arr[k + 1]) {  // Check for both sorted and consecutive
            return false;
        }
    }
    return true;
    }

}