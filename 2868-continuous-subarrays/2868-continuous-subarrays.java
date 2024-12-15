class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int i = 0, j = 0;
        long len = 0;

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.lastKey() - mp.firstKey() > 2) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
            }

            len += j - i + 1;
            j++;
        }

        return len;
    }
}
