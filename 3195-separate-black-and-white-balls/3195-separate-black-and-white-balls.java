class Solution {
    public long minimumSteps(String s) {
        long blackCount=0;
        long swap=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='1'){
                blackCount++;
            }
            if(ch=='0'){
                swap +=blackCount;
            }
        }
        return swap;
        
    }
}