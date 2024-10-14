class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue <Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int num:nums){
            pq.add(num);
        }

        while(k>0){
            int maxElement=pq.poll();
            sum+=maxElement;

            //add back after ceiling
            maxElement = (int)Math.ceil(maxElement/3.0);
            pq.add(maxElement);
            k--;
        }
        return sum;   
    }
}