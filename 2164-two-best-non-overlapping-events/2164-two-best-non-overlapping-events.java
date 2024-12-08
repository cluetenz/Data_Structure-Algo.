class Solution {
    private int[][] dp = new int[100001][3];
    public int BinarySearch(int[][]events,int endTime){
        int l=0;
        int r=events.length-1;
        int res=r+1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(events[mid][0]>endTime){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
    public int solve(int [][]events,int i,int count){
        if(count==2 || i>=events.length){
            return 0;
        }
         if (dp[i][count] != -1) {
            return dp[i][count];
        }
        int nextValidIdx=BinarySearch(events,events[i][1]);
        //take
        int take=events[i][2]+solve(events,nextValidIdx,count+1);
        //noTake
        int noTake=solve(events,i+1,count);
        dp[i][count]= Math.max(take,noTake);
        return dp[i][count];
    }

    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(events,0,count);   
    }
}