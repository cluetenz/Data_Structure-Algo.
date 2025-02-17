class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        boolean[] used = new boolean[n];
        Set<String> result = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        solve(tiles, used, result, curr);
        return result.size() - 1;
    }
    
    private void solve(String tiles, boolean[] used, Set<String> result, StringBuilder curr) {
        result.add(curr.toString());
        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            curr.append(tiles.charAt(i));
            solve(tiles, used, result, curr);
            curr.deleteCharAt(curr.length() - 1);
            used[i] = false;
        }
    }
}
