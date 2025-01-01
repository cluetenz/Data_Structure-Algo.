class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int zero=0;
        int one=0;
        int score=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='0'){
                zero++;
            }else{
                one++;
            }
            score=Math.max(score,zero-one);
        }
        if(s.charAt(n-1)=='1'){
            one++;
        }
        return score+one;
    }
}