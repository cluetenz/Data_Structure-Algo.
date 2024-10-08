class Solution {
    public int minSwaps(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else if(!st.isEmpty()){
                st.pop();
            }
        }
        return (st.size()+1)/2;
        
    }
}