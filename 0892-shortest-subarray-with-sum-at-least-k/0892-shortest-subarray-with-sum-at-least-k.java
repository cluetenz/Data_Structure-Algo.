class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        long [] prefixSum=new long [n];
        int i=0;
        int ans=Integer.MAX_VALUE;
        Deque <Integer> deq=new LinkedList<>();
        while(i<n){
            if(i==0){
                prefixSum[i]=nums[i];
            }else{
                prefixSum[i]=nums[i]+prefixSum[i-1];
            }
            if(prefixSum[i]>=k){
                ans=Math.min(ans,i+1);
            }
            while(!deq.isEmpty() && prefixSum[i]-prefixSum[deq.peekFirst()] >=k){
                ans=Math.min(ans,i-deq.peekFirst());
                deq.pollFirst();
            }

            while(!deq.isEmpty() && prefixSum[deq.peekLast()]>=prefixSum[i]){
                deq.pollLast();

            }
            deq.offerLast(i);
            i++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}