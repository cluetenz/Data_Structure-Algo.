class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] count = new int[n];
        
        // Precompute prefix sum for words starting and ending with vowels
        count[0] = isVowel(words[0]) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            count[i] = count[i - 1] + (isVowel(words[i]) ? 1 : 0);
        }
        
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if (start == 0) {
                result[i] = count[end];
            } else {
                result[i] = count[end] - count[start - 1];
            }
        }
        
        return result;
    }

    // Helper method to check if a word starts and ends with a vowel
    private boolean isVowel(String s) {
        int n = s.length();
        char first = s.charAt(0);
        char last = s.charAt(n - 1);
        return isVowelChar(first) && isVowelChar(last);
    }

    // Helper method to check if a character is a vowel
    private boolean isVowelChar(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
