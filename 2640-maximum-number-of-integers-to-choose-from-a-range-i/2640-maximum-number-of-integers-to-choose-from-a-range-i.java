class Solution {
    public boolean binarySearch(int [] arr,int target){
        int high=arr.length-1;
        int low=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return false;
    }
    public int maxCount(int[] banned, int n, int maxSum) {
        int count=0;
        Arrays.sort(banned);
        int currentSum=0;

        for(int i=1;i<=n;i++){
            if(!binarySearch(banned,i) && currentSum+i<=maxSum){
                currentSum+=i;
                count++;
            }
        }
        return count;

        
    }
}