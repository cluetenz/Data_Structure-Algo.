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
//by taking O(1) space and O(n) time
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int max=values[0]+0;
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            int value=values[i]-i;
            int y=max;
            ans=Math.max(ans,value+y);
            max=Math.max(max,values[i]+i);
        }
        return ans;
    }
}
