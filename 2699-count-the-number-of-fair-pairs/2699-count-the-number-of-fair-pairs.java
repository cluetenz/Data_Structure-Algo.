//Approch :- Brute force
//T.C:- O(n^2)
//S.C:-O(1)
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i<j && (lower <= nums[i] + nums[j]) && (nums[i] + nums[j] <= upper)){
                    count++;
                }
            }
        }
        return count; 
    }
}

//Approch :- using binary search
//T.C:- O(nlogn)
//S.C:-O(1)
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        Arrays.sort(nums);
        long count=0;
        for(int i=0;i<n;i++){
            int leftIdx=lowerBound(nums,i+1,n,lower-nums[i]);
            int rightIdx=upperBound(nums,i+1,n,upper-nums[i]);

            int x=leftIdx-i-1;
            int y=rightIdx-i-1;

            count+=y-x;           
        }
        return count; 
    }
    private int lowerBound(int []nums,int start,int end,int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
     private int upperBound(int [] nums,int start,int end,int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=target){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}
