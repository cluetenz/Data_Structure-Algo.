class Solution {
    private void swap(int [] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
    public void sortColors(int[] nums) {
        int first=0;
        int mid=0;
        int last=nums.length-1;
        while(mid<=last){
            if(nums[mid]==0){
                swap(nums,mid,first);
                first++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,last);
                last--;
            }
        } 
    }
}