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

//Approch 2:- Sliding window
//T.C:-O(n)
//S.C:-0(1)

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ans []=new int [n-k+1];
        int count=1;
        Arrays.fill(ans,-1);

        //1st window
        for(int i=1;i<k;i++){
            if(nums[i-1]+1==nums[i]){
                count++;
            }else{
                count=1;
            }
        }
        if(count==k){
            ans[0]=nums[k-1];
        }

        int i = 1;
        int j = k;

        // Process the sliding window
        while (j < n) {
            if (nums[j] == nums[j - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            if (count >= k) {
                ans[i] = nums[j];
            }

            i++;
            j++;
        }
        return ans;
    }
}
