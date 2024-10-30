//Approch:- Using simple linear Search
//T.C:- O(n)
//S.C:-O(1)
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

//Approch 2:- Using Binary Search
//T.C:- O(log n)
//S.C:- O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Missing numbers up to arr[mid]
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // left points to the index where the k-th missing number would be
        return left + k;
    }
}

