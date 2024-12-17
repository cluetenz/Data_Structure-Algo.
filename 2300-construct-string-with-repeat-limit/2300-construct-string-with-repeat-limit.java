class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int [] freq=new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        StringBuilder sb=new StringBuilder();
        int i=25;
        while(i>=0){
            if(freq[i]==0){
                i--;
                continue;
            }
            //converting index into letter/character
            char ch= (char)('a'+i);
            int m=Math.min(freq[i],repeatLimit);

            for(int j=0;j<m;j++){
                sb.append(ch);
            }

            freq[i]-=m;

            if(freq[i]>0){
                //need to find next greater character
                int k=i-1;
                while(k>=0 && freq[k]==0){
                    k--;
                }
                if(k<0){
                    break;
                }
                sb.append((char)('a'+k));
                freq[k]--;
            }
        }
        return sb.toString();  
    }
}