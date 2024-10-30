class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missCount = 0, search = 1, i = 0;

        while (missCount < k) {
            if (i < arr.length && arr[i] == search) {
                i++;  // Move to the next element in arr
            } else {
                missCount++;  // Count the missing number
            }
            if (missCount == k) return search;
            search++;  // Move to the next positive integer
        }
        
        return search;
    }
}
