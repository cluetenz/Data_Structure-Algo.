//Approch:- using Stack
//T.C:- O(n)
//S.C:- O(n)
class Solution {
    public int minAddToMakeValid(String s) {
        Stack <Character> st=new Stack <>();
        int n= s.length();
        int openBra=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else if(!st.isEmpty()){
                st.pop();
            }
            else{
                openBra++;
            }
        }
        return openBra + st.size();
        
    }
}
//Approch;- without using stack
//T.C:-O(n)
//S.C:-O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int size=0;
        int n= s.length();
        int openBra=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                size++;
            }
            else if(size>0){
                size--;
            }
            else{
                openBra++;
            }
        }
        return openBra + size;
        
    }
}
