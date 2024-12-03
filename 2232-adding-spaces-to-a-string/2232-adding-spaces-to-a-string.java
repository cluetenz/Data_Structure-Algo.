class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n=s.length();
        int j=0;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++){
            if(j<spaces.length && i==spaces[j]){
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }
        return result.toString();
        
    }
}