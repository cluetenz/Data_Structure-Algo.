//Approach-1 (Brute Force)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        int i = 0;
        while (i < sb.length()) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                if (i > 0) {
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
//Approch:-Using Stack
//T.C:- O(n)
//S.C:-O(n)
class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch>='a'&&ch<='z'){
                st.push(ch);
            }else if(!st.isEmpty()){
                st.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}
// Approach-3 (avoid reverse call)  
// T.C : O(n)  
// S.C : O(1)  
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='a'&&ch<='z'){
                sb.append(ch);
            }else if(sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }
        }    
        return sb.toString();
    }
}


