class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            // Flip the i-th character: if '0' then '1', else '0'
            result[i] = (nums[i].charAt(i) == '0') ? '1' : '0';
        }
        return new String(result);
    }
}
