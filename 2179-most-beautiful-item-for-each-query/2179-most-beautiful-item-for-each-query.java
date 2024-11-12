//Approch:-sorting and using binary search
//T.C:-O(nlogn+mlogn+n)
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int maxBeautySoFar=0;
        //updating array with maximumBeauty so far
        for(int i=0;i<items.length;i++){
            maxBeautySoFar=Math.max(items[i][1],maxBeautySoFar);
            items[i][1]=maxBeautySoFar;
        }

        //updating ans array
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int idx=binarySearch(items,queries[i]);
            ans[i]=idx==-1?0:items[idx][1];
        }
        return ans;
        
    }
    private int binarySearch(int[][] items, int query) {
        int low = 0, high = items.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (items[mid][0] <= query) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}