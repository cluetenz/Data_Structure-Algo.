//Approch:- using stack
//T.C:- O(n)
//S.C:- O(n)
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


//Approch:- using variable instead of stack
//T.C:- O(n)
//S.C:- O(1)
class Solution {
    public int minSwaps(String s) {
        int n=s.length();
        int size=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='['){
                size++;
            }
            else if(size>0){
                size--;
            }
        }
        return (size+1)/2;
        
    }
}
