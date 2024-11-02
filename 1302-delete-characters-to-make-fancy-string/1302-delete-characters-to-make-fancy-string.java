class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        int count=1;
        StringBuilder sb=new StringBuilder(s);
        for(int i=1;i<sb.length();i++){
            if(sb.charAt(i)==sb.charAt(i-1)){
                count++;
                if(count>2){
                    sb.deleteCharAt(i);
                    i--;
                }
            }else{
                count=1;
            }
        }
        return sb.toString();
        
    }
}