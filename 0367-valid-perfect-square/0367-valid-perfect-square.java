class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true; // 0 and 1 are perfect squares

        long left = 1, right = num; // Use long to prevent overflow

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
