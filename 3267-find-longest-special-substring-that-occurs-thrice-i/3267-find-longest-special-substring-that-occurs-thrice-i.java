//Approch:-Brute Force
//T.C:-O(n^3)
class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        HashMap<String,Integer> hm=new HashMap<>();
        
        for(int i=0;i<n;i++){
            StringBuilder curr=new StringBuilder();
            for(int j=i;j<n;j++){
                if(curr.length()==0 || curr.charAt(curr.length()-1)==s.charAt(j)){
                    curr.append(s.charAt(j));
                    hm.put(curr.toString(),hm.getOrDefault(curr.toString(),0)+1);
                }else{
                    break;
                }
            }
        }
        int result=-1;
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            if(entry.getValue()>=3){
                result=Math.max(result,entry.getKey().length());
            }
        }
        return result;    
    }
}

//Approch:-Brute Force(better)
//T.C:-O(n^2)
class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        HashMap<Pair<Character,Integer>,Integer> hm=new HashMap<>();
        int len=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            len=0;
            for(int j=i;j<n;j++){
                if(s.charAt(j)==ch){
                    len++;
                    Pair<Character, Integer> key = new Pair<>(ch, len);
                    hm.put(key,hm.getOrDefault(key,0)+1);
                }else{
                    break;
                }
            }
        }
        int result=-1;
        for (Map.Entry<Pair<Character,Integer>, Integer> entry : hm.entrySet()) {
            if(entry.getValue()>=3){
                result=Math.max(result,entry.getKey().getValue());
            }
        }
        return result;    
    }
}

//Approch:-Optimal Approch using 2-d array
//T.C:-O(n)
class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int len=0;
        int [][] matrix=new int[26][n+1];
        char prevChar=s.charAt(0);

        // filling the frequency matrix
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==prevChar){
                len++;
                matrix[ch-'a'][len]+=1;
            }
            else{
                len=1;
                matrix[ch-'a'][len]+=1;
                prevChar=ch;
            }
        }
        int result=-1;
        for (int i = 0; i < 26; i++) {
            int cumSum = 0;
            for (int j = n; j >= 1; j--) {
                cumSum += matrix[i][j];
                if (cumSum >= 3) {
                    result = Math.max(result, j);
                    break;
                }
            }
        }
        return result;    
    }
}
