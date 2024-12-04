class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int j=0;
        int i=0;
        while(i<n && j<m){
            if(str1.charAt(i)==str2.charAt(j) || str1.charAt(i)+1==str2.charAt(j) || str1.charAt(i)-25==str2.charAt(j)){
                j++;
            }
            i++;
        }
        return j==m;       
    }
}