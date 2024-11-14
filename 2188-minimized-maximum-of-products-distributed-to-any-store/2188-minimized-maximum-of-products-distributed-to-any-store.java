class Solution {
    private int findMax(int [] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int s=1;
        int l=findMax(quantities);
        int result=0;
        while(s<=l){
            int mid=s+(l-s)/2;
            if(possibleToStore(mid,quantities,n)){
                result=mid;
                l=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return result; 
    }
    private boolean possibleToStore(int x, int []quantites,int n){
        for(int product:quantites){
            n-=(product+x-1)/x;
            if(n<0){
                return false;
            }
        }
        return true;
    }
}