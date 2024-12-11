class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<int []>intervals=new ArrayList<>();
        for(int num:nums){
            intervals.add(new int[]{num-k,num+k});
        }
        intervals.sort((a,b)->Integer.compare(a[0],b[0]));

        int maxBeauty=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int [] interval:intervals){
            while(!dq.isEmpty() && dq.peekFirst()<interval[0]){
                dq.pollFirst();
            }
            dq.offerLast(interval[1]);
            maxBeauty=Math.max(maxBeauty,dq.size());
        }
        return maxBeauty;
    }
}