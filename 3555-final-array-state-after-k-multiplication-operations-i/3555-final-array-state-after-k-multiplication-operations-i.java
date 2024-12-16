class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]==b[0])?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i],i});
        }
        while(k-->0){
            int[] curr=pq.poll();
            int val=curr[0];
            int idx=curr[1];
            val=val*multiplier;
            pq.offer(new int[]{val,idx});
        }
        int[]result=new int[n];
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int val=curr[0];
            int idx=curr[1];
            result[idx]=val;
        }
        return result;
    }
}