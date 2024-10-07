class Solution {
    public int minLength(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);

        int i=0;
        int j=1;
        while(j<n){
        if(i==-1){
            i++;
            sb.setCharAt(i, sb.charAt(j));
        }
        else if((sb.charAt(j)=='B' && sb.charAt(i)=='A') || (sb.charAt(j)=='D' && sb.charAt(i)=='C')){
            i--;
        }
        else{
            i++;
            sb.setCharAt(i, sb.charAt(j));
        }
        j++;
        }
        return i+1;
        
    }
}