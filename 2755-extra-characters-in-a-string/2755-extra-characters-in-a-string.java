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
