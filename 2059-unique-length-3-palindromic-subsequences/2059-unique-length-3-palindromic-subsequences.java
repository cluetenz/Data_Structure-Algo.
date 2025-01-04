class Solution {
    public int countPalindromicSubsequence(String s) {
        Set <Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        int result=0;
        for(char ch:set){
            int leftidx=-1;
            int rightidx=-1;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==ch){
                    if(leftidx==-1){
                        leftidx=i;
                    }
                    rightidx=i;
                }
            }
            Set <Character>set1=new HashSet<>();
            for(int mid=leftidx+1;mid<rightidx;mid++){
                set1.add(s.charAt(mid));
            }
            result+=set1.size();
        }
        return result;
    }
    
}