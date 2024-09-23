class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();

        Set<String> st = new HashSet<>();
        for (String word : dictionary) {
            st.add(word); // Add dictionary words to the set
        }
        int dp []=new int[n+1];
        for(int i=n-1;i>=0;i--){
            dp[i]=1+dp[i+1];
            for(int j=i;j<n;j++){
                String curr=s.substring(i,j+1);
                if(st.contains(curr)){
                    dp[i]=Math.min(dp[i],dp[j+1]);
                }
            }
        }
        return dp[0];
        
    }
}