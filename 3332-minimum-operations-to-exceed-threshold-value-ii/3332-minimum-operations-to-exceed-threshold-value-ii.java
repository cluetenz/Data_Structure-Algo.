import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            heap.add((long) num);
        }

        int oprCount = 0;

        while (heap.size() > 1 && heap.peek() < k) {
            long x = heap.poll();
            long y = heap.poll(); 
            heap.offer(x*2+y);
            oprCount++;

            if (heap.peek() >= k) {
                return oprCount;
            }
        }
        return oprCount;
    }
}
