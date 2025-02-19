class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder curr=new StringBuilder();
        String result[]={""};
        int[] count = {0};
        backtracking(n,curr,k,result,count);
        return result[0];
    }
    public void backtracking(int n, StringBuilder curr, int k, String[] result,int[] count) {
        if(curr.length()==n){
            count[0]++;
            if(count[0]==k){
                result[0]=curr.toString();
            }
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                continue;
             // Do
            curr.append(ch);

            // Explore
            backtracking(n, curr, k, result,count);

            // If result is found, exit early
            if (!result[0].isEmpty()) return;

            // Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}