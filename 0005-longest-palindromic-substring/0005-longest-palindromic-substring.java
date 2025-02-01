//Brute Force 
//T.C:- O(n^3)
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=0;
        int startingPoint=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    if(j-i+1>len){
                        len=j-i+1;
                        startingPoint=i;
                    }
                }
            }
        }
        return s.substring(startingPoint, startingPoint + len);

    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}

//Memomization
//T.C:-O(n^2)

class Solution {
    private int[][]t;
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=0;
        int startingPoint=0;

        t=new int [n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    if(j-i+1>len){
                        len=j-i+1;
                        startingPoint=i;
                    }
                }
            }
        }
        return s.substring(startingPoint, startingPoint + len);

    }
    
    public boolean isPalindrome(String s,int l,int r){
        if (l >= r) {
            return true;
        }

        if (t[l][r] != -1) {
            return t[l][r] == 1;
        }

        if (s.charAt(l) == s.charAt(r)) {
            t[l][r] = isPalindrome(s, l + 1, r - 1) ? 1 : 0;
        } else {
            t[l][r] = 0;
        }

        return t[l][r] == 1;
       
    }
}
