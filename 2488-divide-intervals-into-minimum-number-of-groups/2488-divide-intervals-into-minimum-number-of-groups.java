class Solution {
    public int minGroups(int[][] intervals) {
        //sorting interval based on starting point
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        //MinHeap To store end pont of the group
        PriorityQueue <Integer> pq=new PriorityQueue<>();

        for(int []interval:intervals){
            int start=interval[0];
            int end=interval[1];

            //if the top of the queue is smaller then current start time
            //then we merge the interval time into a group,so we pop the earliest end time
            if(!pq.isEmpty() && pq.peek()<start){
                pq.poll();
            }
            pq.offer(end);
        }
        return pq.size();
        
    }
}