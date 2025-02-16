class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        solve(0, n, res, used);
        return res;
    }
    
    private boolean solve(int idx, int n, int[] res, boolean[] used) {
        if (idx == res.length) {
            return true;
        }
        if (res[idx] != 0) {
            return solve(idx + 1, n, res, used);
        }
        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            used[num] = true;
            if (num == 1) {
                res[idx] = 1;
                if (solve(idx + 1, n, res, used)) return true;
                res[idx] = 0;
            } else {
                int secondPos = idx + num;
                if (secondPos < res.length && res[secondPos] == 0) {
                    res[idx] = num;
                    res[secondPos] = num;
                    if (solve(idx + 1, n, res, used)) return true;
                    res[idx] = 0;
                    res[secondPos] = 0;
                }
            }
            used[num] = false;
        }
        return false;
    }
}
