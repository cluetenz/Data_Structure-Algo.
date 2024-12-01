class Solution {
    public static int binarySearch(int []arr,int target){
        int start=0;
        int last=arr.length-1;

        int mid;
        while(start<=last){
            mid=start+(last-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                last=mid-1;
            }

        }
        return -1;

    }
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int idx=binarySearch(arr,arr[i]*2);
            if(idx != -1 && idx!=i){
                return true;
            }
        }
        return false;  
    }
}