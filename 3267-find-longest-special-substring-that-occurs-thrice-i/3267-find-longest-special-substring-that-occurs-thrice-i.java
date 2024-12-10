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