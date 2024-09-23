class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> lostMap=new HashMap<>();

        for(int i=0;i<matches.length;i++){
            int lose=matches[i][1];
            lostMap.put(lose,lostMap.getOrDefault(lose,0)+1);
        }
        List<Integer> noLose=new ArrayList<>();
        List<Integer> oneLose=new ArrayList<>();

        for(int i=0;i<matches.length;i++){
            int loser=matches[i][1];
            int winner=matches[i][0];

            if(lostMap.get(loser)==1){
                oneLose.add(loser);
            }
            if(!lostMap.containsKey(winner)){
                noLose.add(winner);
                lostMap.put(winner,2);
            }
        }
        Collections.sort(noLose);
        Collections.sort(oneLose);

        return Arrays.asList(noLose, oneLose);
        
    }
}