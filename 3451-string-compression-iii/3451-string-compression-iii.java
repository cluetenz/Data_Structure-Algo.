class Solution {
    public String compressedString(String word) {
        int n=word.length();
        String comp="";
        int i=0;
        while(i<n){
            int count=0;
            char c=word.charAt(i);
            while(i<n && count<9 && word.charAt(i)==c){
                count++;
                i++;
            }
            comp+=Integer.toString(count)+c;
        }
        return comp;   
    }
}