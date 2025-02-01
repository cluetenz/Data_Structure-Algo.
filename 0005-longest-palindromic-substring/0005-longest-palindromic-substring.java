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