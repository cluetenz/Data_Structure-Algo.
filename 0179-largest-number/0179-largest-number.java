class Solution {
    public String largestNumber(int[] nums) {

        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrings, (a,b)->(b+a).compareTo(a+b));


    
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Build the result string
        StringBuilder sb = new StringBuilder();
        for (String num : numStrings) {
            sb.append(num);
        }

        return sb.toString();
    }
}
