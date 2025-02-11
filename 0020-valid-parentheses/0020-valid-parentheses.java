//Approch:-Using Stack
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (!st.isEmpty() && st.peek() == '{') {
                    st.pop();
                } else {
                    return false;
                }
            } else if (ch == ']') {  
                if (!st.isEmpty() && st.peek() == '[') {  
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
//Approch:-Using StringBuilder

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '{' || ch == '[') {
                sb.append(ch); // Push to "stack"
            } else {
                int len = sb.length();
                if (len == 0) return false; // No opening bracket to match
                
                char last = sb.charAt(len - 1);
                
                if ((ch == ')' && last == '(') || 
                    (ch == '}' && last == '{') || 
                    (ch == ']' && last == '[')) {
                    sb.setLength(len - 1); // Pop from "stack"
                } else {
                    return false;
                }
            }
        }
        return sb.length() == 0; // Stack should be empty
    }
}

