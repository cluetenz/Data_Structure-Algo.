

class Solution {
    class Pair {
        char ch;
        int count;
        
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);

        if (a > 0) pq.add(new Pair('a', a));
        if (b > 0) pq.add(new Pair('b', b));
        if (c > 0) pq.add(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            // Check if adding this character causes three consecutive characters
            if (result.length() >= 2 && result.charAt(result.length() - 1) == curr.ch && result.charAt(result.length() - 2) == curr.ch) {
                if (pq.isEmpty()) break; // If no alternative characters are available, break

                // Fetch the second most frequent character
                Pair next = pq.poll();
                result.append(next.ch);
                next.count--;

                // If next still has remaining counts, add it back
                if (next.count > 0) pq.add(next);

                // Add the current pair back to try again later
                pq.add(curr);
            } else {
                // Otherwise, append the current character
                result.append(curr.ch);
                curr.count--;

                // If current still has remaining counts, add it back
                if (curr.count > 0) pq.add(curr);
            }
        }

        return result.toString();
    }

}
