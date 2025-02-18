//Approch:- Brute Force
//T.C:-O(N*(n+1)!)
//S.C:-O(N+1)
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] num = new char[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            num[i] = (char) ('1' + i);
        }
        
        do {
            if (isValid(num, pattern)) {
                return new String(num);
            }
        } while (nextPermutation(num));
        
        return "";
    }
    private boolean nextPermutation(char[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) return false;
        
        int j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
        return true;
    }
    
    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(char[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private boolean isValid(char[] num, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && num[i] > num[i + 1]) {
                return false;
            }
            if (pattern.charAt(i) == 'D' && num[i] < num[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
}

//Approch:- using stack
//T.C:-O(N)
//S.C:-O(N+1)
class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        StringBuilder result=new StringBuilder();
        Stack<Character>st=new Stack<>();
        int counter=1;
        for(int i=0;i<=n;i++){
            st.push((char)('0'+counter));
            counter++;
            if(i==n || pattern.charAt(i)=='I'){
                while(!st.isEmpty()){
                    result.append(st.pop());
                }
            }
        }
        return result.toString();
    }
}
