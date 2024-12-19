class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxSoFar=-1;
        
        int chunks = 0;
        for (int i = 0; i < n - 1; i++) {
            maxSoFar=Math.max(arr[i],maxSoFar);
            if (maxSoFar==i) {
                chunks++;
            }
        }
        return chunks + 1;
    }
}
