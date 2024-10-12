class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();

        // Add elements of nums1 to the set
        for (int num : nums1) {
            s.add(num);
        }

        List<Integer> res = new ArrayList<>();

        // Check elements of nums2 in the set
        for (int i = 0; i < nums2.length; i++) {
            if (s.contains(nums2[i]) && !res.contains(nums2[i])) {  // Add unique elements
                res.add(nums2[i]);
            }
        }

        // Convert List<Integer> to int[]
        int[] resultArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resultArray[i] = res.get(i);
        }

        return resultArray;
    }
}
