class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int arr[]=new int[n];
        arr[0]=values[0];
        for(int i=1;i<n;i++){
            arr[i]=Math.max(arr[i-1],values[i]+i);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            int value=values[i]-i;
            value+=arr[i-1];
            ans=Math.max(ans,value);
        }
        return ans;
    }
}