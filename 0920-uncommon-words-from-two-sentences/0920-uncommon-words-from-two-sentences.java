class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> count=new HashMap<>();
        for(String word:s1.split(" ")){
            count.put(word,count.getOrDefault(word,0)+1);
        }
        for(String word:s2.split(" ")){
            count.put(word,count.getOrDefault(word,0)+1);
        }

        //creating list which has appered once in map
        List<String> unCommon=new ArrayList<>();

        for(var e:count.entrySet()){
            if(e.getValue()==1){
                unCommon.add(e.getKey());
            }
        }

        return unCommon.toArray(new String[0]);
        
    }
}