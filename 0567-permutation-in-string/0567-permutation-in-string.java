class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(n<m){
            return false;
        }
        char []s1Freq=new char[26];
        char []s2Freq=new char[26];
        for(int i=0;i<m;i++){
            int idx=s1.charAt(i)-'a';
            s1Freq[idx]++;
        }

        //sliding window of size m
        int i=0;
        int j=0;
        while(j<n){
            s2Freq[s2.charAt(j)-'a']++;
            if (j - i + 1 > m) {
                s2Freq[s2.charAt(i) - 'a']--;
                i++;
            }
            if(Arrays.equals(s1Freq,s2Freq)){
                return true;
            }
            j++;
        }
        return false;
    }
}