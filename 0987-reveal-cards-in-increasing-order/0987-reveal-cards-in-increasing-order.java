class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        Arrays.sort(deck);
        int [] result=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        for(int i=0;i<n;i++){
            int idx=q.remove();
            result[idx]=deck[i];
            if(!q.isEmpty()){
                q.add(q.peek());
                q.remove();
            }
        }
        return result;
    }
}
