class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set <Integer> st=new HashSet<>();

        for(int num:arr1){
            while(!st.contains(num) && num>0){
                st.add(num);
                num /= 10;
            }
        }
        int count=0;
        for(int num:arr2){
            while(!st.contains(num) && num>0){
                num /= 10;
            }
            if(num>0){
                count = Math.max(count,(int) Math.log10(num)+1);
            }
        }
        return count;
        
    }
}