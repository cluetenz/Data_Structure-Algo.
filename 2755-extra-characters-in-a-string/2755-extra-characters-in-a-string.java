//using recursion and memo
//Time comp:- 0(n^3)
class Solution {
    public int solve(int start, String s, Set<String> st, int n, int[] t) {
        if (start >= n) {
            return 0;
        }
        if (t[start] != -1) {
            return t[start];
        }
        int result = 1 + solve(start + 1, s, st, n, t); // if first letter is extra

        for (int j = start; j < n; j++) {
            String curr = s.substring(start, j + 1);
            if (st.contains(curr)) {
                result = Math.min(result, solve(j + 1, s, st, n, t));
            }
        }
        return t[start] = result;
    }

    public int minExtraChar(String s, String[] dict) {
        int n = s.length();
        Set<String> st = new HashSet<>();
        for (String word : dict) {
            st.add(word); // Add dictionary words to the set
        }
        int[] t = new int[51]; // size on the basis of constraints
        Arrays.fill(t, -1);
        return solve(0, s, st, n, t);
    }
}
//using dp approch
//time complexity= O(n^2)
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
