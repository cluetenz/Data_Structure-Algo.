//Approch 1:- rotating everytime and checking with goal
//T.C:- O(n^2)
//S.C:-O(1)

class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        if(m!=n){
            return false;
        }
        for(int i=0;i<n;i++){
            if(s.equals((goal))){
                return true;
            }
            s=s.substring(1)+s.charAt(0);
        }
        return false;
        
    }
}