class Solution {
    static class trieNode{
        trieNode []child;
        int countOfPrefix; //keep the count of prefix in a word

        trieNode(){
            child=new trieNode[26];
        }
    }
    private void insert(String word,trieNode root) {
        trieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i) - 'a';
            if(curr.child[idx]==null){
                curr.child[idx]= new trieNode();
            }
            curr.child[idx].countOfPrefix += 1;
            curr=curr.child[idx];
        }    
    }
    private int getScore(String word, trieNode root) {
        trieNode curr = root;
        int score = 0;

        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i) - 'a';
            score += curr.child[idx].countOfPrefix;
            curr = curr.child[idx];
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
        int n= words.length;

        trieNode root=new trieNode();

        for(String word: words){
            insert(word,root);
        }

        int result [] = new int[n]; //for storing the sum of prefix of word
        for (int i = 0; i < n; i++) {
            result[i] = getScore(words[i], root);
        }

        return result;   
    }
}