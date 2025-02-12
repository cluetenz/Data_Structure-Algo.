class Solution {
    public int maximumSum(int[] nums) {
        int res = -1;
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int sum = digitSum(nums[i]);

            if (map.containsKey(sum)) {
                res = Math.max(res, nums[i] + map.get(sum));
                map.put(sum, Math.max(map.get(sum), nums[i]));
            } else {
                map.put(sum, nums[i]);
            }
        }
        return res;
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
