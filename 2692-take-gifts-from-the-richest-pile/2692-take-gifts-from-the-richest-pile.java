
class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }

        while (k > 0 && !pq.isEmpty()) {
            int maxEle = pq.poll();
            pq.offer((int) Math.sqrt(maxEle));
            k--;
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;
    }
}
